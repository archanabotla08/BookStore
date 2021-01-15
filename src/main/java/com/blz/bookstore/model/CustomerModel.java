package com.blz.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.blz.bookstore.dto.CustomerDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "customer_details")
public @Data class CustomerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sequenceNo;

	private long userId;
	private String fullName;
	private String phoneNumber;
	private long pinCode;
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
	

	public CustomerModel() {
		
	}


	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}


	public long getSequenceNo() {
		return sequenceNo;
	}


	public void setSequenceNo(long sequenceNo) {
		this.sequenceNo = sequenceNo;
	}


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