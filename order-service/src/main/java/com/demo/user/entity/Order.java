package com.demo.user.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@Column(name = "id")
	private String orderId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	@NotNull(message = "Expiry date is required")
	private LocalDateTime orderDate;
	@NotNull(message = "User id is required")
	private int userId;
	@NotNull(message = "Hotel id is required")
	private int hotelId;
	@NotNull(message = "User Address id is required")
	private int userAddressId;
	@NotNull(message = "Amount is required")
	private int amount;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private List<Item> items;
	@Enumerated(EnumType.STRING)
	private Status status;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
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

	public Order() {
	}

	public Order(String orderId, LocalDateTime orderDate, int userId, int hotelId, int userAddressId, int amount,
			List<Item> items, Status status) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.userId = userId;
		this.hotelId = hotelId;
		this.userAddressId = userAddressId;
		this.amount = amount;
		this.items = items;
		this.status = status;
	}

}
