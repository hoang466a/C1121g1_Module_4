package com.codegym.vn.service;

import com.codegym.vn.model.SmartPhone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISmartPhoneService extends IGeneralService<SmartPhone>{
    Page<SmartPhone>showAll(String keyword, Pageable pageable);
}
