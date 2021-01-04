package com.blz.bookstore.exceptions;

public class CartException extends Exception {

	public ExceptionType type;

	public CartException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}

	public enum ExceptionType {
		EMPTY_CART
	}
}
