package com.ksm.hpp.controller.board;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ksm.hpp.controller.com.BaseController;
import com.ksm.hpp.framework.util.RequestUtil;
import com.ksm.hpp.framework.util.ResponseUtil;
import com.ksm.hpp.service.board.FreeBoardService;
import com.ksm.hpp.service.com.CommonService;

@Controller
@RequestMapping("/freeBoard")
public class FreeBoardController extends BaseController {
	
	@Resource(name = "FreeBoardService")
	protected FreeBoardService freeBoardService;

	@Resource(name = "CommonService")
	protected CommonService commonService;
	
	/**
	* @메소드명: selectFreeBoard
	* @작성자: KimSangMin
	* @생성일: 2023. 11. 23. 오후 8:19:03
	* @설명: 자유게시판 조회
	*/
	@RequestMapping("/selectFreeBoard.do")
	public void selectFreeBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		Map<String, Object> outData = freeBoardService.selectFreeBoard((StringBuilder)request.getAttribute("IN_LOG_STR"), inData);
		
		ResponseUtil.setResAuto(response, inData, outData);
	}	
}


	