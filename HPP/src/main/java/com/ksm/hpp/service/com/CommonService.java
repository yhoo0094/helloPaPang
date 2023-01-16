package com.ksm.hpp.service.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CommonService")
public class CommonService extends BaseService {
	
	@Autowired
	SqlSession sqlSession; //SqlSession 빈 DI	
	
	/**
	 * @메소드명: test
	 * @작성자: 김상민
	 * @생성일: 2022. 12. 14. 오후 2:19:06
	 * @설명: 테스트용, 추후 삭제
	 */
	public List<Map<String, Object>> test() throws Exception
	{
		System.out.println("Service Start");
		
		//Map<String, Object> result = new HashMap<String, Object>();
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		
		result = sqlSession.selectList("mappers.article-mapper.selectList");
		
		//result.put(Constant.OUT_DATA, this.mtDao.queryForList("mappers.article-mapper.selectList"));

		System.out.println(result);
		
		return result;
	}	
}
