package com.ksm.hpp.controller.com;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ksm.hpp.service.com.BaseService;
import com.ksm.hpp.service.com.CommonService;

@Controller
public class BaseController {
	protected static final Log log = LogFactory.getLog(BaseController.class);
}
