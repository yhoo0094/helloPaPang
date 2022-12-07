package com.ksm.hpp.service.info;

import java.io.File;
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
		Map<String, Object> result = new HashMap<String, Object>();
		
		LocalDate date = LocalDate.now();
		DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("yyyyMMdd");
		String nowDate = date.format(dtfDate);
		
		LocalDate time = LocalDate.now();
		DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("HHmmss");
		String nowTime = time.format(dtfTime);
		
		do {
			if(fileList == null) {
				result.put(Constant.RESULT, Constant.RESULT_FAILURE);
				result.put(Constant.OUT_RESULT_MSG, "첨부파일이 존재하지 않습니다.");	
				break;
			}
		} while(false);
		
		String filePath = "";	//첨부파일 저장 경로
		
		File dir = new File(filePath);
		if(!dir.isDirectory()) {	//해당 경로가 디렉토리인지 확인
			if(!dir.exists()) {		//해당 경로 디렉토리가 있는지 확인
				dir.mkdir();
			}
		}
		
		
		
		/*
		List<Object> list = sqlSession.selectList("mapper.user.UserMapper.selectUser", inData);
		result.put("list", list);
		*/
		
		return result;
	}
}
