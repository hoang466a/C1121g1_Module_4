package com.example.customermanagerthymleaf.service;


import com.example.customermanagerthymleaf.model.Customer;
import com.example.customermanagerthymleaf.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;


    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findOne(Integer id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return iCustomerRepository.save(customer);
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        return iCustomerRepository.saveAll(customers);
    }

    @Override
    public boolean exists(Integer id) {
        return false;
    }

    @Override
    public void delete(Integer id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        iCustomerRepository.deleteAll();
    }
}
