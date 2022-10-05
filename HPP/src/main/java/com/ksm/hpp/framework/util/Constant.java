package com.ksm.hpp.framework.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 시스템 전반에 사용되는 상수 형태의 상태값
 * @author dgbds
 *
 */
public class Constant
{
	/*
	 * ===========================================
	 * 공통 상수
	 * ===========================================
	 */
	/**
	 * 데이터 입력시 Key
	 */
	public static final String IN_DATA = "IN_DATA";
	/**
	 * 데이터 입력시 Key(JSON 파싱으로 MAP 전환 되어야 되는 경우 사용)
	 */
	public static final String IN_DATA_JSON = "IN_DATA_JSON";
	/**
	 * request 내의 log 생성을 위한 logbuilder가 저장된 key
	 */
	public static final String IN_LOG_STR = "IN_LOG_STR";
	/**
	 * 데이터 반환시 Key
	 */
	public static final String OUT_DATA = "OUT_DATA";
	/**
	 * 데이터 개수 반환시 Key
	 */
	public static final String OUT_DATA_CNT = "OUT_DATA_CNT";
	/**
	 * 로직 처리 결과 Key
	 */
	public static final String OUT_RESULT = "RESULT";
	/**
	 * 로직 처리 결과 성공
	 */
	public static final String OUT_RESULT_SUCCESS = "RESULT_SUCCESS";
	/**
	 * 로직 처리 결과 실패
	 */
	public static final String OUT_RESULT_FAILURE = "RESULT_FAILURE";
	/**
	 * 로직 처리 결과 메시지 Key<br>
	 * 이 항목은 화면단에서 사용자에게 보여주기 위해 사용합니다.<br>
	 * 국제화 처리가 화면단(자바스크립트) 에서 진행되므로 되도록 코드를 적어 보내야 합니다.
	 */
	public static final String OUT_RESULT_MSG = "RESULT_MSG";
	/**
	 * 에러명(java exception name) Key<br>
	 * 이 항목은 화면단에서 사용자에게 보여주지 않고 디버그용 콘솔로만 출력하기 위해 사용합니다.
	 */
	public static final String OUT_RESULT_ERRNM = "RESULT_ERRNM";
	/**
	 * CRUD 모드 Key
	 */
	public static final String CRUD = "mode";
	/**
	 * CRUD C Key
	 */
	public static final String CRUD_C = "c";
	/**
	 * CRUD R Key
	 */
	public static final String CRUD_R = "r";
	/**
	 * CRUD U Key
	 */
	public static final String CRUD_U = "u";
	/**
	 * CRUD U_ALT Key
	 */
	public static final String CRUD_U_ALT = "u_a";
	/**
	 * CRUD D Key
	 */
	public static final String CRUD_D = "d";
	/**
	 * CRUD 등록 Key
	 */
	public static final String CRUD_C_NM = "등록";
	/**
	 * CRUD 조회 Key
	 */
	public static final String CRUD_R_NM = "조회";
	/**
	 * CRUD 수정 Key
	 */
	public static final String CRUD_U_NM = "수정";
	/**
	 * CRUD 삭제 Key
	 */
	public static final String CRUD_D_NM = "삭제";
	/**
	 * 세션에 설정된 유저 정보 Key
	 */
	public static final String USER_INFO = "USER_INFO";
	/**
	 * 세션에 설정된 유저 정보중 ip정보 Key
	 */
	public static final String IP_ADDR = "IP_ADDR";
	/**
	 * 세션에 설정된 유저 정보중 계열사 코드  Key
	 */
	public static final String FIDCOMPANY = "SBSDRY_CD";
	/**
	 * 세션에 설정된 유저 정보중 계열사 명 정보 Key
	 */
	public static final String SBSDRY_NM = "SBSDRY_NM";
	/**
	 * 세션에 설정된 유저 정보중 행번정보 Key
	 */
	public static final String USER_ID = "USER_ID";
	/**
	 * 세션에 설정된 유저 정보중 이름 정보 Key
	 */
	public static final String FNAME = "FNAME";
	/**
	 * 세션에 설정된 유저 정보중 직위 정보 Key
	 */
	public static final String PSIT_CD = "PSIT_CD";
	/**
	 * 세션에 설정된 유저 정보중 직위명 정보 Key
	 */
	public static final String FNMROLE = "FNMROLE";
	/**
	 * 세션에 설정된 유저 정보중 직원관리번호 정보 Key
	 */
	public static final String STF_MGNO = "STF_MGNO";
	/**
	 * 세션에 설정된 유저 정보중 재직상태 Key
	 */
	public static final String WORK_STC = "WORK_STC";
	/**
	 * 세션에 설정된 유저 정보중 부점정보 Key
	 */
	public static final String DPNO = "DPNO";
	/**
	 * 세션에 설정된 유저 정보중 부점 명 정보 Key
	 */
	public static final String FNMDEPT = "FNMDEPT";
	/**
	 * 세션에 설정된 유저 정보중 직원내선번호정보 Key
	 */
	public static final String FNOTEL = "FNOTEL";
	/**
	 * 세션에 설정된 유저 정보중 email Key
	 */
	public static final String EMAIL = "EMAIL";
	/**
	 * 세션에 설정된 유저 정보중 패스워드정보 Key
	 */
	public static final String CNNT_PSWD = "CNNT_PSWD";
	
