package com.achihoang.service;

import com.achihoang.model.Category;
import com.achihoang.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Page<Post> findAll(Pageable pageable);

    Post findById(Long id);

    void save(Post post);

    void remove(Long id);

    Iterable<Post> findAllByCategory(Category category);


    Page<Post> findAllByTitleContaining(String title, Pageable pageable);
}
