package com.ksm.hpp.controller.user;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.ksm.hpp.framework.util.RequestUtil;
import com.ksm.hpp.service.com.CommonService;
import com.ksm.hpp.service.user.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name = "UserService")
	protected UserService userService;
	
	/**
	 * @메소드명: selectUser
	 * @작성자: 김상민
	 * @생성일: 2022. 11. 2. 오후 6:59:16
	 * @설명: 사용자 조회
	 */
	@RequestMapping("/selectUser")
	public void selectUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		Map<String, Object> outData = userService.selectUser((StringBuilder)request.getAttribute("IN_LOG_STR"), inData);
		
		Gson gson = new Gson();
		String json = gson.toJson(outData);
		
		System.err.println(json);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(json);	//결과 json형태로 담아서 보내기
	}	
	
	/**
	 * @메소드명: insertUser
	 * @작성자: 김상민
	 * @생성일: 2022. 11. 2. 오후 6:59:00
	 * @설명: 사용자 생성
	 */
	@RequestMapping("/insertUser")
	public void insertUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		Map<String, Object> outData = userService.insertUser((StringBuilder)request.getAttribute("IN_LOG_STR"), inData);
		
		System.err.println(inData);
		System.err.println(outData);
	}	
}
