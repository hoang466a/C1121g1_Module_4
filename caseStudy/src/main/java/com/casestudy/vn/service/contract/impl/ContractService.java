package com.casestudy.vn.service.contract.impl;

import com.casestudy.vn.model.contract.Contract;
import com.casestudy.vn.repository.contract.IContractRepository;
import com.casestudy.vn.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository contractRepository;


    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Page<Contract> searchAllPage(String name, Pageable pageable) {
        return contractRepository.findAllByCustomer_CustomerNameContaining(name,pageable);
    }

    @Override
    public Contract findById(Integer id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Integer id) {
        contractRepository.deleteById(id);
    }
}
