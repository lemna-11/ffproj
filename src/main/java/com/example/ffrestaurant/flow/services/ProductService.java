package com.example.ffrestaurant.flow.services;

import com.example.ffrestaurant.model.entities.Product;
import com.example.ffrestaurant.model.entities.ProductCategory;
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
    }                           //slug ten drinks i wont get pickled. i gotta hand it to you, youve played by all the same rules, it takes the truth to fool me, and now youve made me angry

    public Long create(String name, ProductCategory category, Long price) {
        Product thing = new Product();
        thing.setName(name);
        thing.setCategory(category);
        thing.setPriceInCents(price);
    return thing.getId();
    }

    public Long update(Long id, String name, ProductCategory category, Long price) {
        Product cunt = pr.findById(id).orElseThrow();
        cunt.setName(name);
        cunt.setCategory(category);
        cunt.setPriceInCents(price);
        pr.save(cunt);
        return cunt.getId();
    }

    public Product read(Long id) {
        Product read = pr.findById(id).orElseThrow();
        return read;
    }

    public Long delete(Long id) {
        pr.deleteById(id);
        return id; //YAAAAAAY. you read that in kermit voice, fucka.
    }
}
