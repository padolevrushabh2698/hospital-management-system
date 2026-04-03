package com.hms.authservice.mapper;

import com.hms.authservice.DTO.UserResponseDTO;
import com.hms.authservice.entity.User;

public class UserMapper {
	
	public static UserResponseDTO mapToResponse(User savedUser) {
		 return UserResponseDTO.builder()
		            .id(savedUser.getId())
		            .username(savedUser.getUsername())
		            .email(savedUser.getEmail())
		            .role(savedUser.getRole())
		            .build();
	}

}
