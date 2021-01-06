package com.blz.bookstore.dto;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class CustomerDTO {
	
	@Pattern(regexp = "^[A-Z][a-z]+\\\\s?[A-Z][a-z]+$", message ="Enter valid full name")
	 private String fullName;
	@Pattern(regexp = "^[6-9][0-9]{9}$",message = "Mobile Number Should Contain Exact 10 digit")
	 private String phoneNumber;
	 private long pinCode;
     private String locality;
     private String address; 
     private String city;
     private String state;
     private String landMark;
     private String locationType;
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public long getPinCode() {
		return pinCode;
	}
	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	public String getLocationType() {
		return locationType;
	}
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

     
}