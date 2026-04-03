package com.hms.authservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.hms.authservice.DTO.UserResponseDTO;
import com.hms.authservice.entity.User;
import com.hms.authservice.exception.ResourceNotFoundException;
import com.hms.authservice.repository.UserRepository;
import com.hms.authservice.service.impl.AuthServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AuthServiceImplTest {
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private AuthServiceImpl authservice;
	
	private User user;
	
	@BeforeEach
	void setup() {
		user=User.builder()
				.id(1L)
				.username("testuser")
				.email("test@gmail.com")
				.password("123")
				.build();
	}
	
	@Test
	void testGetUserById_Success() {
		
		when(userRepository.findById(1L)).thenReturn(Optional.of(user));
		
		UserResponseDTO response=authservice.getUserById(1L);
		
		assertNotNull(response);
		assertEquals("testuser", response.getUsername());
	}
	
	@Test
	void testGetUserById_NotFound() {
		when(userRepository.findById(1L)).thenReturn(Optional.empty());
		
		
	assertThrows(ResourceNotFoundException.class,
			()-> {authservice.getUserById(1L);
	
		
	});
	}
	
	@Test
	void testGetAllUsers() { Pageable pageable = PageRequest.of(0, 2);
	Page<User> userPage = new PageImpl<>(List.of(user));
	when(userRepository.findAll(pageable)).thenReturn(userPage); 
	var response = authservice.getAllUsers(pageable);
	assertNotNull(response); 
	assertEquals(1, response.getContent().size()); 
	}
	
	@Test
	void testdelteuser() {
		when(userRepository.existsById(1L)).thenReturn(true);
		authservice.deleteUser(1L);
		
		verify(userRepository, times(1)).deleteById(1L);
	}

}
