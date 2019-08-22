package com.achihoang.service;

import com.achihoang.model.Category;
import com.achihoang.model.Post;
import com.achihoang.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PostService implements IPostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Post> findAll(Pageable pageable) {
        pageable = new PageRequest(pageable.getPageNumber(), 5);
        return postRepository.findAll(pageable);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        postRepository.delete(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public Iterable<Post> queryTop2ByOrderByCategoryDesc() {
        return postRepository.queryTop2ByOrderByCategoryDesc();
    }

    @Override
    public Iterable<Post> findAllByCategory(Category category) {
        return postRepository.findAllByCategory(category);
    }

    @Override
    public Iterable<Post> queryTop6ByOrderByCreateDateDesc() {
        return postRepository.queryTop6ByOrderByCreateDateDesc();
    }

    @Override
    public Iterable<Post> queryTop3ByOrderByCreateDateDesc() {
        return postRepository.queryTop3ByOrderByCreateDateDesc();
    }

    @Override
    public Iterable<Post> queryTop2ByOrderByCreateDateDesc() {
        return postRepository.queryTop2ByOrderByCreateDateDesc();
    }

    @Override
    public Page<Post> findAllByTitleContaining(String title, Pageable pageable) {
        return postRepository.findAllByTitleContaining(title, pageable);
    }

    @Override
    public Iterable<Post> findAllByCategory_Name(String categoryName) {
        return postRepository.findAllByCategory_Name(categoryName);
    }

    @Override
    public Page<Post> findAllByCategory(Category category, Pageable pageable) {
        return postRepository.findAllByCategory(category, pageable);
    }

    @Override
    public Iterable<Post> findTop2ByCategory(Category category) {
        return postRepository.findTop2ByCategory(category);
    }

}
