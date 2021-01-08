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
}