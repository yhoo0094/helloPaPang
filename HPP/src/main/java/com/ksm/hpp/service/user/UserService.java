package com.ksm.hpp.service.user;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksm.hpp.service.com.BaseService;

@Service("UserService")
public class UserService {
	
	@Autowired
	SqlSession sqlSession; //SqlSession 빈 DI	
	
	public Map<String, Object> insertUser(StringBuilder logStr, Map<String, Object> inData) throws Exception
	{
		Map<String, Object> result = new HashMap<String, Object>();
		
		sqlSession.insert("mapper.user.UserMapper.insertUser", inData);
		
		return result;
	}	
}
