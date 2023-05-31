package com.example.ffrestaurant.model.repositories;

import com.example.ffrestaurant.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
