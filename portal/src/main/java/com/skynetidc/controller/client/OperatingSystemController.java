package com.skynetidc.controller.client;

import com.skynetidc.services.OperatingSystemService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author hoaronal
 */
@Controller
@RequestMapping("/os")
class OperatingSystemController {

	private final OperatingSystemService operatingSystemService;

	OperatingSystemController(OperatingSystemService operatingSystemService) {
		this.operatingSystemService = operatingSystemService;
	}

	@ResponseBody
	@GetMapping
	public ResponseEntity<?> getByCode(@RequestParam String code) {
		return ResponseEntity.ok(operatingSystemService.getByCode(code));
	}

}
