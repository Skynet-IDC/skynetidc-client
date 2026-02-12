package com.skynetidc.controller.client;

import com.skynetidc.services.PlanService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author hoaronal
 */
@Controller
@RequestMapping("/plan")
class PlanController {

	private final PlanService planService;

	PlanController(PlanService planService) {
		this.planService = planService;
	}

	@ResponseBody
	@GetMapping
	public ResponseEntity<?> plans(@RequestParam String location) {
		return ResponseEntity.ok(planService.getPlanByGroup(location));
	}

}
