package com.example.ffrestaurant.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "restaurant_order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<Product> products;
    private OrderStatus status;

    public Long getPriceInCents(){
        return products.stream()
                .map(Product::getPriceInCents)
                .reduce(Long::sum)
                .orElseThrow();
    }
}
