package com.codegym.vn.repository;

import com.codegym.vn.model.SmartPhone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartPhoneRepository extends JpaRepository<SmartPhone,Long> {
    Page<SmartPhone> findAllByModelContaining(String keyword, Pageable pageable);
}
