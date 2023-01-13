/**
 * @작성자: 김상민
 * @생성일: 2023. 1. 13. 오전 9:30:05
 * @설명: excel 유틸
 */
var $excelUtil = {};
 
/**
 * 엑셀 파일 다운로드(데이터 기반)
 * @param defaultFileName 	기본 파일명
 * @param sheetName 		시트명 
 * @param cols 				엑셀 컬럼 정보 - 배열에 오브젝트 담은 형식 ex.[{key: 'index', label: '순번'}, {key: 'name', label: '이름'}]
 * @param data 				엑셀 입력 데이터 - 배열에 오브젝트 담은 형식 ex.[{index: '1', name: '홍길동'}, {index: '2', name: '김길동'}]
 */
$excelUtil.downloadData = function(defaultFileName, sheetName, cols, data){
	var fileName = prompt('저장할 파일명을 입력해주세요.',defaultFileName);
	if(fileName == null){
		return false;	
	}

	//유효성 검증
	if($util.isEmpty(fileName)){alert("파일명을 입력해주세요"); $excelUtil.downloadData(defaultFileName, sheetName, cols, data); return false;}
	var fileNameRule = /^[가-힣a-zA-Z0-9\s]+$/;;	//파일명 명명 규칙(한글, 영문 대소문자, 숫자만 입력 가능)
	if(!fileNameRule.test(fileName)){alert("파일명은 한글, 영문 대소문자, 숫자만 입력 가능합니다."); return false;}
	if($util.isEmpty(sheetName)){alert("시트명을 입력해주세요"); return false;}
	if($util.isEmpty(cols)){alert("출력할 데이터가 존재하지 않습니다."); return false;}
	if($util.isEmpty(data)){alert("출력할 데이터가 존재하지 않습니다."); return false;}
	
	var formTage = document.createElement("form");
	formTage.setAttribute("action", "/excel/downloadData.do");
	formTage.setAttribute("method", "post");
	
	//파라미터 설정
	var inDataParam = {};
	inDataParam[Constant.EXCEL_FILENM]	= fileName;		//파일명
	inDataParam[Constant.EXCEL_SHEETNM]	= sheetName;	//시트명
	inDataParam[Constant.EXCEL_COLUMN]	= cols;			//컬럼 정보
	inDataParam[Constant.EXCEL_DATA] 	= data;			//입력 데이터 
	
	//폼에 파라미터 입력(추후 구현: ajax로 데이터 보내보자)
	var inputTag = document.createElement("input");
	inputTag.setAttribute("type", "hidden");
	inputTag.setAttribute("name", Constant.IN_DATA_JOSN);
	inputTag.value = JSON.stringify(inDataParam);
	formTage.append(inputTag);
	
	//전송
	$('body').append(formTage);
	$(formTage).submit();
	$(formTage).remove();
};