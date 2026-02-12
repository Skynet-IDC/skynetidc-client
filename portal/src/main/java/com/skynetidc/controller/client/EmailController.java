package com.skynetidc.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/email")
class EmailController {

	@GetMapping
	public String email() {
		return "email/index";
	}

}
