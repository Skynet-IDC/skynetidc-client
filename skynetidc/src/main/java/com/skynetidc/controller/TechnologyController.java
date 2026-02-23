package com.skynetidc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
class HelpCenterController {

	@GetMapping("/faq")
	public String faq() {
		return "pages/help/faq";
	}

	@GetMapping("/support")
	public String support() {
		return "pages/help/support";
	}

	@GetMapping("/contact")
	public String contact() {
		return "pages/help/contact";
	}

	@GetMapping("/knowledgebase")
	public String knowledgebase() {
		return "pages/help/knowledgebase";
	}

}
