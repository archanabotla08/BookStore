package com.blz.bookstore.service;

import org.springframework.stereotype.Component;

import com.blz.bookstore.dto.CustomerDTO;
import com.blz.bookstore.exceptions.UserException;
import com.blz.bookstore.model.CustomerModel;

@Component("ICustomerService")
public interface ICustomerService {

	CustomerModel getCustomerDetails(String token) throws UserException;

	String addCustomerDetails(String token, CustomerDTO customerModel) throws UserException;
}