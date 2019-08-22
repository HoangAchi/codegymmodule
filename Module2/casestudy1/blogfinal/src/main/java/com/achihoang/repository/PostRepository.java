package com.achihoang.repository;

import com.achihoang.model.Category;
import com.achihoang.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    //admin
    Page<Post> findAllByLocale(String locale, Pageable pageable);

    Iterable<Post> findAllByCategory(Category category);

    //home
    Iterable<Post> queryTop2ByLocaleOrderByCreateDateDesc(String locale);

    Iterable<Post> queryTop6ByLocaleOrderByCreateDateDesc(String locale);

    Iterable<Post> queryTop3ByLocaleOrderByCreateDateDesc(String locale);

    Page<Post> findAllByLocaleAndTitleContaining(String locale, String title, Pageable pageable);

    //category
    Page<Post> findAllByCategoryAndLocale(Category category, Pageable pageable, String locale);

    Page<Post> findAllByCategoryAndLocaleAndTitle(Category category, Pageable pageable, String title, String locale);

    Iterable<Post> queryTop2ByLocaleAndCategoryOrderByCreateDateDesc(String locale, Category category);

    //blog
    Iterable<Post> findPostByLocaleAndId(String locale, Long id);
}
