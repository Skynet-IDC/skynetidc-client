package com.skynetidc.controller.client;

import com.skynetidc.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

	private final UserRepository userRepository;

	public AccountController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/client")
	public String home() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();

		return "index";
	}

	@GetMapping("/profile")
	public String profile() {
		return "account/profile";
	}

	@GetMapping("/account-security")
	public String accountSecurity() {
		return "account/account-security";
	}

	@GetMapping("/account-settings")
	public String accountSettings() {
		return "account/account-settings";
	}

	@GetMapping("/email-history")
	public String emailHistory() {
		return "account/email-history";
	}

}
