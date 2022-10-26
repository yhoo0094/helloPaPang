package com.ksm.hpp.service.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksm.hpp.framework.dao.ArticleDAO;

@Service("CommonService")
public class CommonService extends BaseService {
	
	@Autowired
	SqlSession sqlSession; //SqlSession 빈 DI	
	
	@Autowired
	private ArticleDAO articleDAO;	
	
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
	
	public Map<String, Object> viewArticleDetail(String articleId) {
		return this.articleDAO.selectArticleById(articleId);
	}	
}
