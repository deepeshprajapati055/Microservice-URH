package com.dp.user.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dp.user.service.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundExceptions.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundExceptions ex){
			String message = ex.getMessage();
			ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
			return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	}
}
