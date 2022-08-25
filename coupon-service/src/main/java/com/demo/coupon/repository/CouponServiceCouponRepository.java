package com.demo.coupon.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.coupon.entity.Coupon;

@Repository
public interface CouponServiceCouponRepository extends JpaRepository<Coupon, Integer> {
	public List<Coupon> findByOrderByDiscountAsc();

	public List<Coupon> findByOrderByDiscountDesc();

	public List<Coupon> findAllByExpiryBetween(LocalDateTime startDate, LocalDateTime endDate);
	public List<Coupon> findAllByDiscountBetween(int startValue, int endValue);

	@Query("SELECT c FROM Coupon c WHERE c.couponName LIKE %:name%")
	public List<Coupon> searchByCouponNameLike(@Param("name") String name);

	public Optional<Coupon> findByCouponName(String name);

}
