package com.zepto.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zepto.auth.dto.AuthResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<AuthResponse> handleInvalidCredentialsException(
	        InvalidCredentialsException ex) {

	    return ResponseEntity
	            .status(HttpStatus.UNAUTHORIZED)
	            .body(new AuthResponse(ex.getMessage()));
	}
    
    

}