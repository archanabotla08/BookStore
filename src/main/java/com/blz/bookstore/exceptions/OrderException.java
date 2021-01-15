package com.blz.bookstore.exceptions;

import com.blz.bookstore.exceptions.CartException.ExceptionType;

public class OrderException extends Exception {
	public ExceptionType type;

	public OrderException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}

	public enum ExceptionType {
		Duplicate_Entry
	}
}
