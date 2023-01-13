package com.ksm.hpp.framework.util;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.JsonObject;
import com.ksm.hpp.controller.com.BaseController;

//Controller.java에서 사용하는 Response관련 유틸
public class ResponseUtil {
	
	protected static final Log log = LogFactory.getLog(BaseController.class);
	
	/**
	 * @메소드명: setResAuto
	 * @작성자: 김상민
	 * @생성일: 2023. 1. 13. 오후 12:50:07
	 * @설명: 컨트롤러에서 클라이언트로 넘어가는 response 객체를 설정하고 출력
	 */
	public static void setResAuto(HttpServletResponse response, JsonObject result, Map<String, Object> inData, Map<String, Object> outData) throws Exception {
		
	}
}



	