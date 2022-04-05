package com.example.test.service;

import com.example.test.model.Customer;

import java.util.List;

public interface ICustomerService {
    Customer findById(Long id);
    List<Customer> findAll();
    List<Customer>searchByName(String name);
    Customer findOne(Long id);
    Customer save(Customer customer);
    boolean exists(Long id);
    List<Customer> findAll(List<Long> id);
}
