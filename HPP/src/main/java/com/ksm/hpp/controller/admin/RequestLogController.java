package com.ksm.hpp.controller.admin;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.ksm.hpp.controller.com.BaseController;
import com.ksm.hpp.framework.util.RequestUtil;
import com.ksm.hpp.framework.util.ResponseUtil;
import com.ksm.hpp.service.admin.RequestLogService;

@Controller
@RequestMapping("/admin")
public class RequestLogController extends BaseController {
	
	@Resource(name = "RequestLogService")
	protected RequestLogService requestLogService;
	
	/**
	* @메소드명: selectRequestLog
	* @작성자: KimSangMin
	* @생성일: 2023. 1. 30. 오후 2:58:09
	* @설명: 서버에 발생한 요청 기록 조회
	*/
	@RequestMapping("/selectRequestLog.do")
	public void selectRequestLog(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		Map<String, Object> outData = requestLogService.selectRequestLog((StringBuilder)request.getAttribute("IN_LOG_STR"), inData);
		
		ResponseUtil.setResAuto(response, inData, outData);
	}	
}


	