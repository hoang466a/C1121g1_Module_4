package com.casestudy.vn.service.employee;

import com.casestudy.vn.model.employee.Employee;
import com.casestudy.vn.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService extends IGeneralService<Employee> {
    Page<Employee> findAll2(Pageable pageable);
}
