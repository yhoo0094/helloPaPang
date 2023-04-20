package com.ksm.hpp.service.com;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksm.hpp.framework.exception.ConfigurationException;
import com.ksm.hpp.framework.util.Constant;

@Service("CommonService")
public class CommonService extends BaseService {
	
	@Autowired
	SqlSession sqlSession; //SqlSession 빈 DI	

	/**
	* @메소드명: insertReqLog
	* @작성자: KimSangMin
	* @생성일: 2023. 1. 18. 오후 3:24:55
	* @설명: 요청 로그 저장
	 */
	public Map<String, Object> insertReqLog(StringBuilder logStr, Map<String, Object> inData) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		int cnt = sqlSession.insert("mapper.com.CommonMapper.insertReqLog", inData);
		if(cnt != 1) {
			throw new ConfigurationException("요청 로그 저장 중 오류 발생");
		}
		
		result.put(Constant.RESULT, Constant.RESULT_SUCCESS);
		return result;
	}
	
	/**
	* @메소드명: readAuthChk
	* @작성자: KimSangMin
	* @생성일: 2023. 1. 19. 오후 1:50:35
	* @설명: 읽기 권한 체크
	 */
	@SuppressWarnings("unchecked")
	public Boolean readAuthChk(StringBuilder logStr, HttpServletRequest request, Map<String, Object> inData) throws Exception {
		Boolean result = false;
		String url = (String) inData.get("url");
		
		HttpSession session = request.getSession();
		List<Map<String, Object>> freeAuthList = (List<Map<String, Object>>) session.getAttribute(Constant.FREE_AUTH_LIST);
		List<Map<String, Object>> authList = (List<Map<String, Object>>) session.getAttribute(Constant.AUTH_LIST);
		
		//세션이 없을 경우 => 로그인 안 함 => 권한 체크 필요 여부에 따라 판단(필요:false, 불필요:true)
		if(authList.isEmpty()) {
			Boolean isFreeAuth =  sqlSession.selectOne("mapper.user.UserMapper.isFreeAuth", inData);
			if(isFreeAuth) {
				result = true;
			}
		}
		//세션이 있을 경우 => 세션을 통해 권한 체크 => 권한 없을 경우 세션 최신화 후 다시 체크
		//권한이 필요없는 목록에 해당 url이 있으면 통과
		if(!result) {
			for(Map<String, Object> auth : freeAuthList) {
				if(url.equals(auth.get("url"))) {
					result = true;
					break;
				}
			}			
		}		
		//권한 목록에서 해당 url의 권한이 있으면 통과(읽기 가능으로 판단)
		if(!result) {
			for(Map<String, Object> auth : authList) {
				if(url.equals(auth.get("url"))) {
					result = true;
					break;
				}
			}			
		}
		//권한이 필요없는 목록 DB에서 조회하여 다시 테스트
		if(!result) {
			freeAuthList = sqlSession.selectList("mapper.user.UserMapper.selectFreeAuthList", inData);
			for(Map<String, Object> auth : freeAuthList) {
				if(url.equals(auth.get("url"))) {
					session.setAttribute(Constant.FREE_AUTH_LIST, freeAuthList);		//권한이 필요없는 목록 정보 최신화
					result = true;
					break;
				}
			}				
		}		
		//권한 목록 DB에서 조회하여 다시 테스트
		if(!result) {
			authList = sqlSession.selectList("mapper.user.UserMapper.selectAuthList", inData);
			for(Map<String, Object> auth : authList) {
				if(auth.containsKey(url)) {
					session.setAttribute(Constant.AUTH_LIST, authList);		//권한 정보 최신화
					result = true;
					break;
				}
			}			
		}
		return result;
	}	
	
	/**
	* @메소드명: writeAuthChk
	* @작성자: KimSangMin
	* @생성일: 2023. 1. 31. 오후 5:40:11
	* @설명: 쓰기권한 조회
	*/
	@SuppressWarnings("unchecked")
	public void writeAuthChk(StringBuilder logStr, HttpServletRequest request, Map<String, Object> inData) throws Exception {
		Boolean result = false;
		String url = (String) inData.get("url");				//메뉴 경로
		Boolean isRange = (Boolean) inData.get("isRange");			//권한등급이 정확히 일치해야 하는지
		int reqAuthGrade = (Integer) inData.get("reqAuthGrade");	//필요 권한등급
		
		HttpSession session = request.getSession();
		List<Map<String, Object>> freeAuthList = (List<Map<String, Object>>) session.getAttribute(Constant.FREE_AUTH_LIST);
		List<Map<String, Object>> authList = (List<Map<String, Object>>) session.getAttribute(Constant.AUTH_LIST);
		
		//세션이 없을 경우 => 로그인 안 함 => 권한 체크 필요 여부에 따라 판단(필요:false, 불필요:true)
		if(authList.isEmpty()) {
			Boolean isFreeAuth =  sqlSession.selectOne("mapper.user.UserMapper.isFreeAuth", inData);
			if(isFreeAuth) {
				result = true;
			}
		}		
		//세션이 있을 경우 => 세션을 통해 권한 체크 => 권한 없을 경우 세션 최신화 후 다시 체크
		//권한이 필요없는 목록에 해당 url이 있으면 통과
		if(!result) {
			for(Map<String, Object> auth : freeAuthList) {
				if(url.equals(auth.get("url"))) {
					result = true;
					break;
				}
			}			
		}
		//권한 목록에서 해당 url의 권한등급이 필요 권한등급을 만족하면 통과
		if(!result) {
			for(Map<String, Object> auth : authList) {
				if(url.equals(auth.get("url"))) {
					int authGrade = (Integer) auth.get("authGrade");	//사용자의 권한등급
					if(isRange) {
						result = (authGrade >= reqAuthGrade)? true : false;
					} else {
						result = (authGrade == reqAuthGrade)? true : false;
					}
					break;
				}
			}			
		}		
		//권한 목록 DB에서 조회하여 다시 테스트
		if(!result) {
			authList = sqlSession.selectList("mapper.user.UserMapper.selectAuthList", inData);
			for(Map<String, Object> auth : authList) {
				if(url.equals(auth.get("url"))) {
					int authGrade = (Integer) auth.get("authGrade");	//사용자의 권한등급
					if(isRange) {
						result = (authGrade >= reqAuthGrade)? true : false;
					} else {
						result = (authGrade == reqAuthGrade)? true : false;
					}
					break;
				}
			}			
		}
		//권한이 없을 경우 예외 처리
		if(!result) {
			throw new ConfigurationException("해당 동작에 대한 권한이 없습니다.");
		}
	}
	
	/**
	* @메소드명: selectMnuInfo
	* @작성자: KimSangMin
	* @생성일: 2023. 1. 19. 오후 5:55:22
	* @설명: 메뉴 정보 조회
	 */
	public Map<String, Object> selectMnuInfo(StringBuilder logStr, Map<String, Object> inData) throws Exception {
		Map<String, Object> mnuInfo = sqlSession.selectOne("mapper.com.CommonMapper.selectMnuInfo", inData);
		return mnuInfo;
	}
}
