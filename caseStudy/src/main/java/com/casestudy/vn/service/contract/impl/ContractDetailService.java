package com.casestudy.vn.service.contract.impl;

import com.casestudy.vn.model.contract.ContractDetail;
import com.casestudy.vn.repository.contract.IContractDetailRepository;
import com.casestudy.vn.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    IContractDetailRepository contractDetailRepository;


    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }
}
