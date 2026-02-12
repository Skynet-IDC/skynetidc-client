package com.skynetidc.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/domains")
class DomainController {

	@GetMapping
	public String domain() {
		return "domain/index";
	}

	@GetMapping("/checker")
	public String checker() {
		return "domain/checker";
	}

	@GetMapping("/transfer")
	public String transfer() {
		return "domain/transfer";
	}

}
