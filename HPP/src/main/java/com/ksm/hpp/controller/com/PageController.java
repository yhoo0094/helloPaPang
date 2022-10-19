package com.ksm.hpp.controller.com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	/**
	 * @메소드명: tilesSample
	 * @작성자: 김상민
	 * @생성일: 2022. 10. 18. 오후 7:29:38
	 * @설명: tiles 테스트
	 */
	@RequestMapping("/tiles")
	public String tilesSample(HttpServletRequest request, HttpServletResponse response) {
		
		return "com/tilesSample";
	}
	
	/**
	 * @메소드명: home
	 * @작성자: 김상민
	 * @생성일: 2022. 10. 19. 오전 7:46:01
	 * @설명: 홈페이지 이동
	 */
	@RequestMapping("/")
	public String home(HttpServletRequest request, HttpServletResponse response) {
		
		return "com/home";
	}	
}
