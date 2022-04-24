package com.casestudy.vn.service.service_furama.impl;

import com.casestudy.vn.repository.service_furama.IServiceRepository;
import com.casestudy.vn.service.service_furama.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService implements IServiceService {
    @Autowired
    IServiceRepository serviceRepository;

    @Override
    public List<com.casestudy.vn.model.service_furama.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Page<com.casestudy.vn.model.service_furama.Service> searchAllPage(String name, Pageable pageable) {
        return serviceRepository.findAllByServiceNameContaining(name,pageable);
    }

    @Override
    public com.casestudy.vn.model.service_furama.Service findById(Integer id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(com.casestudy.vn.model.service_furama.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(Integer id) {
        serviceRepository.deleteById(id);
    }
}
