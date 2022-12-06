package com.ksm.hpp.service.info;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ksm.hpp.framework.util.Constant;
import com.ksm.hpp.framework.util.StringUtil;
import com.ksm.hpp.service.com.BaseService;

@Service("NoticeService")
public class NoticeService {
	
	@Autowired
	SqlSession sqlSession; //SqlSession 빈 DI	
	
	/**
	 * @메소드명: selectUser
	 * @작성자: 김상민
	 * @생성일: 2022. 11. 2. 오후 6:59:16
	 * @설명: 사용자 조회
	 */	
	public Map<String, Object> saveNotice(StringBuilder logStr, Map<String, Object> inData, List<MultipartFile> fileList) throws Exception
	{
		LocalDate date = LocalDate.now();
		DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("yyyyMMdd");
		
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		/*
		List<Object> list = sqlSession.selectList("mapper.user.UserMapper.selectUser", inData);
		result.put("list", list);
		*/
		
		return result;
	}
}
