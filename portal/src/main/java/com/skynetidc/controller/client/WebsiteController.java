package com.skynetidc.controller.client;

import com.skynetidc.dto.OrderRequest;
import com.skynetidc.vo.ResponseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/website")
class WebsiteController {

	@GetMapping
	public String website(Model model) {
		return "web/index";
	}

	@ResponseBody
	@PostMapping
	public ResponseEntity<?> createWebsite(@RequestBody OrderRequest request) {

		return ResponseEntity.ok(new ResponseResult("200", "Success"));
	}

}
