package com.achihoang.repository;

import com.achihoang.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
    //admin
    Page<Category> findAllByLocale(String en,Pageable pageable);
    //home
    Iterable<Category> findAllByLocale(String en);
    //category
    Iterable<Category> findFirstByLocaleAndId(String locale,Long id);
}
