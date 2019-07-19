package com.achihoang.service;

import com.achihoang.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void create (Customer customer);
    Customer findById(int id);
    void update(int id,Customer customer);
    void delete(int id);
}
