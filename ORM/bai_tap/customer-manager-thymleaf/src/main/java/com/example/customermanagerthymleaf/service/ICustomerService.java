package com.example.customermanagerthymleaf.service;

import com.example.customermanagerthymleaf.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Customer findById(int id);
    List<Customer> findAll();

    Customer findOne (Integer id);
    Customer save(Customer customer);
    List<Customer> save(List<Customer> customers);
    boolean exists(Integer id);
    void delete(Integer id);
    void deleteAll();
}
