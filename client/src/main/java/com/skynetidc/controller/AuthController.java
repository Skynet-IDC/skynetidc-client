package com.skynetidc.controller;

import com.skynetidc.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

	private final UserRepository userRepository;

	public AuthController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/login")
	public String login() {
		return "auth/login.html";
	}

	@GetMapping("/signup")
	public String signup() {
		return "auth/signup.html";
	}

	@PostMapping("/signup")
	public String doSignup() {
		return "auth/signup.html";
	}

	@GetMapping("/password-recovery")
	public String passwordRecovery() {
		return "auth/password-recovery.html";
	}

}
