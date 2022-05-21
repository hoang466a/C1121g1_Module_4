package com.testmodule4.vn.service;

import com.testmodule4.vn.model.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface ICouponService extends IGeneralService<Coupon>{
    public Page<Coupon> searchAllPage2(String name, Date startDate,Date endDate, Pageable pageable) ;

}
