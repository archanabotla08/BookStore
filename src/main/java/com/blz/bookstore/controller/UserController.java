package com.blz.bookstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blz.bookstore.dto.ForgetPasswordDTO;
import com.blz.bookstore.dto.LoginDTO;
import com.blz.bookstore.dto.RegistrationDTO;
import com.blz.bookstore.dto.ResetPasswordDTO;
import com.blz.bookstore.dto.ResponseDTO;
import com.blz.bookstore.exceptions.UserException;
import com.blz.bookstore.model.BookListDataModel;
import com.blz.bookstore.model.UserModel;
import com.blz.bookstore.service.IUserService;

import io.swagger.annotations.ApiOperation;


@RestController
@Component
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public IUserService userService;
	
	@ApiOperation("For Registration")
	@PostMapping("/register")
	public ResponseEntity<ResponseDTO> register(@RequestBody @Valid RegistrationDTO registrationDTO) throws UserException {
		if(userService.register(registrationDTO)) {
			ResponseDTO resDTO = new ResponseDTO(201,"User Registration Successful",true);
			return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
		}
		ResponseDTO resDTO = new ResponseDTO(400, "User Registration UnSuccessful");
		return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.BAD_REQUEST);	
	}
	
	 @ApiOperation("For login")
	    @PostMapping("/login")
	    public ResponseEntity<ResponseDTO> login(@RequestBody @Valid LoginDTO loginDTO) throws UserException {
	        String token = userService.login(loginDTO);
	        if(token!=null) {
	        	ResponseDTO resDTO = new ResponseDTO(200, "User login successful", token);
				return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
	        }
	        ResponseDTO resDTO = new ResponseDTO(400, "User Registration UnSuccessful");
			return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.NOT_ACCEPTABLE);	
	    }

	    @GetMapping("/verify/{token}")
	    public ResponseEntity<ResponseDTO> userVerification(@PathVariable("token") String token) throws UserException {

	        if (userService.verify(token)) {
	        	ResponseDTO resDTO = new ResponseDTO(200, "User verified successfully");
				return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
	        }
	        ResponseDTO resDTO = new ResponseDTO(400, "User verification failed");
			return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.NOT_ACCEPTABLE);
	    }
	    
	    @PostMapping("/forgot/password")
	    public ResponseEntity<ResponseDTO> forgotPassword(@RequestBody @Valid ForgetPasswordDTO emailId) {
	    	
	    	ResponseDTO response= userService.forgetPassword(emailId);
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	    }
	    
	    @PostMapping("/reset/password")
	    public ResponseEntity<ResponseDTO> resetPassword(@RequestBody @Valid ResetPasswordDTO resetPassword, @RequestHeader String token) throws UserException {
	        
	        if (userService.resetPassword(resetPassword, token)){
	        	ResponseDTO resDTO = new ResponseDTO(200, "User password reset successful");
				return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
	        }  
	        ResponseDTO resDTO = new ResponseDTO(400, "User password reset unsuccessful");
			return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.NOT_ACCEPTABLE);
	    }

}
