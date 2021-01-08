package com.blz.bookstore.dto;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class CustomerDTO {

	@Pattern(regexp = "^[A-Z][a-z]+\\\\s?[A-Z][a-z]+$", message = "Enter valid full name")
	private String fullName;
	@Pattern(regexp = "^[6-9][0-9]{9}$", message = "Mobile Number Should Contain Exact 10 digit")
	private String phoneNumber;
	private long pinCode;
	private String locality;
	private String address;
	private String city;
	private String state;
	private String landMark;
	private String locationType;
}