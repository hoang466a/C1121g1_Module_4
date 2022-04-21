package com.casestudy.vn.service.employee.impl;

import com.casestudy.vn.model.employee.EducationDegree;
import com.casestudy.vn.repository.employee.IEducationRepository;
import com.casestudy.vn.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationDegreeServiceImpl implements IEducationDegreeService {
    @Autowired
    public IEducationRepository educationRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationRepository.findAll();
    }

}
