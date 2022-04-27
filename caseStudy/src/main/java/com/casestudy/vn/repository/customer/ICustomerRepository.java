package com.casestudy.vn.repository.customer;

import com.casestudy.vn.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    /*@Query(value="select * from Customer",nativeQuery=true)
    Page<Customer> findAllByName(String name, Pageable pageable);*/
   Page<Customer> findAllByCustomerNameContaining(String name,Pageable pageable);
   Customer findByCustomerCode(String code);
}
