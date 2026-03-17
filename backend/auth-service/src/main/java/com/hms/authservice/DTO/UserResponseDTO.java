package com.hms.authservice.DTO;

import com.hms.authservice.enums.UserRole;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDTO {
	
	private Long id;
    private String username;
    private String email;
    private UserRole role;

}
