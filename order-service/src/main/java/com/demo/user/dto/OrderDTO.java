package com.demo.user.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.demo.user.entity.Item;
import com.demo.user.entity.Status;

public class OrderDTO {
	private int orderId;
	private LocalDateTime orderDate;
	private int userId;
	private int hotelId;
	private int userAddressId;
	private int amount;
	private List<Item> items;
	private Status status;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public int getUserAddressId() {
		return userAddressId;
	}
	public void setUserAddressId(int userAddressId) {
		this.userAddressId = userAddressId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
