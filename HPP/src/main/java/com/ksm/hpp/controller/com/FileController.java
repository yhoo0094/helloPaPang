package com.ksm.hpp.controller.com;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.ksm.hpp.framework.util.RequestUtil;
import com.ksm.hpp.service.com.FileService;

@Controller
@RequestMapping("/file")
public class FileController {
	
	@Resource(name = "FileService")
	protected FileService fileService;
	
	/**
	 * @메소드명: selectFile
	 * @작성자: 김상민
	 * @생성일: 2022. 12. 27. 오후 5:27:09
	 * @설명: 파일목록 조회
	 */
	@RequestMapping("/selectFile")
	public void selectFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		Map<String, Object> outData = fileService.selectFile((StringBuilder)request.getAttribute("IN_LOG_STR"), inData);
		
		Gson gson = new Gson();
		String json = gson.toJson(outData);
		response.getWriter().print(json);	//결과 json형태로 담아서 보내기
		response.setContentType("application/x-json; charset=UTF-8");
	}
	
	/**
	 * @메소드명: downloadFile
	 * @작성자: 김상민
	 * @생성일: 2022. 12. 27. 오후 5:27:02
	 * @설명: 파일 다운로드
	 */
	@RequestMapping("/downloadFile")
	public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		Map<String, Object> outData = fileService.downloadFile((StringBuilder)request.getAttribute("IN_LOG_STR"), inData);
		
		Gson gson = new Gson();
		String json = gson.toJson(outData);
		response.getWriter().print(json);	//결과 json형태로 담아서 보내기
		response.setContentType("application/x-json; charset=UTF-8");
	}	
}
