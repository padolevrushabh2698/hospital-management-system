package com.hms.authservice.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hms.authservice.DTO.RegisterRequestDTO;
import com.hms.authservice.DTO.UserResponseDTO;
import com.hms.authservice.entity.User;
import com.hms.authservice.exception.DuplicateResourceException;
import com.hms.authservice.exception.ResourceNotFoundException;
import com.hms.authservice.mapper.UserMapper;
import com.hms.authservice.repository.UserRepository;
import com.hms.authservice.service.AuthService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
	private static final Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);
	private final UserRepository userRepository;
	

	@Override
	public UserResponseDTO registerUser(RegisterRequestDTO request) {
	log.info("registering new user with email",request.getEmail());	
		
		userRepository.findByEmail(request.getEmail())
		.ifPresent(user->{
			log.warn("registration failed.email already exists: ",request.getEmail());
			throw new DuplicateResourceException("EMAIL ALREADY PRESENT");
		});
		
		userRepository.findByUsername(request.getUsername()).ifPresent(user->{
			log.warn("registration failed username already present",request.getUsername());
			throw new DuplicateResourceException("USERNAME ALREADY PRESENT");
		});
		
		
		User user=User.builder()
				.username(request.getUsername())
				.email(request.getEmail())
				.password(request.getPassword())
				.role(request.getRole())
				.createdAt(LocalDateTime.now())
				.build();
		log.info("saving user ");
		User savedUser=userRepository.save(user);
		log.info("map the user to response");
		return UserMapper.mapToResponse(savedUser);
				
	}


	@Override
	public UserResponseDTO getUserById(Long userId) {
		log.info("Fetching user with id: ", userId);
		User user=userRepository.findById(userId)
				
				.orElseThrow(()-> new ResourceNotFoundException("user not found"));
		log.error("User not found with id:", userId);
		return UserMapper.mapToResponse(user);
				
	}

	@Override
	public void deleteUser(Long userId) {
		log.error("deleting the user: {}", userId);
		if (!userRepository.existsById(userId)) {
			
			log.error("deleting faild user not found with id:",userId);
			throw new ResourceNotFoundException("user not find");
		}
		
		userRepository.deleteById(userId);
		
	}



	@Override
	public Page<UserResponseDTO> getAllUsers(Pageable pageable) {
		log.info("Fetching users with pageable: {}", pageable);

		Page<User> userPage=userRepository.findAll(pageable);
		
		return userPage.map(UserMapper::mapToResponse);
	}

}
