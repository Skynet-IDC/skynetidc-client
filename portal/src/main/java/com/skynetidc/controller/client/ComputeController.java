package com.skynetidc.controller.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cloud-compute")
public class ComputeController {

	@GetMapping
	public String getVM() {
		return "server/cloud-compute";
	}

}
