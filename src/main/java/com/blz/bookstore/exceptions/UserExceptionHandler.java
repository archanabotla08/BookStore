package com.blz.bookstore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.blz.bookstore.dto.ResponseDTO;

@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<ResponseDTO> handleUserException(UserException exception) {
		ResponseDTO responseDTO = new ResponseDTO(400, "Enter Valid Data", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
}
