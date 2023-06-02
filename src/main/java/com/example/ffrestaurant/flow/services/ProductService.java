package com.example.ffrestaurant.flow.services;

import com.example.ffrestaurant.model.entities.Product;
import com.example.ffrestaurant.model.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository pr;     //oh no, there will be blood shed, its the only thing i ever known!

    public ProductService(ProductRepository pr){
        this.pr = pr;
    }

    public List<Product> all() {
        return pr.findAll();
    }
}
