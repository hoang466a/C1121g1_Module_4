package com.casestudy.vn.repository.employee;

import com.casestudy.vn.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position,Integer> {
}
