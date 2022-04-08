package com.customer.vn.repository;

import com.customer.vn.model.Tenor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITenorRepository extends JpaRepository <Tenor,Integer> {
}
