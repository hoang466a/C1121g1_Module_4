package com.casestudy.vn.service.service_furama.impl;

import com.casestudy.vn.model.service_furama.RentType;
import com.casestudy.vn.repository.service_furama.IRentTypeRepository;
import com.casestudy.vn.service.service_furama.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
