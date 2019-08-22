package com.achihoang.service.impl;

import com.achihoang.model.Category;
import com.achihoang.repository.CategoryRepository;
import com.achihoang.service.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class CategoryService implements ICategory {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.delete(id);
    }

    //admin
    @Override
    public Page<Category> findAllByLocale(String locale, Pageable pageable) {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "createDate"));
        pageable = new PageRequest(pageable.getPageNumber(), 5, sort);
        return categoryRepository.findAllByLocale(locale, pageable);
    }

    @Override
    public Iterable<Category> findAllByLocale(String en) {
        return categoryRepository.findAllByLocale(en);
    }

    @Override
    public Iterable<Category> findFirstByLocaleAndId(String locale, Long id) {
        return categoryRepository.findFirstByLocaleAndId(locale, id);
    }

}
