package com.skynetidc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class DomainController {

	@GetMapping("/domains")
	public String domain(@RequestParam String action) {
		if (action.equals("register")) {
			return "domain/checker";
		}
		else if (action.equals("transfer")) {
			return "domain/transfer";
		}
		else {
			return "domain/index";
		}
	}

}
