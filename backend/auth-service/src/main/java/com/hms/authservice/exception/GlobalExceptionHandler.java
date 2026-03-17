package com.hms.authservice.exception;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hms.authservice.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse<Object>> handleResourcesNotFound(ResourceNotFoundException ex){
		ApiResponse<Object> response=ApiResponse.builder()
				.success(false)
				.message(ex.getMessage())
				.data(null)
				.build();
		
		return ResponseEntity
		        .status(HttpStatus.SC_NOT_FOUND)
		        .body(response);
	}
	
	
	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<ApiResponse<Object>> handleDuplicateResourcesException(ResourceNotFoundException ex){
		ApiResponse<Object> response=ApiResponse.builder()
				.success(false)
				.message(ex.getMessage())
				.data(null)
				.build();
		
		return ResponseEntity
		        .status(HttpStatus.SC_NOT_FOUND)
		        .body(response);
	}
	
	@ExceptionHandler(Exception.class) public ResponseEntity<ApiResponse<Object>> handleGenericException(Exception ex) {
		ApiResponse<Object> response = ApiResponse.builder()
				.success(false) 
				.message("Internal server error") 
				.data(null) .build(); 
		return ResponseEntity 
				.status(HttpStatus.SC_INTERNAL_SERVER_ERROR)
				.body(response);
	}
}
