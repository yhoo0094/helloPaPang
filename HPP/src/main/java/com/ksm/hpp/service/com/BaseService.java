package com.ksm.hpp.service.com;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.ksm.hpp.framework.dao.BaseMapper;

@Service
public class BaseService
{
	protected static final Log log = LogFactory.getLog(BaseService.class);

	@Resource(name="baseMapper")
	protected BaseMapper mtDao;
}