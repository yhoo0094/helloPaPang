package com.ksm.hpp.controller.com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	
	@RequestMapping("/")
	public String home() {
		return "homepage";
	}
}
