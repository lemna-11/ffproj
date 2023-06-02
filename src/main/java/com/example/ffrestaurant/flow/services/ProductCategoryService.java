package com.example.ffrestaurant.flow.services;

import com.example.ffrestaurant.flow.exceptions.CategoryAlreadyExistsException;
import com.example.ffrestaurant.flow.mapper.CategoryMapper;
import com.example.ffrestaurant.model.entities.Product;
import com.example.ffrestaurant.model.entities.ProductCategory;
import com.example.ffrestaurant.model.repositories.ProductCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {
    private ProductCategoryRepository pcr;

    public ProductCategoryService(ProductCategoryRepository pcr){
        this.pcr = pcr;
    }

    public List<ProductCategory> all() {
        return pcr.findAll();
    }

    public void add(String value) throws CategoryAlreadyExistsException {
        if(pcr.existsByCategoryName(value)){
            throw new CategoryAlreadyExistsException();
        }
        pcr.save(CategoryMapper.toEntity(value));
    }

    public Long create(String categoryName) {
        ProductCategory newp = new ProductCategory();
        newp.setCategoryName(categoryName);
        newp = pcr.save(newp);
        return newp.getId();
    }

    public Long update(Long id, String categoryName) {
        ProductCategory newc = pcr.findById(id).orElseThrow();
        newc.setCategoryName(categoryName);
        newc = pcr.save(newc);
        return newc.getId();
    }

    public ProductCategory read(Long id) {
        ProductCategory readc  = pcr.findById(id).orElseThrow();
        return readc;
    }

    public Long delete(Long id) {
        pcr.deleteById(id);
        return id; //clever shit here, remember it
    }
}
