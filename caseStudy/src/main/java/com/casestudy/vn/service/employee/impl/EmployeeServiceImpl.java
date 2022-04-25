package com.casestudy.vn.service.employee.impl;

import com.casestudy.vn.model.employee.Employee;
import com.casestudy.vn.repository.employee.IEmployeeRepository;
import com.casestudy.vn.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    public IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Page<Employee> findAll2(Pageable pageable){return employeeRepository.findAll(pageable);}

    @Override
    public Page<Employee> searchAllPage(String name, Pageable pageable) {
        return employeeRepository.findAllByEmployeeNameContaining(name,pageable);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Integer id) {
        employeeRepository.deleteById(id);
    }
}
