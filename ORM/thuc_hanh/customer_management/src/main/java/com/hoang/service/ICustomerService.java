package com.hoang.service;

import com.hoang.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void delete(Long id);

    void delete(Customer customer);



}
