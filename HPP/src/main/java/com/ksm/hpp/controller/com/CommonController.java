package com.ksm.hpp.controller.com;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ksm.hpp.service.com.CommonService;
import com.ksm.hpp.vo.Article;

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
	
	/*
	@RequestMapping("/")
	public String home(HttpServletRequest request, HttpServletResponse response) {
		
		return "com/homepage";
	}
	*/
	
	@RequestMapping("/test")
	public List<Map<String, Object>> test() throws Exception {
		//Map<String, Object> inData = new HashMap<String, Object>();
		//System.out.println("Controller Start");
		//commonService.test(inData);
		return this.commonService.test();
	}
	
	//글 조회
	@GetMapping("/{articleId}")
	@ResponseBody
	public Map<String, Object> viewDetail(@PathVariable String articleId) {
		Map<String, Object> map = new HashMap<String, Object>();
		//Article article
		map = this.commonService.viewArticleDetail(articleId);
		//System.out.println(map);
		return map;
	}	
}
