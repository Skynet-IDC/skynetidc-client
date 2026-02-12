package com.skynetidc.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/settings")
public class SettingController {

	@GetMapping("/api-docs")
	public String login() {
		return "settings/api-docs.html";
	}

	@GetMapping("/ssh-keys")
	public String signup() {
		return "settings/ssh-keys.html";
	}

}
