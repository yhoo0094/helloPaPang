package com.ksm.hpp.framework.dao;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("baseMapper")
public class BaseMapper {

	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="mapperExcutor")
	protected MapperExcutor sqlExcutor;
	
	public int queryForInsert(String paramString, Object paramObject) {
		return insert(paramString, paramObject);
		
	}	
	
	public int insert(String queryId, Object paramObject) {
		return (Integer) sqlExcutor.execQuery("insert", queryId, paramObject, true);
	}
}
