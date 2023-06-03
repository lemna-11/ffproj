package com.example.ffrestaurant.view.controllers;

import com.example.ffrestaurant.flow.services.ProductService;
import com.example.ffrestaurant.model.entities.Order;
import com.example.ffrestaurant.model.entities.Product;
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
        Long id;
        try{
            id = productService.create(name, category, price);
       } catch(Exception e){
            throw e; //SENDS EXCEPTION TO ITS PARENTS LMAO..sounds like one way to throw out an autistic kid lmao
        }
        return id;
    }

    @PostMapping("/update")
    public Long update(@RequestParam("id") Long id,
                       @RequestParam("name") String name,
                       @RequestParam("category") ProductCategory category,
                       @RequestParam("price") Long price){
        Long updatedpr;
        try{
            updatedpr = productService.update(id, name, category, price);
        } catch(Exception e){
            throw e; //KEEHAUL THAT FILTHY LANDLOVER, SEND HIM DOWN TO THE DEPTHS DOWN BELOW, MAKE THAT BASTARD WALK THE PLANK WITH A BOTTLE OF A RUM AND A YOHOHO
        }
        return updatedpr;
    }

    @GetMapping("/read")
    public Product read(@RequestParam("id") Long id){
        Product read;
        try{
            read = productService.read(id);
        }catch(Exception e){
            throw e;
        }
        return read;
    }

    @DeleteMapping("/delete")
    public Long delete(@RequestParam("id") Long id){
        Long deletepro;
        try{
            deletepro = productService.delete(id);
        }catch (Exception e){
            throw e;
        }
        return deletepro;
    }
}
