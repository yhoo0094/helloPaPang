package com.ksm.hpp.framework.util;

//시스템 전반에 사용되는 상수 값 모음
public class Constant
{
	//request, response 관련
	public static final String OUT_DATA 		= "OUT_DATA";			//리턴할 데이터
	public static final String RESULT 			= "RESULT";				//결과(RESULT_SUCCESS 혹은 RESULT_FAILURE)
	public static final String RESULT_SUCCESS 	= "RESULT_SUCCESS";		//성공
	public static final String RESULT_FAILURE 	= "RESULT_FAILURE";		//실패
	public static final String OUT_RESULT_MSG 	= "OUT_RESULT_MSG";		//결과에 대한 메세지
	public static final String RESULT_DETAIL 	= "RESULT_DETAIL";		//결과 상세(결과에 대한 구체적인 분류 - DB반영 실패, 입력 형식 불일치 등)
	
	//RESULT_DETAIL 관련
	public static final String PSWD_LIM_ISSUE 	= "PSWD_LIM_ISSUE";		//패스워드 변경 주기 문제
	
	//로그인 관련
	public static final String LOGIN_INFO 		= "LOGIN_INFO";			//로그인 정보
	public static final String SESSION_TIME		= "SESSION_TIME";		//세션 유지 시간
	public static final String IP_ADDRESS		= "IP_ADDRESS";			//IP주소
}
