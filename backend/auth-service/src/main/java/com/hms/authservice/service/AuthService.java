package com.hms.authservice.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hms.authservice.DTO.RegisterRequestDTO;
import com.hms.authservice.DTO.UserResponseDTO;

public interface AuthService {
	
	UserResponseDTO registerUser(RegisterRequestDTO request);
	UserResponseDTO getUserById(Long userId); 
	void deleteUser(Long userId);
	Page<UserResponseDTO> getAllUsers(Pageable pageable);

}
