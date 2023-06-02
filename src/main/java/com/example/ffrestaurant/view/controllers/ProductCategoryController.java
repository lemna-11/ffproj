package com.example.ffrestaurant.view.controllers;

import com.example.ffrestaurant.flow.services.ProductCategoryService;

import com.example.ffrestaurant.model.entities.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productcategory")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping("/create")
    public Long create(@RequestParam("name") String categoryName){
        Long id;
        try {
            id = productCategoryService.create(categoryName);
        } catch (Exception e){
            throw e;
        }
        return id;
    }

    @PostMapping("/update")
    public Long update(@RequestParam("id") Long id, @RequestParam("name") String categoryName){
        return -1L;
    }

    @GetMapping("/read")
    public ProductCategory read(@RequestParam("id") Long id){
        return new ProductCategory();
    }

    @DeleteMapping("/delete")
    public Long delete(@RequestParam("id") Long id){
        return -1L;
    }
}
