package com.demo.user.dto;

public class OrderDTO {
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

}
