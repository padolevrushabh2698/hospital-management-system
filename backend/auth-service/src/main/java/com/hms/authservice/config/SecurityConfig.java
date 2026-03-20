package com.hms.authservice.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hms.authservice.DTO.RegisterRequestDTO;
import com.hms.authservice.DTO.UserResponseDTO;
import com.hms.authservice.response.ApiResponse;

import jakarta.validation.Valid;

public class SecurityConfig {
	
	
	
	@PostMapping("/register")
	public ResponseEntity<ApiResponse<Object>> registerUser( @Valid @RequestBody RegisterRequestDTO request){
		
		//UserResponseDTO response=authservice.registerUser(request);
		
		return ResponseEntity.ok(ApiResponse.builder()
				.success(true)
				.message("user registration sucessful")
			//	.data(response)
				.build()
				);
	}
}
