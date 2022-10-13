package com.ksm.hpp.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ksm.hpp.vo.Article;

@Repository
public class ArticleDAO {

	@Autowired SqlSession sqlSession;
	
	public Article selectArticleById(String articleId) {
		return sqlSession.selectOne("mappers.article-mapper.selectArticleById", articleId);
	}	
}
