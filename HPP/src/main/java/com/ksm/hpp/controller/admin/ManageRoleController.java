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
import com.ksm.hpp.service.admin.LoginLogService;

@Controller
@RequestMapping("/admin")
public class ManageRoleController extends BaseController {
	
	@Resource(name = "LoginLogService")
	protected LoginLogService loginLogService;
	
	/**
	* @메소드명: selectRoleList
	* @작성자: KimSangMin
	* @생성일: 2023. 5. 4. 오후 9:50:14
	* @설명:
	*/
	@RequestMapping("/selectRoleList.do")
	public void selectRoleList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		Map<String, Object> outData = loginLogService.selectLoginLog((StringBuilder)request.getAttribute("IN_LOG_STR"), inData);
		
		ResponseUtil.setResAuto(response, inData, outData);
		
//		Gson gson = new Gson();
//		String json = gson.toJson(outData);
//		response.getWriter().print(json);	//결과 json형태로 담아서 보내기
//		response.setContentType("application/x-json; charset=UTF-8");
	}	
}


	