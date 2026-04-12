package com.skynetidc.controller.api;

import com.skynetidc.controller.client.BaseController;
import com.skynetidc.services.VPSService;
import com.skynetidc.vo.ResponseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vm")
class RestVmController extends BaseController {

	private final VPSService vpsService;

	public RestVmController(VPSService vpsService) {
		this.vpsService = vpsService;
	}

	@GetMapping("/{id}")
	public String view(@PathVariable long id, Model model) {
		model.addAttribute("result", vpsService.getVPSById(id).getItem());
		return "vm/detail";
	}

	@DeleteMapping
	public ResponseEntity<?> suspendVps(@RequestParam long id) {
		vpsService.suspendById(id);
		return ResponseEntity.ok(new ResponseResult("200", "Success"));
	}

	@GetMapping("/owner")
	public ResponseEntity<?> getVmByOwner() {
		return ResponseEntity.ok(vpsService.listAllVpsByOwner().getItems());
	}
}
