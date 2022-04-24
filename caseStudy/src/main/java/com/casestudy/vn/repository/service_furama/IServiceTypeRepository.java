package com.casestudy.vn.repository.service_furama;

import com.casestudy.vn.model.service_furama.Service;
import com.casestudy.vn.model.service_furama.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.invoke.SerializedLambda;

public interface IServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
}
