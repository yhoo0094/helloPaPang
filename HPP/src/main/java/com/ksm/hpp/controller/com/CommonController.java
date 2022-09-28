package com.ksm.hpp.controller.com;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ksm.hpp.service.com.CommonService;

@Controller
public class CommonController {
	
	@Resource(name = "CommonService")
	protected CommonService commonService;
	
	/**
	 * @메소드명: home
	 * @작성자: DGB데이터시스템 - 김상민
	 * @생성일: 2022. 9. 23. 오전 8:20:41
	 * @설명:
	 */
	@RequestMapping("/")
	public String home(HttpServletRequest request, HttpServletResponse response) {
		
		return "com/homepage";
	}
	
	@RequestMapping("/test")
	public void test() {
		System.out.println("Test Start");
		commonService.test("test service do");
	}
}
