package com.example.ffrestaurant.view.controllers;

import com.example.ffrestaurant.flow.services.OrderService;
import com.example.ffrestaurant.model.entities.OrderStatus;
import com.example.ffrestaurant.model.entities.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public Long create(@RequestParam("products")List<Product> products, OrderStatus status){
        //TODO:
        return -1L;
    }
}