	// 사용자 그룹 코드
	final public static String GROUP_ADMIN = "00001";				// 시스템 관리자
	final public static String GROUP_CUSTOMER_CHARGE = "00002";		// 고객정보 담당자
	final public static String GROUP_CUSTOMER_ADMIIN = "00003";		// 고객정보 관리자
	final public static String GROUP_DELEGATE = "00004";			// 대체 결재자
	final public static String GROUP_USER = "00005";				// 이용자
	final public static String GROUP_DEP_HEAD = "00006";			// 소관부서장
	
	// 이용자 자료 수신 내역
	final public static String USER_DATA_INFO = "USER_DATA_INFO";		// 이용자 자료 수신 내역
	
	//--------------------------------------------------------------------------
	//
    //  EPIC 시스템 상수
    //
    //--------------------------------------------------------------------------
	final public static String RUN_REQUEST_USER = "requestorid";
	final public static String RUN_REQUEST_ADDR = "requestoraddr";
	
//	final public static String FILE_URL = File.separator + "bankfile"+ File.separator;
	final public static String LOGO_URL = File.separator + "images"+ File.separator + "company"+ File.separator;
	final public static String LOGO_FILE_FIREST_NAME = "Pic_logo_";
	
	final public static boolean SMS_SEND = true;
	final public static String SMS_URL = "192.168.121.40"; // 운영서버
//		final public static String SMS_URL = "192.168.125.40"; // 개발서버
	final public static int SMS_PORT = 9001;
	
	//--------------------------------------------------------------------------
	//
    //  오류 관련 정의 상수
    //
    //--------------------------------------------------------------------------
	// 로그인 오류(99)
	final public static String ERROR_LOGIN = "ERROR_LOGIN";
	final public static String ERROR_LOGIN_CODE = "99";
	
	// 허용 되지않은 IP 접근 (01)
	final public static String WRONG_IP = "WRONG_IP";
	final public static String WRONG_IP_CODE = "01";
	
	// 존재하지 않는 사용자 (02)
	final public static String WRONG_USER = "WRONG_USER";
	final public static String WRONG_USER_CODE = "02";
	
	// 잘못된 비밀번호 (03)
	final public static String WRONG_PASSWORD = "WRONG_PASSWORD";
	final public static String WRONG_PASSWORD_CODE = "03";
	
	// 비밀번호 오 입력 초과 (04)
	final public static String OVERTIME_PASSWORD = "OVERTIME_PASSWORD";
	final public static String OVERTIME_PASSWORD_CODE = "04";
	
	// 비밀번호 기간만료 (05)
	final public static String EXPIRATION_PASSWORD = "EXPIRATION_PASSWORD";
	final public static String EXPIRATION_PASSWORD_CODE = "05";
	
	// 초기화된 비밀번호 (06)
	final public static String INIT_PASSWORD = "INIT_PASSWORD";
	final public static String INIT_PASSWORD_CODE = "06";
	
