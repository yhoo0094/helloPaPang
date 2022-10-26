package com.ksm.hpp.framework.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ksm.hpp.vo.Article;

@Repository
public class ArticleDAO {

	@Autowired SqlSession sqlSession;
	
	public Map<String, Object> selectArticleById(String articleId) {
		return sqlSession.selectOne("mappers.article-mapper.selectArticleById", articleId);
	}	
}
