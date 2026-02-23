package com.skynetidc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
class HomeController {

	@GetMapping
	public String home() {
		return "pages/home";
	}

	@GetMapping("/about")
	public String about() {
		return "pages/about";
	}

	@GetMapping("/blog")
	public String blog() {
		return "pages/blog";
	}

	@GetMapping("/affiliate")
	public String affiliate() {
		return "pages/affiliate";
	}

}
