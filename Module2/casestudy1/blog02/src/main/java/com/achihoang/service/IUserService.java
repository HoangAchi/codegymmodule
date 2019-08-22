package com.achihoang.service;

import com.achihoang.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<User> findAll(Pageable pageable);

    User findById(Long id);

    void save(User user);

    void remove(Long id);

    Iterable<User> findFirstByEmailContainingAndAndPassword(String email,String password);
}
