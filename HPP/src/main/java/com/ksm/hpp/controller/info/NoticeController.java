package com.ksm.hpp.controller.info;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ksm.hpp.service.user.UserService;

@Controller
@RequestMapping("/info")
public class NoticeController {
	
	private static final Logger logger = LogManager.getLogger("Application");
	
	@Resource(name = "UserService")
	protected UserService userService;
	
}


	