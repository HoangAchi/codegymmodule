package com.achihoang.service;

import com.achihoang.model.CategoryVi;
import com.achihoang.repository.CategoryViRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CategoryViService implements ICategoryVi {

    @Autowired
    private CategoryViRepository categoryViRepository;

    @Override
    public Page<CategoryVi> findAll(Pageable pageable) {
        return categoryViRepository.findAll(pageable);
    }

    @Override
    public CategoryVi findById(Long id) {
        return categoryViRepository.findOne(id);
    }

    @Override
    public void save(CategoryVi categoryVi) {
        categoryViRepository.save(categoryVi);
    }

    @Override
    public void delete(Long id) {
        categoryViRepository.delete(id);
    }

    @Override
    public Iterable<CategoryVi> findAllByName(String name) {
        return categoryViRepository.findAllByName(name);
    }

    @Override
    public Iterable<CategoryVi> findAll() {
        return categoryViRepository.findAll();
    }
}
