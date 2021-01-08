package com.blz.bookstore.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public @Data class EmailDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String emailTo;
	private String emailFrom;
	private String subject;
	private String message;
}
