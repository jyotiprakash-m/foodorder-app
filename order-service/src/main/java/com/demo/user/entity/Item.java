package com.demo.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int itemId;
	private int ItemReferanceId;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemReferanceId() {
		return ItemReferanceId;
	}

	public void setItemReferanceId(int itemReferanceId) {
		ItemReferanceId = itemReferanceId;
	}

	public Item() {
	}

	public Item(int itemId, int itemReferanceId) {
		this.itemId = itemId;
		ItemReferanceId = itemReferanceId;
	}

}
