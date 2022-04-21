package com.casestudy.vn.service.customer.impl;

import com.casestudy.vn.model.customer.CustomerType;
import com.casestudy.vn.repository.customer.ICustomerRepository;
import com.casestudy.vn.repository.customer.ICustomerTypeRepository;
import com.casestudy.vn.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
