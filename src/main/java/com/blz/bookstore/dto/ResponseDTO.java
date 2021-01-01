package com.blz.bookstore.dto;

import lombok.Data;

@Data
public class ResponseDTO {

	private String message;
	private Object data;
	public ResponseDTO(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}
	
}
