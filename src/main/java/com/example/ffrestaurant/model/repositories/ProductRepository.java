package com.example.ffrestaurant.model.repositories;

import com.example.ffrestaurant.model.entities.Product;
import com.example.ffrestaurant.model.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory(ProductCategory category);
}
