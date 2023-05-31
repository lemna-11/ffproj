package com.example.ffrestaurant.flow.mapper;

import com.example.ffrestaurant.model.entities.ProductCategory;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {
    public ProductCategory toEntity(String name){
        ProductCategory p =  new ProductCategory();
        p.setCategoryName(name);
        return p;
    }
}
