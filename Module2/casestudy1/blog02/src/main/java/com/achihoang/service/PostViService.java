package com.achihoang.service;

import com.achihoang.model.CategoryVi;
import com.achihoang.model.PostVi;
import com.achihoang.repository.PostViRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class PostViService implements IPostVi {

    @Autowired
    private PostViRepository postViRepository;

    @Override
    public Page<PostVi> findAll(Pageable pageable) {
        return postViRepository.findAll(pageable);
    }

    @Override
    public PostVi findById(Long id) {
        return postViRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        postViRepository.delete(id);
    }

    @Override
    public void save(PostVi postVi) {
        postViRepository.save(postVi);
    }

    @Override
    public Iterable<PostVi> queryTop2ByOrderByCategoryViDesc() {
        return postViRepository.queryTop2ByOrderByCategoryViDesc();
    }

    @Override
    public Iterable<PostVi> findAllByCategoryVi(CategoryVi categoryVi) {
        return postViRepository.findAllByCategoryVi(categoryVi);
    }

    @Override
    public Iterable<PostVi> queryTop6ByOrderByNgaytaoDesc() {
        return postViRepository.queryTop6ByOrderByNgaytaoDesc();
    }

    @Override
    public Iterable<PostVi> queryTop2ByOrderByNgaytaoDesc() {
        return postViRepository.queryTop2ByOrderByNgaytaoDesc();
    }

    @Override
    public Iterable<PostVi> queryTop3ByOrderByNgaytaoDesc() {
        return postViRepository.queryTop3ByOrderByNgaytaoDesc();
    }

    @Override
    public Page<PostVi> findAllByTieudeContaining(String tieude, Pageable pageable) {
        return postViRepository.findAllByTieudeContaining(tieude, pageable);
    }

    @Override
    public Iterable<PostVi> findAllByCategoryVi_Name(String categoryName) {
        return postViRepository.findAllByCategoryVi_Name(categoryName);
    }

    @Override
    public Page<PostVi> findAllByCategoryVi(CategoryVi categoryVi, Pageable pageable) {
        return postViRepository.findAllByCategoryVi(categoryVi, pageable);
    }

    @Override
    public Iterable<PostVi> findTop2ByCategoryVi(CategoryVi categoryVi) {
        return postViRepository.findTop2ByCategoryVi(categoryVi);
    }
}
