package com.demo.hotel.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "hotels")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int hotelId;
//	@NotEmpty(message = "Hotel name is required")
	private String hotelName;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "hotel_id", referencedColumnName = "id")
	private List<Item> items;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "hotel_id", referencedColumnName = "id")
	private List<Order> orders;

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Hotel() {
	}

	public Hotel(int hotelId, String hotelName, Address address, List<Item> items, List<Order> orders) {
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.address = address;
		this.items = items;
		this.orders = orders;
	}

}
