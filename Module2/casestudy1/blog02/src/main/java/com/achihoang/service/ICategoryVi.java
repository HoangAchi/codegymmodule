package com.achihoang.service;

import com.achihoang.model.CategoryVi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryVi {
    Page<CategoryVi> findAll(Pageable pageable);

    CategoryVi findById(Long id);

    void save(CategoryVi categoryVi);

    void delete(Long id);

    Iterable<CategoryVi> findAllByName(String name);

    Iterable<CategoryVi> findAll();

}
