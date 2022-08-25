package com.demo.coupon.rest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.coupon.dto.CouponDTO;
import com.demo.coupon.entity.Coupon;
import com.demo.coupon.service.CouponServiceImpl;
import com.demo.coupon.util.Message;

@RestController
@RequestMapping("/coupon")
public class CouponServiceRestController {
	@Autowired
	CouponServiceImpl couponImpl;

	Message message = new Message();
	Logger logger = LoggerFactory.getLogger(CouponServiceRestController.class);

	// Get All the coupons
	@GetMapping("/get")
	public ResponseEntity<List<Coupon>> getAllCoupons() {
		return new ResponseEntity<>(couponImpl.findAllCoupons(), HttpStatus.OK);
	}

//	Find coupon by id
	@GetMapping("/get/{id}")
	public ResponseEntity<Coupon> findCouponById(@PathVariable int id) {
		Optional<Coupon> couponOptional = couponImpl.findCouponById(id);
		if (couponOptional.isEmpty()) {
			logger.error("No data found with id: {}", id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(couponOptional.get(), HttpStatus.OK);
		}
	}

//	Add coupon
	@PostMapping(path = "/save")
	public ResponseEntity<Message> addCoupon(@RequestBody CouponDTO couponDto) {
		Coupon newCoupon = new Coupon(couponDto.getCouponName(), couponDto.getDiscount(), couponDto.getExpiry());
		return new ResponseEntity<Message>(couponImpl.addCoupon(newCoupon), HttpStatus.OK);
	}

//	Update Coupon
	@PutMapping(path = "/update/{id}")
	public ResponseEntity<Message> updateCoupon(@PathVariable("id") int id, @RequestBody CouponDTO couponDto) {
		Coupon newCoupon = new Coupon(couponDto.getCouponId(), couponDto.getCouponName(), couponDto.getDiscount(),
				couponDto.getExpiry());
		Optional<Coupon> couponOptional = couponImpl.findCouponById(id);
		if (couponOptional.isEmpty()) {
			return new ResponseEntity<Message>(couponImpl.updateCoupon(id, newCoupon), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Message>(couponImpl.updateCoupon(id, newCoupon), HttpStatus.OK);
		}
	}

//	Delete Coupon
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Message> deleteCoupon(@PathVariable("id") int id) {
		Optional<Coupon> couponOptional = couponImpl.findCouponById(id);
		if (couponOptional.isEmpty()) {
			return new ResponseEntity<Message>(couponImpl.deleteCoupon(id), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Message>(couponImpl.deleteCoupon(id), HttpStatus.OK);
		}
	}

//	Order by discount -ascending
	@GetMapping(path = "/findByOrderByDiscountAsc")
	public ResponseEntity<List<Coupon>> getAllCouponsOrderByDiscountByAcs() {
		return new ResponseEntity<>(couponImpl.orderByAscDiscount(), HttpStatus.OK);
	}

//	Order by discount -descending
	@GetMapping(path = "/findByOrderByDiscountDesc")
	public ResponseEntity<List<Coupon>> getAllCouponsOrderByDiscountByDesc() {
		return new ResponseEntity<>(couponImpl.orderByDescDiscount(), HttpStatus.OK);
	}

//	Get coupons between data range
	@GetMapping(path = "/fetchByDateRange/{one_date}/{two_date}")
	public ResponseEntity<List<Coupon>> getAllCouponsBetweenDates(@PathVariable(value = "one_date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime fromDate, @PathVariable(value = "two_date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime toDate) {
		return new ResponseEntity<>(couponImpl.findAllCouponsByDateRange(fromDate, toDate), HttpStatus.OK);
	}
	@GetMapping(path = "/fetchByDiscountRange")
	public ResponseEntity<List<Coupon>> getAllCouponsBetweenDiscount(@RequestParam(value = "startValue") int startValue, @RequestParam(value = "endValue") int endValue) {
		return new ResponseEntity<>(couponImpl.findAllCouponsByDiscountRange(startValue, endValue), HttpStatus.OK);
	}

//	Filter the coupon by name like
	@GetMapping(path = "/findAllByNameLike")
	public ResponseEntity<List<Coupon>> getAllCouponsByNameLike(@RequestParam("name") String name) {
		return new ResponseEntity<>(couponImpl.findAllCouponsByNameLike(name), HttpStatus.OK);
	}

//	Get the coupon by name
	@GetMapping(path = "/findByCouponName")
	public ResponseEntity<Coupon> getCouponByName(@RequestParam("name") String name) {
		Optional<Coupon> couponOptional = couponImpl.findCouponsByName(name);
		if (couponOptional.isEmpty()) {
			logger.error("No data found with name: {}", name);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(couponOptional.get(), HttpStatus.OK);
		}
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleError(Exception e) {
	    return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}


}
