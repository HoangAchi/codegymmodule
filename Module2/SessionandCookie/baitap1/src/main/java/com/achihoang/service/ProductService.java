package com.achihoang.service;

import com.achihoang.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    Product findById(Long id);

    void remove(Long id);

    void save(Product product);
}
