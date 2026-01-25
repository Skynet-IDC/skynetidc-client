package com.skynetidc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

	@GetMapping("/profile")
	public String profile() {
		return "account/profile";
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
