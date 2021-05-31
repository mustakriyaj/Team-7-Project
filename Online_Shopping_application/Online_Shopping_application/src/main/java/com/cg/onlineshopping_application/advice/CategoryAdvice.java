package com.cg.onlineshopping_application.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.onlineshopping_application.dto.ErrorMessageDto;
import com.cg.onlineshopping_application.exception.CategoryIdException;
import com.cg.onlineshopping_application.exception.ValidateCategoryException;



@RestControllerAdvice
public class CategoryAdvice {

    @ExceptionHandler(CategoryIdException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessageDto handleCategoryException(CategoryIdException exception) {
        return new ErrorMessageDto(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
    }

    @ExceptionHandler(ValidateCategoryException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessageDto handleCategoryException(ValidateCategoryException exception) {
        return new ErrorMessageDto(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
    }

}
