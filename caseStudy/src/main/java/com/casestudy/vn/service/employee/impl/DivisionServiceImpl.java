package com.casestudy.vn.service.employee.impl;

import com.casestudy.vn.model.employee.Division;
import com.casestudy.vn.repository.employee.IDivisionRepository;
import com.casestudy.vn.service.employee.IDivivsionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DivisionServiceImpl implements IDivivsionService {
    @Autowired
    public IDivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

}
