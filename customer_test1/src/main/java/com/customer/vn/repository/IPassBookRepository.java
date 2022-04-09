package com.customer.vn.repository;

import com.customer.vn.model.Customer;
import com.customer.vn.model.PassBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface IPassBookRepository extends JpaRepository<PassBook,Integer> {
    Page<PassBook> findAllByCustomerNameCustomerLike(String name,Pageable pageable);
    Page<PassBook> findAllByDepositDateBetweenDateAndDate(Date date1, Date date2, Pageable pageable);
    Page<PassBook> findAllByDepositDateAndCustomerNameAndBetweenDateAndDate(String name,Date date1, Date date2, Pageable pageable);
}
