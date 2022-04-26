package com.casestudy.vn.repository.contract;

import com.casestudy.vn.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findAllByCustomer_CustomerNameContaining(String name, Pageable pageable);
}
