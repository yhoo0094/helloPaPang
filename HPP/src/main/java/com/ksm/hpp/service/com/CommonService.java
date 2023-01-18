package com.ksm.hpp.service.com;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksm.hpp.framework.util.Constant;

@Service("CommonService")
public class CommonService extends BaseService {
	
	@Autowired
	SqlSession sqlSession; //SqlSession 빈 DI	

	/**
	* @메소드명: insertReqLog
	* @작성자: KimSangMin
	* @생성일: 2023. 1. 18. 오후 3:24:55
	* @설명: 요청 로그 저장
	 */
	public Map<String, Object> insertReqLog(StringBuilder logStr, Map<String, Object> inData) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		int cnt = sqlSession.insert("mapper.com.CommonMapper.insertReqLog", inData);
		if(cnt != 1) {
			throw new RuntimeException("요청 로그 저장 중 오류 발생");
		}
		
		result.put(Constant.RESULT, Constant.RESULT_SUCCESS);
		return result;
	}		
	
}
