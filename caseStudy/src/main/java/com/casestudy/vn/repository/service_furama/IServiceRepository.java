package com.casestudy.vn.repository.service_furama;

import com.casestudy.vn.model.service_furama.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service,Integer> {
    Page<Service>findAllByServiceNameContaining(String name, Pageable pageable);
}
