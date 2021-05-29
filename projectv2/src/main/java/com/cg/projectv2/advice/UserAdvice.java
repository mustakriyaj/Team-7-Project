package com.cg.projectv2.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.projectv2.dto.ErrorMessageDto;
import com.cg.projectv2.exception.UserIdException;
import com.cg.projectv2.exception.ValidateUserException;


@RestControllerAdvice
public class UserAdvice {
	
	@ExceptionHandler(UserIdException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleUserException(UserIdException exception) {
		return new ErrorMessageDto(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
		
	}
	
	@ExceptionHandler(ValidateUserException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handleUserException(ValidateUserException exception) {
		return new ErrorMessageDto(exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}
}
