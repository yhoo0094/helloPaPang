package com.ksm.hpp.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksm.hpp.framework.util.Constant;

@Service("RequestLogService")
public class RequestLogService {
	
	@Autowired
	SqlSession sqlSession; //SqlSession 빈 DI	
	
	/**
	* @메소드명: selectRequestLog
	* @작성자: KimSangMin
	* @생성일: 2023. 1. 30. 오후 2:58:09
	* @설명: 서버에 발생한 요청 기록 조회
	*/
	public Map<String, Object> selectRequestLog(StringBuilder logStr, Map<String, Object> inData) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<Object> list = sqlSession.selectList("mapper.admin.RequestLogMapper.selectRequestLog", inData);
		result.put("data", list);
		result.put(Constant.OUT_DATA, list);
		
		int cnt = sqlSession.selectOne("mapper.admin.RequestLogMapper.selectRequestLogCnt", inData);
//		result.put("recordsTotal", cnt);	//총 레코드 수
		result.put("recordsFiltered", cnt);	//필터링 후의 총 레코드 수
		
		result.put(Constant.RESULT, Constant.RESULT_SUCCESS);
		return result;
	}
}