	// 메뉴없음
	final public static String WRONG_MENU = "WRONG_MENU";
	
	// 정책  설정관련 Method - PolicyCtrl
	final public static String MENU_ID_POLICY = "SYS02020000";
	
	// 이용자 정보변경  설정관련 Method - UserInfoCtrl
	final public static String MENU_ID_USERINFO = "USR01000000";
	
	// 기본 메인화면 ID
	final public static String MENU_ID_WELCOME = "COM02000000";	
	
	// Session에 저장할 사용자 정보
	final public static String LOGIN_INFO = "LOGIN_INFO";
	
	// Session에 저장할 사용자 그룹
	final public static String LOGIN_GROUP = "LOGIN_GROUP";
	
	// Session에 저장할 정책 정보
	final public static String POLICY_INFO = "POLICY_INFO";
	
	// Session에 저장할 시스템 정책 정보
	final public static String SYSTEM_POLICY_INFO = "SYSTEM_POLICY_INFO";

	/*
	 * ===========================================
	 * 에러 상수
	 * ===========================================
	 */
	/**
	 * 에러 메시지 모음 key
	 */
	@SuppressWarnings("serial")
	public static final Map<String, Object> ERR_MSG = new HashMap<String, Object>()
	{
		{
//			put("ERR_DEFAULT", "서버 에러가 발생했습니다.");
//			put("ERR_SVC_MANUAL", "Service stopped by manual");	// 이 메시지는 다른 메시지와 달리 OUT_RESULT_ERRNM으로 등록
//			put("ERR_DB_DUPLICATE", "중복 건이 존재합니다.");
//			put("ERR_DB_PARAM_NULL1", "입력되지 않은 항목이 있습니다.");
//			put("ERR_DB_PARAM_NULL2", "입력되지 않은 항목이 있습니다.");
//			put("ERR_DB_COL_LEN", "입력 길이를 초과한 항목이 있습니다.");
			put("ERR_DEFAULT", "ERR_DEFAULT");
			put("ERR_SVC_MANUAL", "Service stopped by manual");	// 이 메시지는 다른 메시지와 달리 OUT_RESULT_ERRNM으로 등록
			put("ERR_DB_DUPLICATE", "ERR_DB_DUPLICATE");
			put("ERR_DB_PARAM_NULL1", "ERR_DB_PARAM_NULL");
			put("ERR_DB_PARAM_NULL2", "ERR_DB_PARAM_NULL");
			put("ERR_DB_COL_LEN", "ERR_DB_COL_LEN");
		}
	};
	/**
	 * 에러-기타 에러<br>
	 * 원인을 알 수 없는 에러가 일어난 경우
	 */
	public static final String ERR_DEFAULT = "ERR_DEFAULT";
	/**
	 * 에러-서비스단 수동 에러(SvcException)<br>
	 * 서비스에서 수동으로 에러를 일으킨 경우(SvcException)
	 */
	public static final String ERR_SVC_MANUAL = "ERR_SVC_MANUAL";
	/**
	 * 에러-DB중복 에러<br>
	 * DB에서 키, 유니크 값이 중복되어 등록되는 경우 발생하는 Exception의 getMessage() 안에 있는 특징적인 문구
	 */
	public static final String ERR_DB_DUPLICATE = "JDBC-10007";
	/**
	 * 에러-DB 파라미터 NULL 에러1<br>
	 * DB에서 마이바티스 파라미터에 입력되어야 할 값이 null인 경우 발생하는 Exception의 getMessage() 안에 있는 특징적인 문구
	 */
	public static final String ERR_DB_PARAM_NULL1 = "JDBC-10005";
	/**
	 * 에러-DB 파라미터 NULL 에러2<br>
	 * DB에서 마이바티스 파라미터에 입력되어야 할 값이 null인 경우 발생하는 Exception의 getMessage() 안에 있는 특징적인 문구
	 */
	public static final String ERR_DB_PARAM_NULL2 = "Error setting null for parameter";
	/**
	 * 에러-DB 컬럼 길이 초과 에러<br>
	 * DB에서 컬럼에 입력하는 값이 길이를 초과하는 경우 발생하는 Exception의 getMessage() 안에 있는 특징적인 문구
	 */
	public static final String ERR_DB_COL_LEN = "JDBC-11048";

