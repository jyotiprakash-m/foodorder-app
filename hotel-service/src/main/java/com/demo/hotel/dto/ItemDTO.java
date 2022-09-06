package com.demo.hotel.dto;

public class ItemDTO {
	private int itemId;
	private String itemName;
	private String itemDescription;
	private double Price;
	private double discount;
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
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
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

}
