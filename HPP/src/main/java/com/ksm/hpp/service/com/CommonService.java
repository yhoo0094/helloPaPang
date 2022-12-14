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
	
	/**
	 * @메소드명: viewArticleDetail
	 * @작성자: 김상민
	 * @생성일: 2022. 12. 14. 오후 2:19:23
	 * @설명: 연습용, 추후 삭제
	 */
	public Map<String, Object> viewArticleDetail(String articleId) {
		return this.articleDAO.selectArticleById(articleId);
	}	
}
