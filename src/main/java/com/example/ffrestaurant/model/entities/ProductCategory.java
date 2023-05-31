package com.example.ffrestaurant.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "restaurant_prodcat")
@Data
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
}
