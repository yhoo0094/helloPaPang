package com.ksm.hpp.service.user;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksm.hpp.framework.util.Constant;
import com.ksm.hpp.framework.util.DateUtil;
import com.ksm.hpp.framework.util.PapangUtil;
import com.ksm.hpp.framework.util.RequestUtil;
import com.ksm.hpp.framework.util.StringUtil;
import com.ksm.hpp.service.com.BaseService;

@Service("UserService")
public class UserService extends BaseService {
	
	@Autowired
	SqlSession sqlSession; //SqlSession 빈 DI	
	
	/**
	 * @메소드명: selectUser
	 * @작성자: 김상민
	 * @생성일: 2022. 11. 2. 오후 6:59:16
	 * @설명: 사용자 조회
	 */	
	public Map<String, Object> selectUser(StringBuilder logStr, Map<String, Object> inData) throws Exception
	{
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<Map<String, Object>> list = sqlSession.selectList("mapper.user.UserMapper.selectUser", inData);
		result.put("list", list);

		return result;
	}
	
	/**
	 * @메소드명: insertUser
	 * @작성자: 김상민
	 * @생성일: 2022. 11. 2. 오후 6:59:00
	 * @설명: 사용자 생성
	 */	
	public Map<String, Object> insertUser(StringBuilder logStr, Map<String, Object> inData) throws Exception
	{
		Map<String, Object> result = new HashMap<String, Object>();
		int cnt = 0;
		
		//비밀번호 해쉬 처리
		String userPw = StringUtil.getSHA256("HPP" + (String)inData.get("userPw") + "MELONA");
		inData.put("userPw", userPw);
		
		do {
			cnt = sqlSession.insert("mapper.user.UserMapper.insertUser", inData);
			if(cnt == 0) {
				result.put(Constant.RESULT, Constant.RESULT_FAILURE);
				result.put(Constant.OUT_RESULT_MSG, "사용자 생성에 실패했습니다.");
			}
			
			result.put(Constant.RESULT, Constant.RESULT_SUCCESS);
			result.put(Constant.OUT_DATA, cnt);
		} while(false);
		return result;
	}	
	
