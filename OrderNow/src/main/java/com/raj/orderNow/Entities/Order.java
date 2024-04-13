package com.raj.orderNow.Entities;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "core.now_order", schema = "core")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private String orderDetails;
	private int price;
	private String address;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, String orderDetails, int price, String address, User user) {
		super();
		this.orderId = orderId;
		this.orderDetails = orderDetails;
		this.price = price;
		this.address = address;
		this.user = user;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
