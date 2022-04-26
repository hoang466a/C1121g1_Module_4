package com.casestudy.vn.service.contract.impl;

import com.casestudy.vn.model.contract.AttachService;
import com.casestudy.vn.repository.contract.IAttachServiceRepository;
import com.casestudy.vn.service.contract.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceService implements IAttachServiceService {
    @Autowired
    IAttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
