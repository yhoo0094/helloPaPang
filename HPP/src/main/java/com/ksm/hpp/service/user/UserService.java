package com.ksm.hpp.service.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ksm.hpp.service.com.BaseService;

@Service("UserService")
public class UserService extends BaseService {
	
	public Map<String, Object> insertUser(StringBuilder logStr, Map<String, Object> inData) throws Exception
	{
		Map<String, Object> result = new HashMap<String, Object>();
		
		this.mtDao.queryForInsert("mapper.user.UserMapper.insertUser", inData);
		
		return result;
	}	
}
