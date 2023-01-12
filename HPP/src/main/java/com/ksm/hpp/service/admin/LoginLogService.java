package com.ksm.hpp.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ksm.hpp.framework.util.Constant;
import com.ksm.hpp.service.com.FileService;

@Service("LoginLogService")
public class LoginLogService {
	
	@Autowired
	SqlSession sqlSession; //SqlSession 빈 DI	
	
	/**
	 * @메소드명: selectLoginLog
	 * @작성자: 김상민
	 * @생성일: 2023. 1. 12. 오후 3:41:47
	 * @설명: 사용자 접속 기록 조회
	 */
	public Map<String, Object> selectLoginLog(StringBuilder logStr, Map<String, Object> inData) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<Object> list = sqlSession.selectList("mapper.admin.LoginLogMapper.selectLoginLog", inData);
		result.put("list", list);
		
		result.put(Constant.RESULT, Constant.RESULT_SUCCESS);
		return result;
	}
}
