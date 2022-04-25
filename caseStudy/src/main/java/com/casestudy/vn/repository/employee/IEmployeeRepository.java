package com.casestudy.vn.repository.employee;

import com.casestudy.vn.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    /*Page<Employee> findAllByEmployeeNameContaining(String name, Pageable pageable);
    @Query(value="SELECT * from Employee u where u.employeeName like '?1' ",nativeQuery=true)*/
    Page<Employee> findAllByEmployeeNameContaining(String name, Pageable pageable);

}
