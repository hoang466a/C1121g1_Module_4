package com.casestudy.vn.service.employee;

import com.casestudy.vn.model.employee.Division;
import com.casestudy.vn.model.employee.Position;
import com.casestudy.vn.service.IGeneralService;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
}
