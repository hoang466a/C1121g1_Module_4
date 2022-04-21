package com.casestudy.vn.service.employee.impl;

import com.casestudy.vn.model.employee.Position;
import com.casestudy.vn.repository.employee.IPositionRepository;
import com.casestudy.vn.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImpl implements IPositionService {
    @Autowired
    public IPositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
