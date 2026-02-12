package com.skynetidc.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReferralController {

	@GetMapping("/referral")
	public String login() {
		return "referral/index.html";
	}

}
