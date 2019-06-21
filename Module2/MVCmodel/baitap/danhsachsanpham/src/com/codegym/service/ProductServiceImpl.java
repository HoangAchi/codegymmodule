package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"Unity",3,500000));
        products.put(2,new Product(2,"Game market",2,200000));
    }

    @Override
    public List<Product> findAll(){
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product){
        products.put(product.getId(),product);
    }

    @Override
    public void update(int id, Product product){
        products.put(id,product);
    }

    @Override
    public void remote(int id){
        products.remove(id);
    }

    @Override
    public Product findByID(int id){
        return products.get(id);
    }

    @Override
    public Product findByName(String name){return  products.get(name);}
}
