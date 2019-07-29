package com.achihoang.repository;

import com.achihoang.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository  extends PagingAndSortingRepository <Product, Long> {
}
