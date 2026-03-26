package com.skynetidc.controller.client;

import com.skynetidc.services.VPSService;
import com.skynetidc.util.SecurityUtil;
import com.skynetidc.vo.ResponseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vm")
class VmController extends BaseController {

	private final VPSService vpsService;

	private final SecurityUtil securityUtil;
	public VmController(VPSService vpsService, SecurityUtil securityUtil) {
		this.vpsService = vpsService;
		this.securityUtil = securityUtil;
	}

	@GetMapping("/{id}")
	public String view(@PathVariable long id, Model model) {
		model.addAttribute("result", vpsService.getVPSById(id).getItem());
		return "vm/detail";
	}

	@ResponseBody
	@DeleteMapping
	public ResponseEntity<?> suspendVps(@RequestParam long id) {
		vpsService.suspendById(id);
		return ResponseEntity.ok(new ResponseResult("200", "Success"));
	}

	@GetMapping
	public String vps(Model model) {
		model.addAttribute("result", vpsService.listAllVpsByOwner(securityUtil.userIdAuth()).getItems());
		return "vm/list";
	}

	@GetMapping("/node")
	public String node(Model model) {
		model.addAttribute("result", vpsService.listAllVpsByOwner(securityUtil.userIdAuth()).getItems());
		return "vm/list";
	}

}
