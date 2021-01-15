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
}