package com.ksm.hpp.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.UncategorizedSQLException;

public class MybatisService implements MybatisDao
{
	private static final Log	log	= LogFactory.getLog(MybatisService.class);

	@Autowired
	protected SqlSession			sqlSession;
	
	/**
	 * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
	 * @param paramObject mapper에 등록되어 있는 목록중 사용할 sql id
	 * @return List
	 * @throws Exception if a database error occurs. 
	 */
	@Override
	public List<Map<String, Object>> queryForList(String paramString, Object paramObject) throws Exception
	{
		try
		{
			return this.sqlSession.selectList(paramString, paramObject);
		}
		catch (DataAccessException e)
		{
			throw new RuntimeException(getErrorMsg(e));
		}
	}
	/**
	 * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
	 * @return List
	 * @throws Exception if a database error occurs. 
	 */
	@Override
	public List<Map<String, Object>> queryForList(String paramString) throws Exception
	{
		try
		{
			return this.sqlSession.selectList(paramString);
		}
		catch (DataAccessException e)
		{
			throw new RuntimeException(getErrorMsg(e));
		}
	}
	
	/**
	 * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
	 * @param paramObject mapper에 등록되어 있는 목록중 사용할 sql id
	 * @return Object
	 * @throws Exception if a database error occurs. 
	 */
	@Override
	public Object queryForBean(String paramString, Object paramObject) throws Exception
	{
		try
		{
			return this.sqlSession.selectOne(paramString, paramObject);
		}
		catch (DataAccessException e)
		{
			throw new RuntimeException(getErrorMsg(e));
		}
	}
	
	/**
	 * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
	 * @param paramObject mapper에 등록되어 있는 목록중 사용할 sql id
	 * @return Map
	 * @throws Exception if a database error occurs. 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> queryForMap(String paramString, Object paramObject) throws Exception
	{
		Map<String, Object> ret = new LinkedHashMap<String, Object>();

		try
		{
			ret = (Map<String, Object>) this.sqlSession.selectOne(paramString, paramObject);
		}
		catch (DataAccessException e)
		{
			throw new RuntimeException(getErrorMsg(e));
		}

		if (ret == null)
		{
			return new LinkedHashMap<String, Object>();
		}
		return ret;
	}
	
	/**
	 * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
	 * @return Map
	 * @throws Exception if a database error occurs. 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> queryForMap(String paramString) throws Exception
	{
		Map<String, Object> ret = new LinkedHashMap<String, Object>();

		try
		{
			ret = (Map<String, Object>) this.sqlSession.selectOne(paramString);
		}
		catch (DataAccessException e)
		{
			throw new RuntimeException(getErrorMsg(e));
		}

		if (ret == null)
		{
			return new LinkedHashMap<String, Object>();
		}
		return ret;
	}
	
	/**
	 * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
	 * @param paramObject mapper에 등록되어 있는 목록중 사용할 sql id
	 * @return integer
	 * @throws Exception if a database error occurs. 
	 */
	@Override
	public int getOneFieldInteger(String paramString, Object paramObject) throws Exception
	{
		try
		{
			return ((Integer) this.sqlSession.selectOne(paramString, paramObject)).intValue();
		}
		catch (DataAccessException e)
		{
			throw new RuntimeException(getErrorMsg(e));
		}
	}
	
	/**
	 * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
	 * @return integer
	 * @throws Exception if a database error occurs. 
	 */
	@Override
	public int getOneFieldInteger(String paramString) throws Exception
	{
		try
		{
			return ((Integer) this.sqlSession.selectOne(paramString)).intValue();
		}
		catch (DataAccessException e)
		{
			throw new RuntimeException(getErrorMsg(e));
		}
	}
	
	/**
	 * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
	 * @param paramObject mapper에 등록되어 있는 목록중 사용할 sql id
	 * @return String
	 * @throws Exception if a database error occurs. 
	 */
	@Override
	public String getOneFieldString(String paramString, Object paramObject) throws Exception
	{
		try
		{
			return (String) this.sqlSession.selectOne(paramString, paramObject);
		}
		catch (DataAccessException e)
		{
			throw new RuntimeException(getErrorMsg(e));
		}
	}
	
	/**
	 * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
	 * @return String
	 * @throws Exception if a database error occurs. 
	 */
	@Override
	public String getOneFieldString(String paramString) throws Exception
	{
		try
		{
			return (String) this.sqlSession.selectOne(paramString);
		}
		catch (DataAccessException e)
		{
			throw new RuntimeException(getErrorMsg(e));
		}
	}
	
	/**
	 * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
	 * @param paramObject mapper에 등록되어 있는 목록중 사용할 sql id
	 * @param keyNm mapper에 등록되어 있는 목록중 사용할 sql id
	 * @param valNm mapper에 등록되어 있는 목록중 사용할 sql id
	 * @return Map
	 * @throws Exception if a database error occurs. 
	 */
	@Override
	public Map<String, Object> queryForListMap(String paramString, Object paramObject, String keyNm, String valNm) throws Exception
	{
		Map<String, Object> ret = new LinkedHashMap<String, Object>();
		List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();

		try
		{
			retList = this.sqlSession.selectList(paramString, paramObject);
		}
		catch (DataAccessException e)
		{
			throw new RuntimeException(getErrorMsg(e));
		}
		int cnt = retList.size();
		for (int i = 0; i < cnt; i++)
		{
			Map<String, Object> map = retList.get(i);

			ret.put((String) map.get(keyNm), map.get(valNm));
		}

		return ret;
	}
	
