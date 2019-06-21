package com.codegym.service;
import com.codegym.model.Product;

import java.util.List;

public interface ProductService {

    List<Product>findAll();

    void save(Product product);

    void update(int id, Product product);

    void remote(int id);

    Product findByID(int id);

    Product findByName (String name);
}
