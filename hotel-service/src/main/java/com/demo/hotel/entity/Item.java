package com.demo.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "items")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int itemId;
	@NotEmpty(message = "Item name is required")
	private String itemName;
	private String itemDescription;
	@NotNull(message = "Price is required")
	private double price;
	private double discount;
	@NotNull(message = "Avalable is required")
	private boolean avalable;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public boolean isAvalable() {
		return avalable;
	}

	public void setAvalable(boolean avalable) {
		this.avalable = avalable;
	}

	public Item() {
	}

	public Item(int itemId, String itemName, String itemDescription, double price, double discount, boolean avalable) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.price = price;
		this.discount = discount;
		this.avalable = avalable;
	}

}
