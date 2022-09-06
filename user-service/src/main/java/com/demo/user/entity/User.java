package com.demo.user.entity;

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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int userId;
	@NotEmpty(message = "User name is required")
	private String name;
	@Email
	private String email;
	@Pattern(regexp = "^\\d{10}$", message = "Enter 10 digit number")
	private String phone;
	@NotEmpty(message = "Password is required")
	private String password;
	private int subscription;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private List<Order> orders;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private List<Address> address;
	private boolean isLogin;

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

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public User() {
	}

	public User(int userId, String name, @Email String email, String phone, String password, int subscription,
			List<Order> orders, List<Address> address, boolean isLogin) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.subscription = subscription;
		this.orders = orders;
		this.address = address;
		this.isLogin = isLogin;
	}

}
