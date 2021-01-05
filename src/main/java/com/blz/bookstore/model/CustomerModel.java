package com.blz.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.blz.bookstore.dto.CustomerDTO;

import lombok.Data;

@Entity
public @Data class CustomerModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sequenceNo;

    private long userId;
    private String fullName;
    private String phoneNumber;
    private long  pinCode;
    private String locality;
    private String address;
    private String city;
    private String state;
    private String landMark;
    private String locationType;

    public CustomerModel(CustomerDTO customerDTO) {
    	this.fullName = customerDTO.getFullName();
    	this.phoneNumber = customerDTO.getPhoneNumber();
    	this.pinCode = customerDTO.getPinCode();
    	this.locality = customerDTO.getLocality();
    	this.address = customerDTO.getAddress();
    	this.state = customerDTO.getState();
    	this.city = customerDTO.getCity();
    	this.landMark = customerDTO.getLandMark();
    	this.locationType = customerDTO.getLocationType();
    	}

	public long getUserId() {
		return userId;
	}

	public String getFullName() {
		return fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getPinCode() {
		return pinCode;
	}

	public String getLocality() {
		return locality;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getLandMark() {
		return landMark;
	}

	public String getLocationType() {
		return locationType;
	}
    

}
