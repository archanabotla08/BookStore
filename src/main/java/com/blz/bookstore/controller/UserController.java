//package com.blz.bookstore.controller;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.blz.bookstore.dto.RegistrationDTO;
//import com.blz.bookstore.dto.ResponseDTO;
//import com.blz.bookstore.model.BookListDataModel;
//import com.blz.bookstore.model.UserModel;
//import com.blz.bookstore.service.IUserService;
//
//import io.swagger.annotations.ApiOperation;
//import jdk.jshell.spi.ExecutionControl.UserException;
//
//@RestController
//@Component
//@RequestMapping("/user")
//public class UserController {
//
//	@Autowired
//	public IUserService userService;
//	
//	@ApiOperation("For Registration")
//	@PostMapping("/register")
//	public ResponseEntity<ResponseDTO> register(@RequestBody RegistrationDTO registrationDTO) throws UserException {
//		if(userService.register(registrationDTO))
//			return new ResponseEntity<ResponseDTO>(new ResponseDTO(200,"User Registration Successful"),HttpStatus.OK);
//		return new ResponseEntity<ResponseDTO>(new ResponseDTO(400,"User Registration UnSuccessful"),HttpStatus.BAD_REQUEST);
//			
//	}
//}
