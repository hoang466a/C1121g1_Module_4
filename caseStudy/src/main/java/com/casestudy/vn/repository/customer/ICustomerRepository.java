package com.casestudy.vn.repository.customer;

import com.casestudy.vn.model.customer.Customer;
import com.casestudy.vn.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value="select * from customer where customer_name like ?1 order by customer_id ",nativeQuery=true)
    Page<Customer> findAllByName(String name, Pageable pageable);
   // Page<Customer> findAllByCustomerNameContaining(String name,Pageable pageable);
}
