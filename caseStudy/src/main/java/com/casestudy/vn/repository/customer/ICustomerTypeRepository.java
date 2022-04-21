package com.casestudy.vn.repository.customer;

import com.casestudy.vn.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Integer> {
}
