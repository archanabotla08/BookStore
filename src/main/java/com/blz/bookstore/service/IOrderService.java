package com.blz.bookstore.service;

import javax.mail.MessagingException;

import com.blz.bookstore.model.OrderData;

public interface IOrderService {

	OrderData getOrderSummary(String token);

	Long placeOrder(String token) throws MessagingException;

}
