package com.skynetidc.controller.client;

import com.skynetidc.dto.AuthRequest;
import com.skynetidc.dto.AuthResponse;
import com.skynetidc.security.JwtService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/auth")
public class AuthApiController {

	private final AuthenticationManager authenticationManager;

	private final JwtService jwtService;

	public AuthApiController(AuthenticationManager authenticationManager, JwtService jwtService) {
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest request) {
		Authentication authentication = authenticationManager
			.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String token = jwtService.generateToken(userDetails);

		assert userDetails != null;
		return ResponseEntity
			.ok(new AuthResponse(userDetails.getUsername(), userDetails.getUsername(), "/images/avatars/1.png", token));
	}

}
