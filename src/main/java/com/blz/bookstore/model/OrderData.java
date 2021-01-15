package com.blz.bookstore.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "order_details")
public @Data class OrderData {

	@Id
	@Column(name = "order_id")
	public Long OrderId;

	@Column(name = "user")
	public Long user;

	@Column(name = "total_price")
	public Double totalPrice;

	@Column(name = "order_placed_date")
	public LocalDate orderPlacedDate;

	@OneToMany()
	public List<CartData> cartBooks;

	@OneToOne()
	public CartData cartBook;
	@JsonIgnore
	@OneToOne()
	@JoinColumn(name = "customer")
	public CustomerModel customer;

	public OrderData(Long orderId, Long userId, List<CartData> cart, double totalPrice, CustomerModel customer) {
		this.OrderId = orderId;
		this.user = userId;
		this.cartBooks = cart;
		this.totalPrice = totalPrice;
		this.orderPlacedDate = LocalDate.now();
		this.customer = customer;
	}

	public OrderData() {
	}

	public OrderData(Long orderId2, Long userId, CartData cart, double totalPrice2, CustomerModel customer2) {
		this.OrderId = orderId2;
		this.user = userId;
		this.cartBook = cart;
		this.totalPrice = totalPrice;
		this.orderPlacedDate = LocalDate.now();
		this.customer = customer;
	}

	public Long getOrderId() {
		return OrderId;
	}

	public void setOrderId(Long orderId) {
		OrderId = orderId;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDate getOrderPlacedDate() {
		return orderPlacedDate;
	}

	public void setOrderPlacedDate(LocalDate orderPlacedDate) {
		this.orderPlacedDate = orderPlacedDate;
	}

	public List<CartData> getCartBooks() {
		return cartBooks;
	}

	public void setCartBooks(List<CartData> cartBooks) {
		this.cartBooks = cartBooks;
	}

	public CustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}
	
	
}