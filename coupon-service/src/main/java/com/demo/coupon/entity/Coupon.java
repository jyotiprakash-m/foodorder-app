package com.demo.coupon.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "coupons")
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int couponId;
	@NotEmpty(message = "Coupon name is required")
	@Column(name = "name")
	private String couponName;
	@NotNull(message = "Discount is required")
	private int discount;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	@NotNull(message = "Expiry date is required")
	private LocalDateTime expiry;

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public LocalDateTime getExpiry() {
		return expiry;
	}

	public void setExpiry(LocalDateTime expiry) {
		this.expiry = expiry;
	}

	public Coupon() {
	}

	public Coupon(String couponName, int discount, LocalDateTime expiry) {
		this.couponName = couponName;
		this.discount = discount;
		this.expiry = expiry;
	}

	public Coupon(int couponId, String couponName, int discount, LocalDateTime expiry) {
		this.couponId = couponId;
		this.couponName = couponName;
		this.discount = discount;
		this.expiry = expiry;
	}

}
