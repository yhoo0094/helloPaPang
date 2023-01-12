package com.ksm.hpp.controller.admin;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;
import com.ksm.hpp.controller.com.BaseController;
import com.ksm.hpp.framework.util.RequestUtil;
import com.ksm.hpp.service.admin.LoginLogService;
import com.ksm.hpp.service.info.NoticeService;

@Controller
@RequestMapping("/admin")
public class LoginLogController extends BaseController {
	
	@Resource(name = "LoginLogService")
	protected LoginLogService loginLogService;
	
	/**
	 * @메소드명: selectLoginLog
	 * @작성자: 김상민
	 * @생성일: 2023. 1. 12. 오후 3:42:25
	 * @설명: 사용자 접속 기록 조회
	 */
	@RequestMapping("/selectLoginLog.do")
	public void selectLoginLog(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		Map<String, Object> outData = loginLogService.selectLoginLog((StringBuilder)request.getAttribute("IN_LOG_STR"), inData);
		
		Gson gson = new Gson();
		String json = gson.toJson(outData);
		response.getWriter().print(json);	//결과 json형태로 담아서 보내기
		response.setContentType("application/x-json; charset=UTF-8");
	}	
}


	