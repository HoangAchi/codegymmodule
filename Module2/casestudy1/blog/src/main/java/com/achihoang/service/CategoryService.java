package com.achihoang.service;

import com.achihoang.model.Category;
import com.achihoang.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

    Category findById(Long id);

    void save (Category category);

    void remove (Long id);

}
