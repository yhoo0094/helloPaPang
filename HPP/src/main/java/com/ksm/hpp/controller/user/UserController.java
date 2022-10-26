package com.ksm.hpp.controller.user;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ksm.hpp.framework.util.RequestUtil;
import com.ksm.hpp.service.com.CommonService;
import com.ksm.hpp.service.user.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name = "UserService")
	protected UserService userService;
	
	@RequestMapping("/insertUser")
	public void insertUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		Map<String, Object> outData = userService.insertUser((StringBuilder)request.getAttribute("IN_LOG_STR"), inData);
		
		System.err.println(inData);
		System.err.println(outData);
	}	
}
