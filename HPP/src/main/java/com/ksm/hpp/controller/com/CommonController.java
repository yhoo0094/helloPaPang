package com.ksm.hpp.controller.com;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ksm.hpp.service.com.CommonService;

@Controller
public class CommonController {
	
	@Resource(name = "CommonService")
	protected CommonService commonService;
	
	@RequestMapping("/")
	public String home() {
		return "com/homepage";
	}
	
	@RequestMapping("/test")
	public void test() {
		System.out.println("Test Start");
		commonService.test("test service do");
	}
}
