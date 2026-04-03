package com.hms.authservice.DTO;

import com.hms.authservice.enums.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class RegisterRequestDTO {
	@NotBlank(message = "Username is required")
	private String username;
	@Email(message = "Invalid email format")
	private String email;
	@NotBlank(message = "Password is required")
	private String password;
	
	private UserRole role;

}
