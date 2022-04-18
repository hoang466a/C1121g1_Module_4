package com.customer.vn.repository;

import com.customer.vn.model.Customer;
import com.customer.vn.model.PassBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

public interface IPassBookRepository extends JpaRepository<PassBook,Integer> {
    @Query(value="SELECT u from passbook u order by u.idPassBook")
    Page<PassBook> findAll(Pageable pageable);
    @Query(value="SELECT u from passbook u where u.depositDate between ?1 and ?2 or u.customer.nameCustomer=?3")
    Page<PassBook> findAllBetWeen2Days(Optional<String> date1, Optional<String> date2, Optional<String> name, Pageable pageable);

    //Page<PassBook> findAllByCustomerNameCustomerLike(String name,Pageable pageable);
    //Page<PassBook> findAllByDepositDateBetweenDateAndDate(Date date1, Date date2, Pageable pageable);
    //Page<PassBook> findAllByDepositDateAndCustomerNameAndBetweenDateAndDate(String name,Date date1, Date date2, Pageable pageable);
}
