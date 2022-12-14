package com.ksm.hpp.framework.util;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.codec.binary.StringUtils;

import com.ksm.hpp.controller.com.BaseController;

//Controller.java에서 사용하는 Request관련 유틸
public class RequestUtil {
	
	protected static final Log log = LogFactory.getLog(BaseController.class);
	
	/**
	 * @메소드명: getParameterMap
	 * @작성자: 김상민
	 * @생성일: 2023. 1. 9. 오전 11:21:32
	 * @설명: 파라미터 값 조회
	 */
	public static Map<String, Object> getParameterMap(HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, String[]> requestMap = request.getParameterMap();
		
		for(String key : requestMap.keySet()) {
			//json으로 넘어온 경우_추후 필요시 구현
			
			//일반적인 주소 입력
			String[] params = (String[]) requestMap.get(key);
			if(params.length > 1) {
				//get방식인 경우 한글 인코딩
				if("GET".equals(request.getMethod())){
					for(int i = 0; i < params.length; i++) {
						byte[] b = params[i].getBytes("euc-kr");
						params[i] = StringUtils.newStringUtf8(b);	//기존프레임워크에서 newStringIso8859_1 메서드 사용하였으나 해당 메서드가 없어서 UTF==tf8 사용
					}
				}
				
				result.put(key.replaceAll("[\\[\\]]", ""), params);
			} else {
				//get방식인 경우 한글 인코딩
				String param = "";
				if("GET".equals(request.getMethod())){
					byte[] b = params[0].getBytes("euc-kr");
					param = StringUtils.newStringUtf8(b);	//기존프레임워크에서 newStringIso8859_1 메서드 사용하였으나 해당 메서드가 없어서 UTF==tf8 사용
				} else {
					param = params[0];
				}
				
				result.put(key.replaceAll("[\\[\\]]", ""), param);				
			}
		};
		
		return result;

	}
	
	/**
	 * @메소드명: getLoginInfo
	 * @작성자: 김상민
	 * @생성일: 2023. 1. 9. 오후 2:00:00
	 * @설명: 로그인 정보 가져오기
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getLoginInfo(HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		result = (Map<String, Object>) session.getAttribute(Constant.LOGIN_INFO);
		return result;
	}
	
	/**
	 * @메소드명: getIpAddr
	 * @작성자: 김상민
	 * @생성일: 2023. 1. 9. 오후 2:08:04
	 * @설명: 사용자의 IP주소 구하기
	 */
	public static String getIpAddr(HttpServletRequest request) throws Exception {
	    String ipAddr = request.getHeader("X-Forwarded-For");
	    //log.info("> X-FORWARDED-FOR : " + ipAddr);

	    if (ipAddr == null) {
	        ipAddr = request.getHeader("Proxy-Client-IP");
	        //log.info("> Proxy-Client-IP : " + ipAddr);
	    }
	    if (ipAddr == null) {
	        ipAddr = request.getHeader("WL-Proxy-Client-IP");
	        //log.info(">  WL-Proxy-Client-IP : " + ipAddr);
	    }
	    if (ipAddr == null) {
	        ipAddr = request.getHeader("HTTP_CLIENT_IP");
	        //log.info("> HTTP_CLIENT_IP : " + ipAddr);
	    }
	    if (ipAddr == null) {
	        ipAddr = request.getHeader("HTTP_X_FORWARDED_FOR");
	        //log.info("> HTTP_X_FORWARDED_FOR : " + ipAddr);
	    }
	    if (ipAddr == null) {
	        ipAddr = request.getRemoteAddr();
	        //log.info("> getRemoteAddr : "+ipAddr);
	    }
	    if ("0:0:0:0:0:0:0:1".equals(ipAddr)) {
	    	ipAddr = Inet4Address.getLocalHost().getHostAddress();
	    	//log.info("> getHostAddress : "+ipAddr);
	    }
	    log.info("> IP Address : "+ipAddr);		
		
		return ipAddr;
	}
	
}



	