	/*
	 * ===========================================
	 * 엑셀 관련 상수
	 * ===========================================
	 */
	public static final String EXCEL_FILENM = "EXCEL_FILENM";
	public static final String EXCEL_IN_DATA = "EXCEL_IN_DATA";
	public static final String EXCEL_IN_COLUMN = "EXCEL_IN_COLUMN";
	public static final String EXCEL_IN_MARKER = "EXCEL_IN_MARKER";

	/*
	 * ===========================================
	 * html 기본 페이징 관련 상수
	 * ===========================================
	 */
	/**
	 * 화면 -> 서버 페이징 정보 맵 키
	 */
	public static final String IN_TABLE_PAGE = "in_table_page";
	/**
	 * 화면 -> 서버 페이징 여부
	 */
	public static final String IN_TABLE_PAGING = "in_table_paging";
	/**
	 * 화면 -> 서버 페이지 번호
	 */
	public static final String IN_TABLE_PAGENO = "in_table_pageNo";
	/**
	 * 화면 -> 서버 페이지당 개수
	 */
	public static final String IN_TABLE_PAGESIZE = "in_table_pageSize";
	/**
	 * 화면 <- 서버 페이징 정보 맵 키
	 */
	public static final String OUT_TABLE_PAGE = "out_table_page";
	/**
	 * 화면 <- 서버 페이지 번호
	 */
	public static final String OUT_TABLE_PAGENO = "out_table_pageNo";
	/**
	 * 화면 <- 서버 페이지 총 개수
	 */
	public static final String OUT_TABLE_PAGECOUNT = "out_table_pageCount";

	/*
	 * ===========================================
	 * json AXGrid 조회 출력
	 * ===========================================
	 */
	/**
	 * AxisJ용 출력: 처리결과
	 */
	public static final String AX_RESULT = "result";
	/**
	 * AxisJ용 출력: 처리성공
	 */
	public static final String AX_RESULT_OK = "ok";
	/**
	 * AxisJ용 출력: 처리실패
	 */
	public static final String AX_RESULT_FAIL = "fail";
	/**
	 * AxisJ용 출력: 처리메시지
	 */
	public static final String AX_MSG = "msg";
	/**
	 * AxisJ용 입출력: 페이지
	 */
	public static final String AX_PAGE = "page";
	/**
	 * AxisJ용 입출력: 페이지 사용 여부
	 */
	public static final String AX_PAGING = "paging";
	/**
	 * AxisJ용 입출력: 페이지 번호
	 */
	public static final String AX_PAGENO = "pageNo";
	/**
	 * AxisJ용 출력: 페이지 개수
	 */
	public static final String AX_PAGECOUNT = "pageCount";
	/**
	 * AxisJ용 입력: 페이지당 행 개수
	 */
	public static final String AX_PAGESIZE = "pageSize";
	/**
	 * AxisJ용 출력: 조회된 행 개수
	 */
	public static final String AX_LISTCOUNT = "listCount";
	/**
	 * AxisJ용 출력: 반환 데이터 리스트
	 */
	public static final String AX_LIST = "list";

	/*
	 * ===========================================
	 * 프로젝트 귀속 상수
	 * 객체명 자체가 해당 프로젝트에서만 사용되는 경우
	 * ===========================================
	 */
	/**
	 * 암호화 대상 컬럼명 배열
	 */
	public static final String[] ENC_COL_NM = {"REG_USER", "REG_USER2"};
	/**
	 * 개인정보 컬럼명 배열
	 */
	public static final String[] PRV_COL_NM = {"CUST_NM","CUST_TEL"};
	/**
	 * 개인정보 조회 로그: 주민등록번호
	 */
	public static final String PRIV_R_RRNO = "개인정보조회: 주민등록번호";
	
	
	/*
	 * ===========================================
	 * 파일 관련 상수
	 * ===========================================
	 */
	/**
	 * 파일 URL
	 */
	public static final String FILE_URL = File.separator + "bankfile"+ File.separator;
}
