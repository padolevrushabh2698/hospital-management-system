package com.hms.authservice.controller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hms.authservice.DTO.RegisterRequestDTO;
import com.hms.authservice.DTO.UserResponseDTO;
import com.hms.authservice.response.ApiResponse;
import com.hms.authservice.response.PaginationResponse;
import com.hms.authservice.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authservice;
	
	@PostMapping("/register")
	public ResponseEntity<ApiResponse<Object>> registerUser( @Valid @RequestBody RegisterRequestDTO request){
		
		UserResponseDTO response=authservice.registerUser(request);
		
		return ResponseEntity.ok(ApiResponse.builder()
				.success(true)
				.message("user registration sucessful")
				.data(response)
				.build()
				);
	}
	
	

	
	@GetMapping("/users/{id}")
	public ResponseEntity<ApiResponse<Object>> getUserById( @PathVariable ("id") Long id){
		
		UserResponseDTO user=authservice.getUserById(id);
		
		return ResponseEntity.ok(ApiResponse.builder()
				.success(true)
				.message("User Fetched Successfully")
				.data(user)
				.build()
				);
	}
	
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<ApiResponse<Object>> deleteUser( @PathVariable ("id") Long id){
		
		authservice.deleteUser(id);
		
		return ResponseEntity.ok(ApiResponse.builder()
				.success(true)
				.message("user delete successfully")
				.data("deleted")
				.build()
				);
	}
	
	@GetMapping("/users")
	public  ResponseEntity<ApiResponse<Object>> getAllUsers(Pageable pageable){
		Page<UserResponseDTO> users=authservice.getAllUsers(pageable);
		
		PaginationResponse<UserResponseDTO> response=PaginationResponse.fromPage(users);
		return ResponseEntity.ok(
				ApiResponse.builder()
				.success(true)
				.message("users fetched successfully")
				.data(response)
				.build()
				);
		
	}

}
