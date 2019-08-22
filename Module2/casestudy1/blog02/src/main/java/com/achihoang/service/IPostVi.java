package com.achihoang.service;

import com.achihoang.model.CategoryVi;
import com.achihoang.model.PostVi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPostVi {
    Page<PostVi> findAll(Pageable pageable);

    PostVi findById(Long id);

    void remove(Long id);

    void save(PostVi postVi);

    Iterable<PostVi> queryTop2ByOrderByCategoryViDesc ();

    Iterable<PostVi> findAllByCategoryVi(CategoryVi categoryVi);

    Iterable<PostVi> queryTop6ByOrderByNgaytaoDesc();

    Iterable<PostVi> queryTop2ByOrderByNgaytaoDesc();

    Iterable<PostVi> queryTop3ByOrderByNgaytaoDesc();

    Page<PostVi> findAllByTieudeContaining(String tieude, Pageable pageable);

    Iterable<PostVi> findAllByCategoryVi_Name(String categoryName);


    Page<PostVi> findAllByCategoryVi(CategoryVi categoryVi,Pageable pageable);

    Iterable<PostVi> findTop2ByCategoryVi (CategoryVi categoryVi);
}
