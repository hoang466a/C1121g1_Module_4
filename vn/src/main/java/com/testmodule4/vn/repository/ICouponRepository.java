package com.testmodule4.vn.repository;

import com.testmodule4.vn.model.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ICouponRepository extends JpaRepository<Coupon, Integer> {
        Page<Coupon> findAll(Pageable pageable);
        Page <Coupon> findAllByCouponMoneyContaining(String name, Pageable pageable);
        Page <Coupon> findAllByCouponMoneyContainingAndCouponStartDateGreaterThanEqualAndCouponEndDateLessThanEqual(String name, Date startDate, Date endDate,Pageable pageable);
}
