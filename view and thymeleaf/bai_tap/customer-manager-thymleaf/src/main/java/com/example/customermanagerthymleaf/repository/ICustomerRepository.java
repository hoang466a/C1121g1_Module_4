package com.example.customermanagerthymleaf.repository;

import com.example.customermanagerthymleaf.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

}
