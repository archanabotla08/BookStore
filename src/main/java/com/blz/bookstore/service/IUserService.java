package com.blz.bookstore.service;

import org.springframework.stereotype.Component;

import com.blz.bookstore.dto.BookListDTO;
import com.blz.bookstore.dto.ForgetPasswordDTO;
import com.blz.bookstore.dto.LoginDTO;
import com.blz.bookstore.dto.RegistrationDTO;
import com.blz.bookstore.dto.ResetPasswordDTO;
import com.blz.bookstore.dto.ResponseDTO;
import com.blz.bookstore.exceptions.BookStoreException;
import com.blz.bookstore.exceptions.UserException;
import com.blz.bookstore.model.UserModel;


@Component("IUserService")
public interface IUserService {

	boolean register(RegistrationDTO registrationDTO) throws UserException;
	
	String login(LoginDTO loginDto) throws UserException;

	boolean verify(String token) throws UserException;

	ResponseDTO forgetPassword(ForgetPasswordDTO userModel);

	boolean resetPassword(ResetPasswordDTO resetPassword, String token) throws UserException;
	
}
