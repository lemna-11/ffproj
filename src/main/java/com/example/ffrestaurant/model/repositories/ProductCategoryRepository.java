package com.example.ffrestaurant.model.repositories;

import com.example.ffrestaurant.model.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    boolean existsByCategoryName(String name);


    Optional<ProductCategory> findByCategoryName(String categoryName);
}
