package com.example.ffrestaurant.view.controllers;

import com.example.ffrestaurant.flow.services.OrderService;
import com.example.ffrestaurant.model.entities.Order;
import com.example.ffrestaurant.model.entities.OrderStatus;
import com.example.ffrestaurant.model.entities.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public Long create(@RequestParam("products") List<Product> products, @RequestParam("status") OrderStatus status){
        Long id;
        try{
            id =  orderService.create(products, status);
        } catch (Exception e){
            throw e;
        }
        return id;
    }

    @PostMapping("/update")
    public Long update(@RequestParam("id") Long id, @RequestParam("products") List<Product> products, @RequestParam("status") OrderStatus status){
        Long updatedid;
        try{
            updatedid = orderService.update(id, products, status); //so product, status, and id? how lovely trinity isnt it?
            //oh lovely...so just return?thats...that looks too simple to be the case ngl

        } catch (Exception e){
            throw e;
        }
        return updatedid; //YOU CANT KILL CLOWN
    }

    @GetMapping("/read")
    public Order read(@RequestParam("id") Long id){
        Order read;
        try{
            read = orderService.read(id);
        }catch(Exception e){
            throw e;
        }
        return read;
    }

    @DeleteMapping("/delete")
    public Long delete(@RequestParam("id") Long id){
        //thats one way to go down
        Long lastorder;
        try{
            lastorder = orderService.delete(id);
        }catch (Exception e){
            throw e; //i try to have a laugh, i didnt win the game of life, but id give myself a pass
        }
        return lastorder;
    }
}
