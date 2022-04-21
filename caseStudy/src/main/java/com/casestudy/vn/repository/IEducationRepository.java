package com.casestudy.vn.repository;

import com.casestudy.vn.model.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationRepository extends JpaRepository<EducationDegree,Integer> {
}
