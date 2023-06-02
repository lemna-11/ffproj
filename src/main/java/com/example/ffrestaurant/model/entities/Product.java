package com.example.ffrestaurant.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "restaurant_product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //...bruh.
    private Long id;
    private String name;
    @ManyToOne
    private ProductCategory category;
    private Long priceInCents;
}