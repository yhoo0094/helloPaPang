package com.ksm.hpp.service.com;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksm.hpp.dao.MybatisDao;

@Service
public class BaseService
{
	protected static final Log log = LogFactory.getLog(BaseService.class);

	@Autowired(required=false)
	protected MybatisDao mtDao = null;
}