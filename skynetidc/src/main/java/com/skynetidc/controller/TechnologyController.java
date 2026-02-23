package com.skynetidc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
class TechnologyController {

	@GetMapping("/technology")
	public String technology() {
		return "pages/technology/technology";
	}

	@GetMapping("/data-centers")
	public String dataCenters() {
		return "pages/technology/data-center";
	}

}
