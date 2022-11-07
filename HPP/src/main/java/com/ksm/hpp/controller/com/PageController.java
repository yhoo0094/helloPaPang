package com.ksm.hpp.controller.com;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ksm.hpp.framework.util.RequestUtil;

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
	
	/**
	 * @메소드명: pageController
	 * @작성자: 김상민
	 * @생성일: 2022. 10. 23. 오후 2:45:11
	 * @설명: 페이지 이동 관리 컨트롤러
	 * @throws Exception
	 */
	@RequestMapping("/{url1}/{url2}")
	public ModelAndView pageController(HttpServletRequest request, HttpServletResponse response, @PathVariable("url1") String url1, @PathVariable("url2") String url2) throws Exception {
		ModelAndView result = new ModelAndView();
		
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		
		
		System.out.println(inData);
		
		result.setViewName(url1 + "/" + url2);
		return result;
	}	
	
	@RequestMapping("/popup.do")
	public ModelAndView popupController(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView result = new ModelAndView();
		
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		System.out.println(inData);
		
		result.setViewName((String) inData.get("view_nm"));
		result.addObject("param", inData);
		
		return result;
	}			
}
