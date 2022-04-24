package com.casestudy.vn.service.service_furama.impl;

import com.casestudy.vn.model.service_furama.ServiceType;
import com.casestudy.vn.repository.service_furama.IServiceTypeRepository;
import com.casestudy.vn.service.service_furama.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService implements IServiceTypeService {
    @Autowired
    IServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
