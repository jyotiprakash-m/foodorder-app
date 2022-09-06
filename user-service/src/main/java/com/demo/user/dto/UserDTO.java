package com.demo.user.dto;

import java.util.List;

import com.demo.user.entity.Address;
import com.demo.user.entity.Order;

public class UserDTO {
	private int userId;
	private String name;
	private String email;
	private String phone;
	private String password;
	private int subscription;
	private List<Order> orders;
	private List<Address> address;

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSubscription() {
		return subscription;
	}

	public void setSubscription(int subscription) {
		this.subscription = subscription;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

}
