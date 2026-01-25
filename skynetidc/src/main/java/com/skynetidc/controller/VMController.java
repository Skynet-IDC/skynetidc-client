package com.skynetidc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vm")
class VMController {

	@GetMapping("/cloud-compute")
	public String getVMById() {
		return "server/cloud-compute";
	}

	@GetMapping("/vps")
	public String window() {
		return "server/vps";
	}

}
