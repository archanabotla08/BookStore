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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseDTO [message=" + message + ", data=" + data + "]";
	}
	
}
