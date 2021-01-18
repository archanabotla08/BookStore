package com.blz.bookstore.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_details")
public @Data class OrderData {

	@Id
	@Column(name = "order_id")
	public Long orderId;

	@Column(name = "user")
	public Long user;

	@Column(name = "total_price")
	public Double totalPrice;

	@Column(name = "order_placed_date")
	public LocalDateTime orderPlacedDate;

	@OneToMany(cascade=CascadeType.REMOVE, orphanRemoval=true, fetch = FetchType.LAZY)
	@Column(name = "cartbooks")
	@JoinColumn(name = "order_cart_id",referencedColumnName = "order_id")
	public List<CartData> cartBooks;
	
	//@OneToOne()
	//public CartData cartBook;
	
	@JsonIgnore
	@OneToOne()
	@JoinColumn(name = "customer")
	public CustomerModel customer;

	public OrderData(Long orderId, Long userId, List<CartData> cart, double totalPrice, CustomerModel customer) {
		this.orderId = orderId;
		this.user = userId;
		this.cartBooks = cart;
		this.totalPrice = totalPrice;
		this.orderPlacedDate = LocalDateTime.now();
		this.customer = customer;
	}
}