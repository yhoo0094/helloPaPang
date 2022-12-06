package com.ksm.hpp.controller.info;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;
import com.ksm.hpp.framework.util.RequestUtil;
import com.ksm.hpp.service.info.NoticeService;
import com.ksm.hpp.service.user.UserService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	private static final Logger logger = LogManager.getLogger("Application");
	
	@Resource(name = "NoticeService")
	protected NoticeService noticeService;
	
	/**
	 * @메소드명: saveNotice
	 * @작성자: 김상민
	 * @생성일: 2022. 11. 22. 오전 8:43:39
	 * @설명: 공지사항 저장
	 */
	@RequestMapping("/saveNotice.do")
	public void saveNotice(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		
		
		List<MultipartFile> fileList = request.getFiles("files"); 
		Map<String, Object> outData = noticeService.saveNotice((StringBuilder)request.getAttribute("IN_LOG_STR"), inData, fileList);
		
		
		Gson gson = new Gson();
		String json = gson.toJson(outData);
		response.getWriter().print(json);	//결과 json형태로 담아서 보내기
		response.setContentType("application/x-json; charset=UTF-8");
	}		
	
}


	