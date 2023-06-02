package com.example.ffrestaurant.view.providers;

import com.example.ffrestaurant.flow.services.OrderService;
import com.example.ffrestaurant.flow.services.ProductCategoryService;
import com.example.ffrestaurant.flow.services.ProductService;
import com.example.ffrestaurant.model.entities.Order;
import com.example.ffrestaurant.model.entities.Product;
import com.example.ffrestaurant.model.entities.ProductCategory;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class AdminViewProvider {
    @Contract(mutates = "param1")
    public static void addOrderGrid(AppLayout layout, OrderService orderService){
        Grid<Order> orderGrid = AdminViewProvider.orderGrid();
        Button openOrders = new Button("Orders");
        openOrders.addClickListener(e -> {
            orderGrid.setItems(orderService.all());
            layout.setContent(orderGrid);
        });
        layout.addToDrawer(openOrders);
    }

    @Contract(mutates = "param1")
    public static void addProductGrid(AppLayout layout, ProductService productService){
        Grid<Product> productGrid = AdminViewProvider.productGrid();
        Button openProducts = new Button("Products");
        openProducts.addClickListener(e -> {
            productGrid.setItems(productService.all());
            layout.setContent(productGrid);
        });
        layout.addToDrawer(openProducts);
    }

    @Contract(mutates = "param1")
    public static void addProductCategoryGrid(AppLayout layout, ProductCategoryService productCategoryService){
        final Grid<ProductCategory> productCategoryGrid = AdminViewProvider.productCategoryGrid();
        final Button categoryButton = new Button("Category");
        categoryButton.addClickListener(e -> {
            productCategoryGrid.setItems(productCategoryService.all());
            layout.setContent(productCategoryGrid);
        });
        layout.addToDrawer(categoryButton);
    }

    @Contract(pure = true)
    public static @NotNull Grid<ProductCategory> productCategoryGrid(){
        final Grid<ProductCategory> productGrid = new Grid<>(ProductCategory.class, false);
        productGrid.addColumn(ProductCategory::getCategoryName).setHeader("Name");
        productGrid.addColumn(ProductCategory::getId).setHeader("Id");
        return productGrid;
    }

    @Contract(pure = true)
    public static @NotNull Grid<Order> orderGrid(){
        final Grid<Order> orderGrid = new Grid<>(Order.class, false);
        orderGrid.addColumn(Order::getPriceInCents).setHeader("Price");
        orderGrid.addColumn(Order::getStatus).setHeader("Status");
        orderGrid.addColumn(Order::getProducts).setHeader("Products");
        return orderGrid;
    }

    @Contract(pure = true)
    public static @NotNull Grid<Product> productGrid(){
        final Grid<Product> productGrid = new Grid<>(Product.class, false);
        productGrid.addColumn(Product::getName).setHeader("Name");
        productGrid.addColumn(Product::getPriceInCents).setHeader("Price");
        productGrid.addColumn(Product::getCategory).setHeader("Category");
        return productGrid;
    }
}
