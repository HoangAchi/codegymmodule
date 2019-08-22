package com.achihoang.repository;

import com.achihoang.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
    Iterable<Category> queryAllByName(String name);

    Iterable<Category> findFirstByName(Category category);
}
