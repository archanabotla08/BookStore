package com.blz.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blz.bookstore.dto.CustomerDTO;
import com.blz.bookstore.dto.ResponseDTO;
import com.blz.bookstore.model.CustomerModel;
import com.blz.bookstore.service.ICustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customer")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class CustomerController {
	
	@Autowired
    public ICustomerService customerService;

    @ApiOperation("For adding customer details")
    @PostMapping("/details")
    public ResponseEntity<ResponseDTO> customerDetails(@RequestHeader(value = "token", required = false)String token, @RequestBody CustomerDTO customer) {
        String responseMessage = customerService.addCustomerDetails(token, customer);
        return new ResponseEntity<>(new ResponseDTO(200,responseMessage), HttpStatus.OK);
    }

    @ApiOperation("For fetching customer details")
    @GetMapping("/details")
    public ResponseEntity<ResponseDTO> getCustomerDetails(@RequestHeader(value = "token")String token) {
        CustomerModel userDetails= customerService.getCustomerDetails(token);
        ResponseDTO response=new ResponseDTO(200,"Customer details sent successfully", userDetails);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
