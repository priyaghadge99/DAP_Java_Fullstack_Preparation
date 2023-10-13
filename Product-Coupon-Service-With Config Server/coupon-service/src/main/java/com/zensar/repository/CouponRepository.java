package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.entity.Coupon;


public interface CouponRepository extends JpaRepository<Coupon, Integer> {
	
		Coupon getByCouponCode(String couponCode);
}
