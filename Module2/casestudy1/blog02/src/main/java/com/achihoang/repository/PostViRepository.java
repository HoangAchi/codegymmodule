package com.achihoang.repository;

import com.achihoang.model.CategoryVi;
import com.achihoang.model.PostVi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostViRepository extends PagingAndSortingRepository<PostVi,Long> {
    Iterable<PostVi> findAllByCategoryVi(CategoryVi categoryVi);
    //home

    Iterable<PostVi> queryTop2ByOrderByCategoryViDesc();

    Iterable<PostVi> queryTop2ByOrderByNgaytaoDesc();

    Iterable<PostVi> queryTop3ByOrderByNgaytaoDesc();

    Iterable<PostVi> queryTop6ByOrderByNgaytaoDesc();

    Page<PostVi> findAllByTieudeContaining(String tieude, Pageable pageable);

    Iterable<PostVi> findAllByCategoryVi_Name(String categoryName);

    Page<PostVi> findAllByCategoryVi(CategoryVi categoryVi,Pageable pageable);

    Iterable<PostVi> findTop2ByCategoryVi (CategoryVi categoryVi);
}
