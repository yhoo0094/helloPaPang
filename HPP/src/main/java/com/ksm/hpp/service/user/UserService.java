package com.ksm.hpp.service.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksm.hpp.framework.util.Constant;
import com.ksm.hpp.framework.util.StringUtil;
import com.ksm.hpp.service.com.BaseService;

@Service("UserService")
public class UserService {
	
	@Autowired
	SqlSession sqlSession; //SqlSession 빈 DI	
	
	/**
	 * @메소드명: selectUser
	 * @작성자: 김상민
	 * @생성일: 2022. 11. 2. 오후 6:59:16
	 * @설명: 사용자 조회
	 */	
	public Map<String, Object> selectUser(StringBuilder logStr, Map<String, Object> inData) throws Exception
	{
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<Object> list = sqlSession.selectList("mapper.user.UserMapper.selectUser", inData);
		result.put("list", list);
		
		return result;
	}
	
	/**
	 * @메소드명: insertUser
	 * @작성자: 김상민
	 * @생성일: 2022. 11. 2. 오후 6:59:00
	 * @설명: 사용자 생성
	 */	
	public Map<String, Object> insertUser(StringBuilder logStr, Map<String, Object> inData) throws Exception
	{
		Map<String, Object> result = new HashMap<String, Object>();
		int cnt = 0;
		
		String userPw = StringUtil.getSHA256((String)inData.get("userPw"));
		inData.put("userPw", userPw);
		
		do {
			cnt = sqlSession.insert("mapper.user.UserMapper.insertUser", inData);
			if(cnt == 0) {
				result.put(Constant.RESULT, Constant.RESULT_FAILURE);
				result.put(Constant.OUT_RESULT_MSG, "사용자 생성에 실패했습니다.");
			}
			
			result.put(Constant.RESULT, Constant.RESULT_SUCCESS);
			result.put(Constant.OUT_DATA, cnt);
		} while(false);
		return result;
	}	
	
	/**
	 * @메소드명: login
	 * @작성자: 김상민
	 * @생성일: 2022. 11. 8. 오전 8:59:13
	 * @설명: 로그인
	 */
	public Map<String, Object> login(StringBuilder logStr, Map<String, Object> inData) throws Exception
	{
		Map<String, Object> result = new HashMap<String, Object>();
		
		Map<String, Object> data = sqlSession.selectOne("mapper.user.UserMapper.selectUser", inData);
		result.put("data", data);
		
		return result;
	}	
	
	/**
	 * 
	 * @메소드명: chkUniqId
	 * @작성자: 김상민
	 * @생성일: 2023. 1. 5. 오전 9:37:43
	 * @설명: 아이디 중복 체크
	 */
	public Map<String, Object> chkUniqId(StringBuilder logStr, Map<String, Object> inData) throws Exception
	{
		Map<String, Object> result = new HashMap<String, Object>();
		
		Map<String, Object> data = sqlSession.selectOne("mapper.user.UserMapper.selectUser", inData);
		result.put("data", data);
		
		result.put(Constant.RESULT, Constant.RESULT_SUCCESS);
		return result;
	}		
	
}
