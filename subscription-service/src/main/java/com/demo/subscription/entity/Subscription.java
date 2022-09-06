package com.demo.subscription.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "subscriptions")
public class Subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int subscriptionId;
	@NotEmpty(message = "Subscription name is required")
	@Column(name = "name")
	private String subscriptionName;
	@NotNull(message = "Discount is required")
	private int discount;
	@NotNull(message = "Price is required")
	private double price;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "subscription_id", referencedColumnName = "id")
	private List<Feature> features;

	public int getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public String getSubscriptionName() {
		return subscriptionName;
	}

	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	public Subscription() {
	}
	public Subscription(String subscriptionName, int discount, double price) {
		this.subscriptionName = subscriptionName;
		this.discount = discount;
		this.price = price;
	}

	public Subscription(String subscriptionName, int discount, double price, List<Feature> features) {
		this.subscriptionName = subscriptionName;
		this.discount = discount;
		this.price = price;
		this.features = features;
	}

	public Subscription(int subscriptionId, String subscriptionName, int discount, double price,
			List<Feature> features) {
		this.subscriptionId = subscriptionId;
		this.subscriptionName = subscriptionName;
		this.discount = discount;
		this.price = price;
		this.features = features;
	}

}
