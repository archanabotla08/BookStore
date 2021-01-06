package com.blz.bookstore.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public @Data class EmailDTO {

	private String emailTo;
	private String emailFrom;
	private String subject;
	private String message;
}
