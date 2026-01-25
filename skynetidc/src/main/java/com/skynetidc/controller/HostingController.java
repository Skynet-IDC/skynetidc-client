package com.skynetidc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hosting")
class HostingController {

	@GetMapping("/shared-hosting.html")
	public String shared() {
		return "hosting/shared-hosting";
	}

	@GetMapping("/wp-hosting.html")
	public String wp() {
		return "hosting/wp-hosting";
	}

	@GetMapping("/joomla-hosting.html")
	public String joomla() {
		return "hosting/joomla-hosting";
	}

	@GetMapping("/magento-hosting.html")
	public String magento() {
		return "hosting/joomla-hosting";
	}

	@GetMapping("/opencart-hosting.html")
	public String opencart() {
		return "hosting/opencart-hosting";
	}

	@GetMapping("/prestashop-hosting.html")
	public String prestashop() {
		return "hosting/prestashop-hosting";
	}

	@GetMapping("/drupal-hosting.html")
	public String drupal() {
		return "hosting/drupal-hosting";
	}

}
