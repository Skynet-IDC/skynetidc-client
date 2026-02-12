package com.skynetidc.controller.client;

import com.skynetidc.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

	private final UserService userService;

	public AuthController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/login")
	public String login() {
		return "auth/login.html";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) throws ServletException {
		SecurityContextHolder.clearContext();
		request.logout();
		return "redirect:/login?logout=success";
	}

	@GetMapping("/signup")
	public String signup() {
		return "auth/signup.html";
	}

	@PostMapping("/signup")
	public String doSignup(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String email,
			@RequestParam String password) {
		userService.signup(firstname, lastname, email, password);
		return "redirect:/signup?success";
	}

	@GetMapping("/password-recovery")
	public String passwordRecovery() {
		return "auth/password-recovery.html";
	}

	@PostMapping("/reset-password")
	public String resetPassword(@RequestParam(name = "email") String email) {
		userService.resetPassword(email);
		return "redirect:/password-recovery?success";
	}

}
