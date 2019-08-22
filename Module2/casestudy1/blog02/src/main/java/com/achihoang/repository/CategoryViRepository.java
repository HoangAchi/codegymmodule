package com.achihoang.repository;

import com.achihoang.model.CategoryVi;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryViRepository extends PagingAndSortingRepository<CategoryVi,Long> {
    Iterable<CategoryVi> findAllByName(String name);
}
