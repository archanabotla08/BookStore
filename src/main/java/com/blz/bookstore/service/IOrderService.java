package com.blz.bookstore.service;

import com.blz.bookstore.exceptions.UserException;
import javax.mail.MessagingException;

import com.blz.bookstore.model.OrderData;

public interface IOrderService {

	OrderData getOrderSummary(String token) throws UserException;

	Long placeOrder(String token) throws MessagingException, UserException;

}