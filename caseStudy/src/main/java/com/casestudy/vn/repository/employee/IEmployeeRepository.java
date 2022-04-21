package com.casestudy.vn.repository.employee;

import com.casestudy.vn.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value="select u from Employee u where u.employeeName=?1 order by u.employeeId")
    Page<Employee> findAllByName(String name, Pageable pageable);

}
