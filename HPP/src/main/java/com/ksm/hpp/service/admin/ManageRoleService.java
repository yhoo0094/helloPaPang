package com.ksm.hpp.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ksm.hpp.framework.util.Constant;
import com.ksm.hpp.service.com.FileService;

@Service("ManageRoleService")
public class ManageRoleService {
	
	@Autowired
	SqlSession sqlSession; //SqlSession 빈 DI	
	
	/**
	* @메소드명: selectRoleList
	* @작성자: KimSangMin
	* @생성일: 2023. 5. 8. 오후 6:36:23
	* @설명: 권한그룹 목록 조회
	*/
	public Map<String, Object> selectRoleList(StringBuilder logStr, Map<String, Object> inData) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<Map<String, Object>> list = sqlSession.selectList("mapper.admin.ManageRoleMapper.selectRoleList", inData);
		result.put("data", list);
		result.put(Constant.OUT_DATA, list);
		result.put(Constant.RESULT, Constant.RESULT_SUCCESS);
		return result;
	}
}
