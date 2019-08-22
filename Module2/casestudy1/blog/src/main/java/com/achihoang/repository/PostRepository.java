package com.achihoang.repository;

import com.achihoang.model.Category;
import com.achihoang.model.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post,Long> {
    Iterable<Post> findAllByCategory(Category category);
}
