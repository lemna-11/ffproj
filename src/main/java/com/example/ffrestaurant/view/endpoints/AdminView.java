package com.example.ffrestaurant.view.endpoints;

import com.example.ffrestaurant.flow.exceptions.CategoryAlreadyExistsException;
import com.example.ffrestaurant.flow.services.OrderService;
import com.example.ffrestaurant.flow.services.ProductCategoryService;
import com.example.ffrestaurant.flow.services.ProductService;
import com.example.ffrestaurant.model.entities.Order;
import com.example.ffrestaurant.model.entities.Product;
import com.example.ffrestaurant.model.entities.ProductCategory;
import com.example.ffrestaurant.view.providers.NavigationBar;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("/admin")
public class AdminView extends AppLayout {
    public AdminView(OrderService orderService, ProductService productService, ProductCategoryService productCategoryService){
        addToNavbar(NavigationBar.title("Admin"));
        NavigationBar.Routes("admin").forEach(this::addToNavbar);

        HorizontalLayout content = new HorizontalLayout();
        setContent(content);

        final Grid<Order> orderGrid = new Grid<>(Order.class, false);
        orderGrid.addColumn(Order::getPriceInCents).setHeader("Price");
        orderGrid.addColumn(Order::getStatus).setHeader("Status");
        orderGrid.addColumn(Order::getProducts).setHeader("Products");
        Button openOrders = new Button("Orders");
        openOrders.addClickListener(e -> {
            orderGrid.setItems(orderService.all());
            content.removeAll();
            content.add(orderGrid);
        });
        addToDrawer(openOrders);

        final Grid<Product> productGrid = new Grid<>(Product.class, false);
        productGrid.addColumn(Product::getName).setHeader("Name");
        productGrid.addColumn(Product::getPriceInCents).setHeader("Price");
        productGrid.addColumn(Product::getCategory).setHeader("Category");
        Button openProducts = new Button("Products");
        openProducts.addClickListener(e -> {
            productGrid.setItems(productService.all());
            content.removeAll();
            content.add(productGrid);
        });
        addToDrawer(openProducts);

        final Grid<ProductCategory> productCategoryGrid = new Grid<>(ProductCategory.class, false);
        productCategoryGrid.addColumn(ProductCategory::getCategoryName).setHeader("Name");
        productCategoryGrid.addColumn(ProductCategory::getId).setHeader("Id");
        final VerticalLayout addCategory = new VerticalLayout();
        final TextField addTextField = new TextField("Category name");
        final Button addButton = new Button("Add category");
        addButton.addClickListener(e -> {
            try {
               productCategoryService.add(addTextField.getValue());
            } catch (CategoryAlreadyExistsException error) {
               final Notification notification = new Notification("Category already exists", 5, Notification.Position.BOTTOM_CENTER);
               notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
               content.add(notification);
            }
            productCategoryGrid.setItems(productCategoryService.all());
            productCategoryGrid.addContextMenu();
            content.removeAll();
            content.addAndExpand(productCategoryGrid);
            content.add(addCategory);
        });
        addCategory.add(addTextField);
        addCategory.add(addButton);
        addCategory.setMaxWidth(5.5f, Unit.CM);
        final Button openCategories = new Button("Categories");
        openCategories.addClickListener(e -> {
            productCategoryGrid.setItems(productCategoryService.all());
            content.removeAll();
            content.add(addCategory);
            content.add(productCategoryGrid);
        });
        addToDrawer(openCategories);
    }
}
