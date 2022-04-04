package com.hoang.repository;

import com.hoang.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void delete(Long id);

    void delete(Customer customer);

}
