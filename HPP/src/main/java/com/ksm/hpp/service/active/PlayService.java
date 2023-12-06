package com.ksm.hpp.service.active;

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

@Service("PlayService")
public class PlayService {
	
	@Autowired
	SqlSession sqlSession; //SqlSession 빈 DI	
	
	@Resource(name = "FileService")
	protected FileService fileService;

	/**
	* @메소드명: selectPlay
	* @작성자: KimSangMin
	* @생성일: 2023. 12. 6. 오후 6:38:17
	* @설명: 놀이 조회
	*/
	public Map<String, Object> selectPlay(StringBuilder logStr, Map<String, Object> inData) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<Map<String, Object>> list = sqlSession.selectList("mapper.active.PlayMapper.selectPlay", inData);
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
	
	/**
	* @메소드명: insertPlay
	* @작성자: KimSangMin
	* @생성일: 2023. 12. 5. 오후 8:48:43
	* @설명: 놀이 등록
	 */	
	public Map<String, Object> insertPlay(StringBuilder logStr, Map<String, Object> inData, List<MultipartFile> fileList) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		inData = StringUtil.XssReplaceInData(inData);	//XSS스크립트 방지를 위해 텍스트 변환
		
		sqlSession.insert("mapper.active.PlayMapper.insertPlay", inData);
		fileService.insertFile(logStr, inData, fileList);
		
		result.put(Constant.RESULT, Constant.RESULT_SUCCESS);
		result.put(Constant.OUT_DATA, inData);
		return result;
	}
}
