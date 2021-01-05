package com.blz.bookstore.service;

import com.blz.bookstore.dto.CustomerDTO;
import com.blz.bookstore.model.CustomerModel;

public interface ICustomerService {

	   CustomerModel getCustomerDetails(String token);

	   String addCustomerDetails(String token, CustomerDTO customerModel);
}
