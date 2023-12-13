package com.ksm.hpp.controller.market;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;
import com.ksm.hpp.controller.com.BaseController;
import com.ksm.hpp.framework.util.RequestUtil;
import com.ksm.hpp.service.com.CommonService;
import com.ksm.hpp.service.market.EnterpriseService;

@Controller
@RequestMapping("/enterprise")
public class EnterpriseController extends BaseController {
	
	@Resource(name = "EnterpriseService")
	protected EnterpriseService enterpriseService;

	@Resource(name = "CommonService")
	protected CommonService commonService;
	
	String url = "market/enterprise";
	
	/**
	* @메소드명: insertEnterprise
	* @작성자: KimSangMin
	* @생성일: 2023. 12. 13. 오후 3:17:19
	* @설명: 기업장터 등록
	*/
	@RequestMapping("/insertEnterprise.do")
	public void insertEnterprise(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		Map<String, Object> loginInfo = RequestUtil.getLoginInfo(request);
		inData.put("loginInfo", loginInfo);
		
		//권한 확인
		inData.put("url", url);				//메뉴 경로
		inData.put("isRange", true);		//권한등급이 정확히 일치해야 하는지
		inData.put("reqAuthGrade", 2);		//필요 권한등급
		commonService.authChk((StringBuilder)request.getAttribute("IN_LOG_STR"), request, inData);
		
		MultipartFile image = request.getFile("image");
		Map<String, Object> outData = enterpriseService.insertEnterprise((StringBuilder)request.getAttribute("IN_LOG_STR"), inData, image);
		
		Gson gson = new Gson();
		String json = gson.toJson(outData);
		response.getWriter().print(json);	//결과 json형태로 담아서 보내기
		response.setContentType("application/x-json; charset=UTF-8");
	}
}


	