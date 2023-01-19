package com.ksm.hpp.controller.com;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.ksm.hpp.service.com.CommonService;

@Controller
public class CommonController {
	
	@Resource(name = "CommonService")
	protected CommonService commonService;
	
}
