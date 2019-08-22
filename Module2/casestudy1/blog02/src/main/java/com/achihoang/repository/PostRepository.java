package com.achihoang.repository;

import com.achihoang.model.Category;
import com.achihoang.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    Iterable<Post> queryTop2ByOrderByCategoryDesc();

    Iterable<Post> queryTop2ByOrderByCreateDateDesc();

    Iterable<Post> queryTop3ByOrderByCreateDateDesc();

    Iterable<Post> queryTop6ByOrderByCreateDateDesc();

    Page<Post> findAllByTitleContaining(String title, Pageable pageable);

    Iterable<Post> findAllByCategory_Name(String categoryName);

    Iterable<Post> findAllByCategory(Category category);

    Page<Post> findAllByCategory(Category category,Pageable pageable);

    Iterable<Post> findTop2ByCategory (Category category);

}
