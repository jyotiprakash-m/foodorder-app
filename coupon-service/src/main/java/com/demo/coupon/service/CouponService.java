package com.demo.coupon.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.demo.coupon.entity.Coupon;
import com.demo.coupon.util.Message;

public interface CouponService {

//	Get All the coupons
	List<Coupon> findAllCoupons();
//	Get Coupon by id
	Optional<Coupon> findCouponById(int id);
//	Add coupon
	Message addCoupon(Coupon coupon);
//	Update Coupon
	Message updateCoupon(int id,Coupon coupon);
//	Delete Coupon
	Message deleteCoupon(int id);
//	Order by discount -ascending  
	List<Coupon> orderByAscDiscount();
//	Order by discount -descending
	List<Coupon> orderByDescDiscount();
//	Get coupons between date range
	List<Coupon> findAllCouponsByDateRange(LocalDateTime startDate,LocalDateTime endDate);
//	Get coupons between discount range
	List<Coupon> findAllCouponsByDiscountRange(int startValue, int endValue);
//	Filter the coupon by name like
	List<Coupon> findAllCouponsByNameLike(String name);
//	Get the coupon by name
	Optional<Coupon> findCouponsByName(String name);
}
