package com.blz.bookstore.service;

import com.blz.bookstore.model.OrderData;

public interface IOrderService {

	OrderData getOrderSummary(String token);

	Long placeOrder(String token);

}