package com.achihoang.repository;

import com.achihoang.model.Category;
import com.achihoang.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    Iterable<Post> findAllByCategory(Category category);


    Page<Post> findAllByTitleContaining(String title, Pageable pageable);
}
