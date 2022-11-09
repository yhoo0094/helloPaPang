package com.ksm.hpp.framework.util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.codec.binary.StringUtils;

//Controller.java에서 사용하는 Request관련 유틸
public class RequestUtil {
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
}

	