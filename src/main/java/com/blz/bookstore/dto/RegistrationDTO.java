package com.blz.bookstore.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegistrationDTO {

	@Pattern(regexp = "^[A-Z][a-z]+\\s?[A-Z][a-z]+$", message = "Please enter Valid full name")
	private String fullName;

	@Email(message = "Please enter Valid email Id")
	private String emailId;

	@Pattern(regexp = "^[6-9][0-9]{9}$",message = "Mobile Number Should Contain Exact 10 digit")
	private String mobileNumber;

	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$", message = "Password length should be 8 must contain at least one uppercase, lowercase, special character and number")
	private String password;

	public String getFullName() {
		return fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getPassword() {
		return password;
	}
}