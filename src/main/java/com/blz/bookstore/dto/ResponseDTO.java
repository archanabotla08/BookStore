package com.blz.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
public @Data class ResponseDTO {
	private int statusCode;
	private String message;
	private Object data;

	public ResponseDTO(String message, Object data) {
		this.message = message;
		this.data = data;
	}

	public ResponseDTO(int statusCode, String message, Object data) {
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}

	public ResponseDTO(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}
}
