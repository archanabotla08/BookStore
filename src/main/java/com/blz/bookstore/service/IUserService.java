package com.blz.bookstore.service;

import com.blz.bookstore.dto.BookListDTO;
import com.blz.bookstore.dto.RegistrationDTO;
import com.blz.bookstore.exceptions.BookStoreException;
import com.blz.bookstore.model.BookListDataModel;
import com.blz.bookstore.model.UserModel;

import jdk.jshell.spi.ExecutionControl.UserException;

public interface IUserService {

	boolean register(RegistrationDTO registrationDTO) throws UserException;
	
}
