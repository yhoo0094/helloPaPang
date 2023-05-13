package com.ksm.hpp.controller.admin;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ksm.hpp.controller.com.BaseController;
import com.ksm.hpp.framework.util.RequestUtil;
import com.ksm.hpp.framework.util.ResponseUtil;
import com.ksm.hpp.service.admin.ManageMnuService;

@Controller
@RequestMapping("/admin")
public class ManageMnuController extends BaseController {
	
	@Resource(name = "ManageMnuService")
	protected ManageMnuService manageMnuService;
	
	/**
	* @메소드명: selectMnuList
	* @작성자: KimSangMin
	* @생성일: 2023. 5. 13. 오후 2:33:14
	* @설명: 메뉴 목록 조회
	*/
	@RequestMapping("/selectMnuList.do")
	public void selectMnuList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		Map<String, Object> outData = manageMnuService.selectMnuList((StringBuilder)request.getAttribute("IN_LOG_STR"), inData);
		
		ResponseUtil.setResAuto(response, inData, outData);
	}	
	
}


	