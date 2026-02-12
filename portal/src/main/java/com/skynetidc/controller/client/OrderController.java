package com.skynetidc.controller.client;

import com.skynetidc.dto.OrderRequest;
import com.skynetidc.services.VPSService;
import com.skynetidc.vo.ResponseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author hoaronal
 */
@Controller
@RequestMapping("/order")
class OrderController {

	private final VPSService vpsService;

	OrderController(VPSService vpsService) {
		this.vpsService = vpsService;
	}

	@GetMapping("/vm")
	public String orderVps(Model model) {
		return "vm/create";
	}

	@GetMapping("/website")
	public String orderWebsite(Model model) {
		return "web/create";
	}

	@ResponseBody
	@PostMapping("/vm")
	public ResponseEntity<?> createVps(@RequestBody OrderRequest request) {
		vpsService.createVPS(request);
		return ResponseEntity.ok(new ResponseResult("200", "Success"));
	}

}
