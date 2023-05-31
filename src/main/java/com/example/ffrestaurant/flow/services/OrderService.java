package com.example.ffrestaurant.flow.services;

import com.example.ffrestaurant.model.entities.Order;
import com.example.ffrestaurant.model.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository or;

    public OrderService(OrderRepository or){
        this.or = or;
    }

    public List<Order> all() {
        return or.findAll();
    }
}
