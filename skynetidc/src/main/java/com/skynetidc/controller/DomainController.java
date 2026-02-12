package com.skynetidc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class DomainController {

	@GetMapping("/domain-checker")
	public String checker() {
		return "pages/domain/domain-checker";
	}

	@GetMapping("/domain-transfer")
	public String transfer() {
		return "pages/domain/domain-transfer";
	}

	@GetMapping("/domain-registration")
	public String registration() {
		return "pages/domain/domain-registration";
	}

	@GetMapping("/whois")
	public String whois() {
		return "pages/domain/whois";
	}
}
