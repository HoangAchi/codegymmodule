package com.achihoang.repository;

import com.achihoang.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository  extends PagingAndSortingRepository<User,Long> {
    Iterable<User> findFirstByEmailContainingAndAndPassword(String email,String password);
}
