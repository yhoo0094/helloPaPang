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
import org.springframework.web.servlet.ModelAndView;

import com.ksm.hpp.framework.util.RequestUtil;
import com.ksm.hpp.service.com.CommonService;
import com.ksm.hpp.vo.Article;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name = "CommonService")
	protected CommonService commonService;
	
	@RequestMapping("/insertUser")
	public void pageController(HttpServletRequest request, HttpServletResponse response, @PathVariable("url1") String url1, @PathVariable("url2") String url2) throws Exception {
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		System.err.println(inData);
	}	
}
