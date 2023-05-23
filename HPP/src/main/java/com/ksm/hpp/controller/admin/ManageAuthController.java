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
import com.ksm.hpp.service.admin.ManageAuthService;

@Controller
@RequestMapping("/admin")
public class ManageAuthController extends BaseController {
	
	@Resource(name = "ManageAuthService")
	protected ManageAuthService manageAuthService;
	
	/**
	* @메소드명: selectMnuListLv1
	* @작성자: KimSangMin
	* @생성일: 2023. 5. 23. 오후 7:45:55
	* @설명: 메뉴 목록 조회
	*/
	@RequestMapping("selectMnuListLv1.do")
	public void selectMnuListLv1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		Map<String, Object> outData = manageAuthService.selectMnuListLv1((StringBuilder)request.getAttribute("IN_LOG_STR"), inData);
		
		ResponseUtil.setResAuto(response, inData, outData);
	}	
	
	/**
	* @메소드명: selectRoleListAuth
	* @작성자: KimSangMin
	* @생성일: 2023. 5. 23. 오후 8:16:08
	* @설명: 권한그룹 목록 조회
	*/
	@RequestMapping("selectRoleListAuth.do")
	public void selectRoleListAuth(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		Map<String, Object> outData = manageAuthService.selectRoleListAuth((StringBuilder)request.getAttribute("IN_LOG_STR"), inData);
		
		ResponseUtil.setResAuto(response, inData, outData);
	}	
	
	/**
	* @메소드명: selectMnuListTable
	* @작성자: KimSangMin
	* @생성일: 2023. 5. 23. 오후 8:56:50
	* @설명: 메뉴 목록 조회
	*/
	@RequestMapping("selectMnuListTable.do")
	public void selectMnuListTable(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		Map<String, Object> outData = manageAuthService.selectMnuListTable((StringBuilder)request.getAttribute("IN_LOG_STR"), inData);
		
		ResponseUtil.setResAuto(response, inData, outData);
	}		
}


	