package com.achihoang.service.impl;

import com.achihoang.model.Category;
import com.achihoang.model.Post;
import com.achihoang.repository.PostRepository;
import com.achihoang.service.IPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class PostService implements IPost {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Post> findAll(Pageable pageable) {
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
    public Page<Post> findAllByLocale(String locale, Pageable pageable) {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "createDate"));
        pageable = new PageRequest(pageable.getPageNumber(), 5, sort);
        return postRepository.findAllByLocale(locale, pageable);
    }

    @Override
    public Iterable<Post> findAllByCategory(Category category) {
        return postRepository.findAllByCategory(category);
    }

    @Override
    public Iterable<Post> queryTop2ByLocaleOrderByCreateDateDesc(String locale) {
        return postRepository.queryTop2ByLocaleOrderByCreateDateDesc(locale);
    }

    @Override
    public Iterable<Post> queryTop6ByLocaleOrderByCreateDateDesc(String locale) {
        return postRepository.queryTop6ByLocaleOrderByCreateDateDesc(locale);
    }

    @Override
    public Iterable<Post> queryTop3ByLocaleOrderByCreateDateDesc(String locale) {
        return postRepository.queryTop3ByLocaleOrderByCreateDateDesc(locale);
    }

    @Override
    public Page<Post> findAllByLocaleAndTitleContaining(String locale, String title, Pageable pageable) {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "createDate"));
        pageable = new PageRequest(pageable.getPageNumber(), 5, sort);
        return postRepository.findAllByLocaleAndTitleContaining(locale, title, pageable);
    }

    @Override
    public Page<Post> findAllByCategoryAndLocale(Category category, Pageable pageable,String locale) {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "createDate"));
        pageable = new PageRequest(pageable.getPageNumber(), 5, sort);
        return postRepository.findAllByCategoryAndLocale(category, pageable,locale);
    }

    @Override
    public Page<Post> findAllByCategoryAndLocaleAndTitle(Category category, Pageable pageable, String title,String locale) {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "createDate"));
        pageable = new PageRequest(pageable.getPageNumber(), 5, sort);
        return postRepository.findAllByCategoryAndLocaleAndTitle(category, pageable, title,locale);
    }

    @Override
    public Iterable<Post> queryTop2ByLocaleAndCategoryOrderByCreateDateDesc(String locale, Category category) {
        return postRepository.queryTop2ByLocaleAndCategoryOrderByCreateDateDesc(locale, category);
    }

    @Override
    public Iterable<Post> findPostByLocaleAndId(String locale, Long id) {
        return postRepository.findPostByLocaleAndId(locale, id);
    }

}
