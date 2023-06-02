package com.example.ffrestaurant.flow.services;

import com.example.ffrestaurant.model.entities.Order;
import com.example.ffrestaurant.model.entities.OrderStatus;
import com.example.ffrestaurant.model.entities.Product;
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

    public Long create(List<Product> products, OrderStatus status) {
        Order wolfenstein =  new Order();
        wolfenstein.setProducts(products);
        wolfenstein.setStatus(status);
        wolfenstein = or.save(wolfenstein);
        return wolfenstein.getId();     //MAKE THAT BASTARD WALK THE PLANK WITH A RUM AND A YOHOHO
    }

    public Long update(Long id, List<Product> products, OrderStatus status) {
        Order warhammer = or.findById(id).orElseThrow();
        warhammer.setProducts(products);
        warhammer.setStatus(status);
        or.save(warhammer);
        return warhammer.getId();
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