	/**
	 * @메소드명: login
	 * @작성자: 김상민
	 * @생성일: 2022. 11. 8. 오전 8:59:13
	 * @설명: 로그인
	 */
	public Map<String, Object> login(StringBuilder logStr, HttpServletRequest request, Map<String, Object> inData) throws Exception
	{
		Map<String, Object> result = new HashMap<String, Object>();
		
		//사용자 정보 조회
		Map<String, Object> loginInfo = sqlSession.selectOne("mapper.user.UserMapper.selectUser", inData);
		
		do {
			if(loginInfo == null) {	//해당 계정이 조회되지 않을 때
				result.put(Constant.OUT_RESULT_MSG, "존재하지 않는 아이디이거나 비밀번호가 일치하지 않습니다.");	
				result.put(Constant.RESULT, Constant.RESULT_FAILURE);
				break;
				
				//Exception 처리를 통한 메서드 중지(추후 구현)
				//throw new RuntimeException("존재하지 않는 아이디이거나 비밀번호가 일치하지 않습니다.");
			} else {
				//사용자 정책 조회
				inData.put("POLI_TYPE", "UESR");
				List<Map<String, Object>> userPoli = sqlSession.selectList("mapper.com.CommonMapper.selectPoli", inData);
				result.put("userPoli", userPoli);
				
				//해당 계정의 패스워드 오입력 횟수가 초과된 경우
				int pwErrCnt = Integer.parseInt((String) loginInfo.get("PW_ERR_CNT"));	//사용자 패스워드 오입력 횟수
				int pwErrCntLim = Integer.parseInt((String) PapangUtil.getMapFromList(userPoli, "POLI_NM", "PW_ERR_CNT_LIM").get("POLI_VAL"));	//패스워드 오입력 허용 횟수
				if(pwErrCnt >= pwErrCntLim) {	
					result.put(Constant.OUT_RESULT_MSG, "패스워드 오입력 횟수가 초과되었습니다.");	
					result.put(Constant.RESULT, Constant.RESULT_FAILURE);
					break;
				}
				
				//비밀번호 해쉬 처리
				String userPw = StringUtil.getSHA256("HPP" + (String)inData.get("userPw") + "MELONA");
				inData.put("userPw", userPw);				
				
				//패스워드가 일치하지 않을 때
				if(!userPw.equals(loginInfo.get("USER_PW"))) {		
					int cnt = sqlSession.update("mapper.user.UserMapper.pwErr", inData);
					result.put(Constant.OUT_RESULT_MSG, "존재하지 않는 아이디이거나 비밀번호가 일치하지 않습니다.");	
					result.put(Constant.RESULT, Constant.RESULT_FAILURE);
					log.info(inData.get("userId") + " 계정 패스워드 오입력 횟수 " + cnt + "회 증가");
					break;					
				}
				
				//패스워드 유효기간이 만료된 경우(클라이언트 단에서 실행)
				/*
				int pswdLimDays = Integer.parseInt((String) PapangUtil.getMapFromList(userPoli, "POLI_NM", "PSWD_LIM_DAYS").get("POLI_VAL"));	//비밀번호 변경 주기(일)
				String pwChDtti = (String) loginInfo.get("PW_CH_DTTI");	//비밀번호 최종수정일시
				String pswdLimDate = DateUtil.addDate(pwChDtti, 0, 0, pswdLimDays);	//비밀번호 변경 기한
				
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		        Calendar cal = Calendar.getInstance();
		        String strToday = sdf.format(cal.getTime());				
				
				if(DateUtil.isBefore(pswdLimDate, strToday)) {	//비밀번호 변경 기한이 현재 날짜보다 이전이면
					result.put(Constant.RESULT_DETAIL, Constant.PSWD_LIM_ISSUE);
				}
				*/
				
				//비밀번호 오입력 횟수 초기화
				sqlSession.update("mapper.user.UserMapper.resetPwErrCnt", inData);
				
				//로그인 IP 파악
				String ipAddr = RequestUtil.getIpAddr(request);
				loginInfo.put(Constant.IP_ADDRESS, ipAddr);
				
				//사용자 정보 세션에 저장
				HttpSession session = request.getSession();
				loginInfo.remove("USER_PW");	//패스워드 정보는 제거
				session.setAttribute(Constant.LOGIN_INFO, loginInfo);
				
				int sessionTime = Integer.parseInt((String) PapangUtil.getMapFromList(userPoli, "POLI_NM", "SESSION_TIME").get("POLI_VAL"));	//세션 유지시간(초단위)
				session.setAttribute(Constant.SESSION_TIME, sessionTime);
				session.setMaxInactiveInterval(sessionTime);
			}
			
			result.put("loginInfo", loginInfo);
			result.put(Constant.RESULT, Constant.RESULT_SUCCESS);
		
		} while(false);
		return result;
	}	
	
	/**
	 * @메소드명: logout
	 * @작성자: 김상민
	 * @생성일: 2023. 1. 9. 오후 1:24:49
	 * @설명: 로그아웃
	 */
	public Map<String, Object> logout(StringBuilder logStr, HttpServletRequest request, Map<String, Object> inData) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		//세션 로그인 정보 파기
		HttpSession session = request.getSession();
		session.invalidate();
		
		/*	
		//기존 스크립트
		session.setAttribute(Constant.LOGIN_INFO, null);
		
		//사용자 정책 조회
		inData.put("POLI_TYPE", "UESR");		
		List<Map<String, Object>> userPoli = sqlSession.selectList("mapper.com.CommonMapper.selectPoli", inData);
		
		int sessionTime = Integer.parseInt((String) PapangUtil.getMapFromList(userPoli, "POLI_NM", "SESSION_TIME").get("POLI_VAL"));	//세션 유지시간(초단위)
		session.setAttribute(Constant.SESSION_TIME, sessionTime);
		session.setMaxInactiveInterval(sessionTime);	
		 */
		
		//로그인 기록 테이블에 저장(추후 구현)
		//Int cnt = sqlSession.insert("mapper.user.UserMapper.insertLoginInfo", inData);
		
		result.put(Constant.RESULT, Constant.RESULT_SUCCESS);
		return result;		
	}
	
	
	
	/**
	 * 
	 * @메소드명: chkUniqId
	 * @작성자: 김상민
	 * @생성일: 2023. 1. 5. 오전 9:37:43
	 * @설명: 아이디 중복 체크
	 */
	public Map<String, Object> chkUniqId(StringBuilder logStr, Map<String, Object> inData) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		Map<String, Object> data = sqlSession.selectOne("mapper.user.UserMapper.selectUser", inData);
		result.put("data", data);
		
		result.put(Constant.RESULT, Constant.RESULT_SUCCESS);
		return result;
	}		
	
}
