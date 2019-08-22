package com.achihoang.service;

import com.achihoang.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);

    Category findById(Long id);

    void save(Category category);

    void delete(Long id);

    Iterable<Category> queryAllByName(String name);

    Iterable<Category> findAll();

    Iterable<Category> findFirstByName(Category category);
}
