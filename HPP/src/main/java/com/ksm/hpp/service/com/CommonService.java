package com.ksm.hpp.service.com;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksm.hpp.dao.ArticleDAO;
import com.ksm.hpp.framework.util.Constant;
import com.ksm.hpp.vo.Article;

@Service("CommonService")
public class CommonService extends BaseService {
	
	@Autowired
	SqlSession sqlSession; //SqlSession 빈 DI	
	
	@Autowired
	private ArticleDAO articleDAO;	
	
	/*
	 * public String test(String test) { List<Object> list =
	 * sqlSession.queryForList("mappers.article-mapper.selectArticleById");
	 * 
	 * System.out.println(test);
	 * 
	 * System.out.println(list);
	 * 
	 * return test; }
	 */
	
	public Map<String, Object> test(Map<String, Object> inData) throws Exception
	{
		System.out.println("Service Start");
		
		Map<String, Object> result = new HashMap<String, Object>();

		result.put(Constant.OUT_DATA, this.mtDao.queryForList("mappers.article-mapper.selectList", inData));

		System.out.println(result);
		
		return result;
	}	
	
	public Article viewArticleDetail(String articleId) {
		return this.articleDAO.selectArticleById(articleId);
	}	
}