	/**
	 * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
	 * @param keyNm mapper에 등록되어 있는 목록중 사용할 sql id
	 * @param valNm mapper에 등록되어 있는 목록중 사용할 sql id
	 * @return Map
	 * @throws Exception if a database error occurs. 
	 */
	@Override
	public Map<String, Object> queryForListMap(String paramString, String keyNm, String valNm) throws Exception
	{
		Map<String, Object> ret = new LinkedHashMap<String, Object>();
		List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();

		try
		{
			retList = this.sqlSession.selectList(paramString);
		}
		catch (DataAccessException e)
		{
			throw new RuntimeException(getErrorMsg(e));
		}
		int cnt = retList.size();
		for (int i = 0; i < cnt; i++)
		{
			Map<String, Object> map = retList.get(i);

			ret.put((String) map.get(keyNm), map.get(valNm));
		}

		return ret;
	}

	/**
	 * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
	 * @param paramObject mapper에 등록되어 있는 목록중 사용할 sql id
	 * @return integer
	 * @throws Exception if a database error occurs. 
	 */
	@Override
	public int queryForInsert(String paramString, Object paramObject) throws Exception
	{
		try
		{
			return this.sqlSession.insert(paramString, paramObject);
		}
		catch (DataAccessException e)
		{
			throw new RuntimeException(getErrorMsg(e));
		}
	}

	/**
	 * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
	 * @return integer
	 * @throws Exception if a database error occurs. 
	 */
	@Override
	public int queryForInsert(String paramString) throws Exception
	{
		try
		{
			return this.sqlSession.insert(paramString);
		}
		catch (DataAccessException e)
		{
			throw new RuntimeException(getErrorMsg(e));
		}
	}
	
	/**
	 * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
	 * @param paramObject mapper에 등록되어 있는 목록중 사용할 sql id
	 * @return integer
	 * @throws Exception if a database error occurs. 
	 */
	@Override
	public int queryForUpdate(String paramString, Object paramObject) throws Exception
	{
		try
		{
			return this.sqlSession.update(paramString, paramObject);
		}
		catch (DataAccessException e)
		{
			throw new RuntimeException(getErrorMsg(e));
		}
	}

	/**
	 * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
	 * @return integer
	 * @throws Exception if a database error occurs. 
	 */
	@Override
	public int queryForUpdate(String paramString) throws Exception
	{
		try
		{
			return this.sqlSession.update(paramString);
		}
		catch (DataAccessException e)
		{
			throw new RuntimeException(getErrorMsg(e));
		}
	}

	/**
	 * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
	 * @param paramObject mapper에 등록되어 있는 목록중 사용할 sql id
	 * @return integer
	 * @throws Exception if a database error occurs. 
	 */
	@Override
	public int queryForDelete(String paramString, Object paramObject) throws Exception
	{
		try
		{
			return this.sqlSession.delete(paramString, paramObject);
		}
		catch (DataAccessException e)
		{
			throw new RuntimeException(getErrorMsg(e));
		}
	}

	/**
	 * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
	 * @return integer
	 * @throws Exception if a database error occurs. 
	 */
	@Override
	public int queryForDelete(String paramString) throws Exception
	{
		try
		{
			return this.sqlSession.delete(paramString);
		}
		catch (DataAccessException e)
		{
			throw new RuntimeException(getErrorMsg(e));
		}
	}
	
	/**
	 * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
	 * @param paramList mapper에 등록되어 있는 목록중 사용할 sql id
	 * @return integer
	 * @throws Exception if a database error occurs. 
	 */
	@Override
	public int queryForMultiInsert(String paramString, List<Map<String, Object>> paramList) throws Exception
	{
		int i = 0;
		int cnt = paramList.size();
		for (i = 0; i < cnt; i++)
		{
			try
			{
				this.sqlSession.insert(paramString, paramList.get(i));
			}
			catch (DataAccessException e)
			{
				throw new RuntimeException(getErrorMsg(e));
			}
		}
		return i;
	}

	/**
	 * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
	 * @param paramList mapper에 등록되어 있는 목록중 사용할 sql id
	 * @return integer
	 * @throws Exception if a database error occurs. 
	 */
	@Override
	public int queryForMultiUpdate(String paramString, List<Map<String, Object>> paramList) throws Exception
	{
		int i = 0;
		int rtn = 0;
		int cnt = paramList.size();
		for (i = 0; i < cnt; i++)
		{
			try
			{
				rtn += this.sqlSession.update(paramString, paramList.get(i));
			}
			catch (DataAccessException e)
			{
				throw new RuntimeException(getErrorMsg(e));
			}
		}

		return rtn;
	}

	/**
	 * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
	 * @param paramObject mapper에 등록되어 있는 목록중 사용할 sql id
	 * @throws Exception if a database error occurs. 
	 */
	@Override
	public void procedure(String paramString, Object paramObject) throws Exception
	{
		try
		{
			try
			{
				this.sqlSession.update(paramString, paramObject);
			}
			catch (DataAccessException e)
			{
				throw new RuntimeException(getErrorMsg(e));
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			log.error(e.getCause());
			throw e;
		}
		catch (UncategorizedSQLException ue)
		{
			log.error(ue.getCause());
			throw ue;
		}
	}

	/**
	 * @param e
	 * @return String
	 * @throws Exception if a database error occurs. 
	 */
	public String getErrorMsg(DataAccessException e)
	{
		String errMsg;

		log.error("=======================================================");
		log.error(" 실행에러::" + e.getMessage());
		log.error("=======================================================");

		errMsg = e.getMessage();

		return errMsg;
	}
}