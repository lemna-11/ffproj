package com.example.ffrestaurant.view.controllers;

import com.example.ffrestaurant.flow.services.ProductCategoryService;
import com.example.ffrestaurant.model.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productcategory")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping("/create")
    public Long create(@RequestParam("name") String categoryName){
        return -1L;
    }

    @PostMapping("/update")
    public Long update(@RequestParam("id") Long id, @RequestParam("name") String categoryName){
        return -1L;
    }

    @GetMapping("/read")
    public Order read(@RequestParam("id") Long id){
        return new Order();
    }

    @DeleteMapping("/delete")
    public Long delete(@RequestParam("id") Long id){
        return -1L;
    }
}
