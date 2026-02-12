package com.skynetidc.controller.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/server")
class ServerController {

	@GetMapping("/{id}")
	public String getVMById() {
		return "server/linux-vps";
	}

	@GetMapping("/windows-vps.html")
	public String window() {
		return "server/windows-vps";
	}

	@GetMapping("/cloud-compute.html")
	public String dedicated() {
		return "server/dedicated-server";
	}

}
