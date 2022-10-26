package com.ksm.hpp.framework.dao;

import java.lang.reflect.Method;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("mapperExcutor")
public class MapperExcutor extends SqlSessionDaoSupport {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@SuppressWarnings("rawtypes")
	public Object execQuery(String function, String queryId, boolean setLog) {
		Class[] paramClass = new Class[] {String.class};
		Object[] paramValue = new Object[]{queryId};
		
		Object object = execQuery(function, queryId, paramClass, paramValue, null, setLog);
		
		return object;
	}
	
	@SuppressWarnings("rawtypes")
	public Object execQuery(String function, String queryId, Object parameterObject, boolean setLog) {
		Class[] paramClass = new Class[] {String.class};
		Object[] paramValue = new Object[]{queryId};
		
		Object object = execQuery(function, queryId, paramClass, paramValue, parameterObject, setLog);
		
		return object;
	}	
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	public <T> T execQuery(String function, String queryId, Class[] paramClass, Object[] paramValue, Object parameterObject, boolean setLog) {
		
		log.info("[BEGIN] " + function + "(" + queryId + ") : " + setLog);
		
		T result = null;
		
		Class<T> sqlClass = (Class<T>) super.getSqlSession().getClass();
		
		boolean setSqlLog = setLog;
		long beforeTime = System.currentTimeMillis();
		
		Method method;
		try {
			method = sqlClass.getMethod(function, paramClass);
			result = (T)method.invoke(super.getSqlSession(), paramValue);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			long afterTime = System.currentTimeMillis();
			long runTime = afterTime - beforeTime;
			
			if(setSqlLog) {
				//sqlLog(queryId, parameterObject, result);
			}
			
			log.info("[END] " + function + "(" + queryId + ") [" + runTime + "(ms)]");
		}
		return result;
	}
};

	