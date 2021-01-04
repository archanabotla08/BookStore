package com.blz.bookstore.dto;

import lombok.Data;

public @Data class ResponseDTO {
	private Integer statusCode;
	private String message;
	private Object data;

	public ResponseDTO(String message, Object data) {
		this.message = message;
		this.data = data;
	}

	public ResponseDTO(Integer statusCode, String message, Object data) {
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}

	public ResponseDTO(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}
}
