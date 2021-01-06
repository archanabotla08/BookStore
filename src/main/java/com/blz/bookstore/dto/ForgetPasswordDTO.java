package com.blz.bookstore.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class ForgetPasswordDTO {

	@NotEmpty
	@Email(message="Enter the valid emailId")
	private String  emailId;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
}