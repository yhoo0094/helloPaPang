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
	 * @메소드명: selectNotice
	 * @작성자: 김상민
	 * @생성일: 2022. 12. 21. 오전 10:47:34
	 * @설명: 공지사항 조회
	 */
	@RequestMapping("/selectNotice.do")
	public void selectNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		
		Map<String, Object> outData = noticeService.selectNotice((StringBuilder)request.getAttribute("IN_LOG_STR"), inData);
		
		Gson gson = new Gson();
		String json = gson.toJson(outData);
		response.getWriter().print(json);	//결과 json형태로 담아서 보내기
		response.setContentType("application/x-json; charset=UTF-8");
	}	
	
	/**
	 * @메소드명: insertNotice
	 * @작성자: 김상민
	 * @생성일: 2022. 11. 22. 오전 8:43:39
	 * @설명: 공지사항 등록
	 */
	@RequestMapping("/insertNotice.do")
	public void insertNotice(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		
		List<MultipartFile> fileList = request.getFiles("files"); 
		Map<String, Object> outData = noticeService.insertNotice((StringBuilder)request.getAttribute("IN_LOG_STR"), inData, fileList);
		
		Gson gson = new Gson();
		String json = gson.toJson(outData);
		response.getWriter().print(json);	//결과 json형태로 담아서 보내기
		response.setContentType("application/x-json; charset=UTF-8");
	}		
	
	/**
	 * @메소드명: updateNotice
	 * @작성자: 김상민
	 * @생성일: 2023. 1. 3. 오전 10:43:28
	 * @설명: 공지사항 수정
	 */
	@RequestMapping("/updateNotice.do")
	public void updateNotice(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		
		List<MultipartFile> fileList = request.getFiles("files"); 
		Map<String, Object> outData = noticeService.updateNotice((StringBuilder)request.getAttribute("IN_LOG_STR"), inData, fileList);
		
		Gson gson = new Gson();
		String json = gson.toJson(outData);
		response.getWriter().print(json);	//결과 json형태로 담아서 보내기
		response.setContentType("application/x-json; charset=UTF-8");
	}		
}


	