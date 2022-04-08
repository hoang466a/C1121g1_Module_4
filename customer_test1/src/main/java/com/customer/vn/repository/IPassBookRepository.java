package com.customer.vn.repository;

import com.customer.vn.model.Customer;
import com.customer.vn.model.PassBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPassBookRepository extends JpaRepository<PassBook,Integer> {
    Page<PassBook> findAllByCustomer_IdCustomer(Integer id, Pageable pageable);
    Page<PassBook> findAllByCustomer_NameCustomer(String name,Pageable pageable);

}
