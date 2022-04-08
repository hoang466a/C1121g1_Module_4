package com.customer.vn.service.Impl;

import com.customer.vn.model.Tenor;
import com.customer.vn.repository.ITenorRepository;
import com.customer.vn.service.ITenorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenorService implements ITenorService {
    @Autowired
    ITenorRepository tenorRepository;

    @Override
    public List<Tenor> findAll() {
        return tenorRepository.findAll();
    }
}
