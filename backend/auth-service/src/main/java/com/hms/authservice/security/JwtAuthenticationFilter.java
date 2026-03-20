package com.hms.authservice.security;

import java.net.http.HttpRequest;

import org.apache.hc.core5.http.io.HttpServerRequestHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter {
	
	private final JwtUtil jwtUtil;
	public JwtAuthenticationFilter(HttpServletRequest request,
			HttpServletResponse response,
			FilterChain
			filterChain) {
				this.jwtUtil = new JwtUtil();
		
	}

}
