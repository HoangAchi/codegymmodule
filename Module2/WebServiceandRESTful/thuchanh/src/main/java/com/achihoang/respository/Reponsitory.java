package com.achihoang.respository;

import java.util.List;

public interface Reponsitory <T>{
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}
