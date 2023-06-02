package com.example.ffrestaurant.view.controllers;

import com.example.ffrestaurant.flow.services.ProductService;
import com.example.ffrestaurant.model.entities.Order;
import com.example.ffrestaurant.model.entities.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Long create(@RequestParam("name") String name,
                       @RequestParam("category") ProductCategory category,
                       @RequestParam("price") Long price){
        return -1L;
    }

    @PostMapping("/update")
    public Long update(@RequestParam("id") Long id,
                       @RequestParam("name") String name,
                       @RequestParam("category") ProductCategory category,
                       @RequestParam("price") Long price){
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
