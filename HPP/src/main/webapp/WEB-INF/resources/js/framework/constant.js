/*
 * @작성자: 김상민
 * @생성일: 2022. 11. 10. 오전 8:56:10
 * @설명: JS 공통 변수 모음
 */
 
 var Constant = {
   //request, response 관련
	 OUT_DATA 		: "OUT_DATA"			//리턴할 데이터
   , RESULT 		: "RESULT"				//결과(RESULT_SUCCESS 혹은 RESULT_FAILURE)
   , RESULT_SUCCESS : "RESULT_SUCCESS"		//성공
   , RESULT_FAILURE : "RESULT_FAILURE"		//실패
   , OUT_RESULT_MSG : "OUT_RESULT_MSG"		//결과에 대한 메세지
   , RESULT_DETAIL	: "RESULT_DETAIL"		//결과 상세(결과에 대한 구체적인 분류 - DB반영 실패, 입력 형식 불일치 등)   
   
   //RESULT_DETAIL 관련
   , PSWD_LIM_ISSUE : "PSWD_LIM_ISSUE"		//패스워드 변경 주기 문제  
   
   //로그인 관련
   , LOGIN_INFO 	: "LOGIN_INFO"			//로그인 정보
   , SESSION_TIME	: "SESSION_TIME"		//세션 유지 시간
   , IP_ADDRESS		: "IP_ADDRESS"			//IP주소   
 }
