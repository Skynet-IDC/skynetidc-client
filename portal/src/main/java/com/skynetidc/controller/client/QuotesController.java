package com.skynetidc.controller.client;

import com.skynetidc.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quotes")
public class QuotesController {

	private final UserRepository userRepository;

	public QuotesController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping
	public String quotes() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();

		return "quotes/index";
	}

	@GetMapping("/{id}")
	public String invoiceDetail(@PathVariable String id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();

		return "quotes/detail";
	}

}
