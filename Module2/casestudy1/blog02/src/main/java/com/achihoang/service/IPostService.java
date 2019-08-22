package com.achihoang.service;

import com.achihoang.model.Category;
import com.achihoang.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPostService {
    Page<Post> findAll(Pageable pageable);

    Post findById(Long id);

    void remove(Long id);

    void save(Post post);

    Iterable<Post> queryTop2ByOrderByCategoryDesc ();

    Iterable<Post> findAllByCategory(Category category);

    Iterable<Post> queryTop6ByOrderByCreateDateDesc();

    Iterable<Post> queryTop2ByOrderByCreateDateDesc();

    Iterable<Post> queryTop3ByOrderByCreateDateDesc();

    Page<Post> findAllByTitleContaining(String title, Pageable pageable);

    Iterable<Post> findAllByCategory_Name(String categoryName);


    Page<Post> findAllByCategory(Category category,Pageable pageable);

    Iterable<Post> findTop2ByCategory (Category category);
}
