package com.codegym.demoClothingManagement.service;

import com.codegym.demoClothingManagement.model.Product;

import java.util.List;

public interface IProductDAO {

    public void createProduct(Product product);

    public Product getProductById(int idProduct);

    public List<Product> getAllProducts();

    public void updateProduct(int idProduct, Product product);

    public void deleteProduct(Product product);
}
