package com.achihoang.service;

import com.achihoang.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    private static Map<Integer, Product> productMap;
    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1,"game",3,100000));
        productMap.put(2, new Product(2,"design",3,100000));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void remote(int id) {
        productMap.remove(id);
    }

    @Override
    public Product findByID(int id) {
        return  productMap.get(id);
    }

    @Override
    public Product findByName(String name) {
        return productMap.get(name);
    }
}
