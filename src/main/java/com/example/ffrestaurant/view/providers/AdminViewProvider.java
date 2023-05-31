package com.example.ffrestaurant.view.providers;

import com.example.ffrestaurant.flow.services.OrderService;
import com.example.ffrestaurant.model.entities.Order;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class AdminViewProvider {
    @Contract(pure = true)
    public static @NotNull List<Button> baseDrawerButtons(OrderService orderService, HorizontalLayout content){
        List<Button> buttons = new ArrayList<>();
        Grid<Order> orderGrid = AdminViewProvider.orderGrid();
        Button openOrders = new Button("Orders");
        openOrders.addClickListener(e -> {
            orderGrid.setItems(orderService.all());
            content.removeAll();
            content.add(orderGrid);
        });
        buttons.add(openOrders);
        return buttons;
    }

    @Contract(pure = true)
    public static @NotNull Grid<Order> orderGrid(){
        return null;
    }
}
