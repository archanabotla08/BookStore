package com.blz.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blz.bookstore.dto.CustomerDTO;
import com.blz.bookstore.exceptions.UserException;
import com.blz.bookstore.model.CustomerModel;
import com.blz.bookstore.model.UserModel;
import com.blz.bookstore.repository.CustomerRepository;
import com.blz.bookstore.repository.UserRepository;
import com.blz.utility.JwtGenerator;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public CustomerRepository customerRepository;
	
	@Override
	public CustomerModel getCustomerDetails(String token) throws UserException {
        Long userId = JwtGenerator.decodeJWT(token);
        Optional<CustomerModel> customer= customerRepository.findById(userId);
        return customer.get();
	}

	@Override
	public String addCustomerDetails(String token, CustomerDTO customerModel) throws UserException {
		Long userId= JwtGenerator.decodeJWT(token);
        Optional<UserModel> user = userRepository.findById(userId);
        Optional<CustomerModel> isCustomerAvailable = customerRepository.findByUserId(user.get().getUserId());
        if(isCustomerAvailable.isPresent()) {
            return "Your details are already saved";
        }
        CustomerModel customer= new CustomerModel(customerModel);
        customer.setUserId(userId);
        customerRepository.save(customer);
        return "Customer details added successfully";
	}
	
}