package com.demo.coupon.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.coupon.entity.Coupon;
import com.demo.coupon.repository.CouponServiceCouponRepository;
import com.demo.coupon.util.Message;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	CouponServiceCouponRepository repo;

	Message message = new Message();
	Logger logger = LoggerFactory.getLogger(CouponServiceImpl.class);

	@Override
	public List<Coupon> findAllCoupons() {
		return repo.findAll();
	}

	@Override
	public Optional<Coupon> findCouponById(int id) {
		return repo.findById(id);
	}

	@Override
	public Message addCoupon(@Valid Coupon coupon) {
		repo.save(coupon);
		logger.info("Coupon is saved");
		message.setStatus("Coupon is saved");
		return message;
	}

	@Override
	public Message updateCoupon(int id, @Valid Coupon coupon) {
		if (repo.findById(id).isEmpty()) {
			logger.error("No data found with id: {}", id);
			message.setStatus("Not found");
			return message;
		} else {
			repo.save(coupon);
			logger.error("Coupon is updated");
			message.setStatus("Coupon is updated");
			return message;
		}
	}

	@Override
	public Message deleteCoupon(int id) {
		if (repo.findById(id).isEmpty()) {
			logger.error("No data found with id: {}", id);
			message.setStatus("Not found");
			return message;
		} else {
			repo.deleteById(id);
			logger.error("Coupon is deleted");
			message.setStatus("Coupon is deleted");
			return message;
		}
	}

	@Override
	public List<Coupon> orderByAscDiscount() {
		return repo.findByOrderByDiscountAsc();
	}

	@Override
	public List<Coupon> orderByDescDiscount() {
		return repo.findByOrderByDiscountDesc();
	}

	@Override
	public List<Coupon> findAllCouponsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
		return repo.findAllByExpiryBetween(startDate, endDate);
	}

	@Override
	public List<Coupon> findAllCouponsByNameLike(String name) {
		return repo.searchByCouponNameLike(name);
	}

	@Override
	public Optional<Coupon> findCouponsByName(String name) {
		return repo.findByCouponName(name);
	}

	@Override
	public List<Coupon> findAllCouponsByDiscountRange(int startValue, int endValue) {
		return repo.findAllByDiscountBetween(startValue, endValue);
	}

}
