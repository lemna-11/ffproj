package com.example.ffrestaurant.flow.services;

import com.example.ffrestaurant.model.entities.Order;
import com.example.ffrestaurant.model.repositories.OrderRepository;
import com.example.ffrestaurant.model.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository or;
    private final ProductRepository pr;

    public OrderService(OrderRepository or, ProductRepository pr){
        this.or = or;
        this.pr = pr;
    }

    public List<Order> all() {
        return or.findAll();
    }

    public Long create(Order order) {
        return or.save(order).getId();     //MAKE THAT BASTARD WALK THE PLANK WITH A RUM AND A YOHOHO
    }

    public Long update(Order order) {
        or.findById(order.getId()).orElseThrow();
        order = or.save(order);
        return order.getId();
    }

    public Order read(Long id) {
        Order reado = or.findById(id).orElseThrow();
        return reado;           //bounce ahead couple of years,king of my peers, we biked the block, cheersin pretty girls beers
    }

    public Long delete(Long id) {
        or.deleteById(id);
        return id;
    }
}
