package com.skynetidc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HostingController {

	@GetMapping("/shared-hosting")
	public String shared() {
		return "pages/hosting/shared-hosting";
	}

	@GetMapping("/wordpress-hosting")
	public String wp() {
		return "pages/hosting/wordpress-hosting";
	}

	@GetMapping("/cloud-hosting")
	public String cloud() {
		return "pages/hosting/cloud-hosting";
	}

	@GetMapping("/dedicated-hosting")
	public String dedicated() {
		return "pages/hosting/dedicated-hosting";
	}

	@GetMapping("/vps-hosting")
	public String vps() {
		return "pages/hosting/vps-hosting";
	}

	@GetMapping("/reseller-hosting")
	public String reseller() {
		return "pages/hosting/reseller-hosting";
	}
}
