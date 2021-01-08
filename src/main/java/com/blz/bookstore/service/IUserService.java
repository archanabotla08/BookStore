package com.blz.bookstore.service;

import javax.mail.MessagingException;

import org.springframework.stereotype.Component;

import com.blz.bookstore.dto.ForgetPasswordDTO;
import com.blz.bookstore.dto.LoginDTO;
import com.blz.bookstore.dto.RegistrationDTO;
import com.blz.bookstore.dto.ResetPasswordDTO;
import com.blz.bookstore.dto.ResponseDTO;
import com.blz.bookstore.exceptions.UserException;

@Component("IUserService")
public interface IUserService {

	boolean register(RegistrationDTO registrationDTO) throws UserException;

	String login(LoginDTO loginDto) throws UserException;

	boolean verify(String token) throws UserException;

	ResponseDTO forgetPassword(ForgetPasswordDTO userModel) throws MessagingException;

	boolean resetPassword(ResetPasswordDTO resetPassword, String token) throws UserException;

}