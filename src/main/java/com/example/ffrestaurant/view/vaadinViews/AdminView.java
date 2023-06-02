package com.example.ffrestaurant.view.vaadinViews;

import com.example.ffrestaurant.flow.services.OrderService;
import com.example.ffrestaurant.flow.services.ProductCategoryService;
import com.example.ffrestaurant.flow.services.ProductService;
import com.example.ffrestaurant.model.entities.Order;
import com.example.ffrestaurant.model.entities.Product;
import com.example.ffrestaurant.model.entities.ProductCategory;
import com.example.ffrestaurant.view.providers.AdminViewProvider;
import com.example.ffrestaurant.view.providers.NavigationBar;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.Route;
import org.jetbrains.annotations.Contract;

@Route("/admin")
public class AdminView extends AppLayout {
    private final ProductService productService;
    private final ProductCategoryService productCategoryService;
    private final OrderService orderService;
    public AdminView(OrderService orderService, ProductService productService, ProductCategoryService productCategoryService){
        this.orderService = orderService;
        this.productService = productService;
        this.productCategoryService = productCategoryService;

        addToNavbar(NavigationBar.title("Admin"));
        NavigationBar.Routes("admin").forEach(this::addToNavbar);

        openHomeView();
    }

    @Contract(mutates = "this")
    private void openHomeView(){
        final Grid<Order> orderGrid = AdminViewProvider.orderGrid();
        final Button openOrders = new Button("Orders");
        openOrders.addClickListener(e -> {
            orderGrid.setItems(orderService.all());
            setContent(orderGrid);
        });
        final Grid<Product> productGrid = AdminViewProvider.productGrid();
        final Button openProducts = new Button("Products");
        openProducts.addClickListener(e -> {
            productGrid.setItems(productService.all());
            setContent(productGrid);
        });

        final Grid<ProductCategory> productCategoryGrid = AdminViewProvider.productCategoryGrid();
        final Button categoryButton = new Button("Category");
        categoryButton.addClickListener(e -> {
            productCategoryGrid.setItems(productCategoryService.all());
            setContent(productCategoryGrid);
        });
        addToDrawer(categoryButton);
        addToDrawer(openProducts);
        addToDrawer(openOrders);
    }
}
