package com.blz.bookstore.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blz.bookstore.dto.ResponseDTO;
import com.blz.bookstore.exceptions.UserException;
import com.blz.bookstore.model.OrderData;
import com.blz.bookstore.service.IOrderService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/order")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class OrderController {

	@Autowired
	private IOrderService orderService;
	
	@ApiOperation("For fetching order summary")
	@GetMapping("/details")
	public ResponseEntity<ResponseDTO> getOrderSummary(@RequestHeader String token) throws UserException {
		OrderData orderDetails = null;
		orderDetails = orderService.getOrderSummary(token);
		ResponseDTO respDTO = new ResponseDTO(200, "Response Sent Successfully", orderDetails);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@ApiOperation("For placing order")
	@PostMapping("/place")
	public ResponseEntity<ResponseDTO> placeOrder(@RequestHeader String token) throws MessagingException, UserException {
		Long orderId = orderService.placeOrder(token);
		ResponseDTO respDTO = new ResponseDTO(200, "Order placed Successfully", orderId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
