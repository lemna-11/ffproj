package com.example.ffrestaurant.view.controllers;

import com.example.ffrestaurant.flow.services.OrderService;
import com.example.ffrestaurant.model.entities.Order;
import com.example.ffrestaurant.model.entities.OrderStatus;
import com.example.ffrestaurant.model.entities.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public Long create(@RequestParam("products") List<Product> products, @RequestParam("status") OrderStatus status){
        return -1L;
    }

    @PostMapping("/update")
    public Long update(@RequestParam("id") Long id, @RequestParam("products") List<Product> products, @RequestParam("status") OrderStatus status){
        return -1L;
    }

    @GetMapping("/read")
    public Order read(@RequestParam("id") Long id){
        return new Order();
    }

    @DeleteMapping("/delete")
    public Long delete(@RequestParam("id") Long id){
        return -1L;
    }
}
