package com.achihoang.service;

import com.achihoang.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategory {
    Page<Category> findAll(Pageable pageable);

    Category findById(Long id);

    void save(Category category);

    void remove(Long id);

    //admin
    Page<Category> findAllByLocale(String locale, Pageable pageable);
    //home
    Iterable<Category> findAllByLocale(String en);
    //category
    Iterable<Category> findFirstByLocaleAndId(String locale,Long id);
}
