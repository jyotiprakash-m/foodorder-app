package com.demo.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int orderId;
	private String orderReferanceId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderReferanceId() {
		return orderReferanceId;
	}

	public void setOrderReferanceId(String orderReferanceId) {
		this.orderReferanceId = orderReferanceId;
	}

	public Order() {
	}

	public Order(int orderId, String orderReferanceId) {
		this.orderId = orderId;
		this.orderReferanceId = orderReferanceId;
	}

}
