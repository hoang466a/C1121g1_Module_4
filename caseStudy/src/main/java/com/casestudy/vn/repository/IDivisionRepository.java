package com.casestudy.vn.repository;

import com.casestudy.vn.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IDivisionRepository extends JpaRepository<Division, Integer> {
}
