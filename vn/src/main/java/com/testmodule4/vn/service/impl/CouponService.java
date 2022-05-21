package com.testmodule4.vn.service.impl;

import com.testmodule4.vn.model.Coupon;
import com.testmodule4.vn.repository.ICouponRepository;
import com.testmodule4.vn.service.ICouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CouponService implements ICouponService {
    @Autowired
    ICouponRepository couponRepository;

    @Override
    public List<Coupon> findAll() {
        return couponRepository.findAll();
    }

    @Override
    public Page<Coupon> searchAllPage(String name, Pageable pageable) {
        return couponRepository.findAll(pageable);
    }

    @Override
    public Coupon findById(Integer id) {
        return couponRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Coupon coupon) {
        couponRepository.save(coupon);
    }

    @Override
    public void remove(Integer id) {
        couponRepository.deleteById(id);
    }

    @Override
    public Page<Coupon> searchAllPage2(String name, Date startDate, Date endDate, Pageable pageable) {
        return couponRepository.findAllByCouponMoneyContainingAndCouponStartDateGreaterThanEqualAndCouponEndDateLessThanEqual(name,startDate,endDate, pageable);
    }
}
