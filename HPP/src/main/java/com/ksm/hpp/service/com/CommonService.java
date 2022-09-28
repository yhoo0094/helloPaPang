package com.ksm.hpp.service.com;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CommonService")
public class CommonService {
	
	@Autowired
	SqlSession sqlSession; //SqlSession 빈 DI	
	
	public String test(String test) {
		List<Object> list = sqlSession.selectList("mappers.article-mapper.selectArticleById");
		
		System.out.println(test);
		
		System.out.println(list);
		
		return test;
	}
}
