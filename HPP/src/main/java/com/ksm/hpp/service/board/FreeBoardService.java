package com.ksm.hpp.service.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ksm.hpp.framework.util.Constant;
import com.ksm.hpp.framework.util.StringUtil;
import com.ksm.hpp.service.com.FileService;

@Service("FreeBoardService")
public class FreeBoardService {
	
	@Autowired
	SqlSession sqlSession; //SqlSession 빈 DI	
	
	@Resource(name = "FileService")
	protected FileService fileService;

	/**
	* @메소드명: selectFreeBoard
	* @작성자: KimSangMin
	* @생성일: 2023. 11. 23. 오후 8:19:03
	* @설명: 자유게시판 조회
	*/
	public Map<String, Object> selectFreeBoard(StringBuilder logStr, Map<String, Object> inData) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<Map<String, Object>> list = sqlSession.selectList("mapper.board.FreeBoardMapper.selectFreeBoard", inData);
		result.put("data", list);
		result.put(Constant.OUT_DATA, list);
		if(!list.isEmpty()) {
			result.put("recordsFiltered", list.get(0).get("rowCnt"));	//필터링 후의 총 레코드 수
		} else {
			result.put("recordsFiltered", "0");	//필터링 후의 총 레코드 수
		}		
		result.put(Constant.RESULT, Constant.RESULT_SUCCESS);
		return result;
	}
}
