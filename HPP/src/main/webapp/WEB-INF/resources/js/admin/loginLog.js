/**
 * @화면명: 사용자 접속 기록 조회
 * @작성자: 김상민
 * @생성일: 2023. 1. 12. 오후 2:46:04
 * @설명: 관리자가 사용자 접속 기록을 조회할 수 있는 페이지
**/

//페이지 전역 변수
var mainTable

$(document).ready(function () {
	//selectData();				//DataTable 만들기
	makeDataTableServerSide();	//DataTable 만들기(페이지네이션 서버 처리)
});

//사용자 접속 기록 조회
function selectData(){
    $.ajax({
        url: '/admin/selectLoginLog.do',
        type: 'POST',
        data: {},
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
        dataType: 'json',
        success: function (result) {
            makeDataTable(result.data);
        }
    });	
}

var columInfo = [
        { title: "발생일시"	, data: "loginDtti"		, width: "25%"		, className: "text_align_center"}
      , { title: "아이디"		, data: "userId"		, width: "25%"		, className: "text_align_center"}
      , { title: "아이피"		, data: "userIp"		, width: "25%"		, className: "text_align_center"	, defaultContent: ""}
      , { title: "유형"		, data: "loginCodeNm"	, width: "25%"		, className: "text_align_center"	, defaultContent: ""}
]

//엑셀 다운로드 버튼
var excelDownBtn = $('<div class="table_btn_wrapper"><button type="button" class="papang-excel-btn papang_btn paginate_button">Excel</button></div>');

//엑셀 업로드 버튼
var excelUploadBtn = $('<div class="table_btn_wrapper"><button type="button" class="papang-excel-btn papang_btn paginate_button">Excel Upload</button></div>');

//DataTable 만들기
function makeDataTable(data) {
    mainTable = $('#mainTable').DataTable({
        data: data,
        columns: columInfo,		
        paging: true,
        pagingType: "full_numbers",
        ordering: false,
        info: false,
        searching: false,
        lengthChange: false,
        pageLength: 10,
    });	
    
    //엑셀 작업을 위해 컬럼 정보 추가
    mainTable.columInfo = columInfo;
    
    //엑셀 다운로드 버튼
    excelDownBtn.on('click', function(){
		$excelUtil.downloadData(mnuNm, mnuNm, mainTable.columInfo, data);
	})
    $('#mainTable_paginate').after(excelDownBtn);
    
    //엑셀 업로드 버튼
    excelUploadBtn.on('click', function(){
		$excelUtil.upload(excelUploadOptions, excelUploadCallBack);
	})
    $('#mainTable_paginate').after(excelUploadBtn);    
    
	var excelUploadOptions = [];
	
	//excel 업로드 옵션 입력(사용할 시트 수 만큼 반복)
	var excelUploadOption={};
	excelUploadOption["rowOffset"] = 4;		//빈 행 개수(테이블 헤드도 빈 행으로 취급)
	excelUploadOption["colOffset"] = 1;		//빈 열 개수
	excelUploadOption["colOptions"] = mainTable.columInfo;
	
	excelUploadOptions.push(excelUploadOption);
}

//DataTable 만들기(페이지네이션 서버 처리)
function makeDataTableServerSide() {
    mainTable = $('#mainTable').DataTable({
		serverSide: true,
		ajax: {
			url: '/admin/selectLoginLog.do',
        	type: 'POST',
        	data: function(data){
				if($util.isEmpty(mainTable)){
					data.page = 0;
				} else {
					data.page = parseInt(mainTable.page());
				};
				data.pageLength = 10;				//페이지당 레코드 수
				data.strIdx = 1 + (10 * data.page);	//시작 레코드 인덱스
			},
		},
        columns: columInfo,		
        //paging: true,
        pagingType: "full_numbers",
        ordering: false,
        info: false,
        searching: false,
        lengthChange: false,
        preDrawCallback : function(settings){	//테이블 그리기 전에 동작
			$com.loadingStart();	//로딩패널 보이기
		},
        drawCallback : function(settings){		//테이블 그리기 후에 동작
			$com.loadingEnd();		//로딩패널 숨기기
		},
		language : {
			paginate : {
				first : '처음',
				last : '마지막',
				next : '다음',
				previous : '이전'
			},
			zeroRecords	: '조회된 결과가 없습니다.',
			//info : '전체 _TOTAL_건',
		}		
    });	
}

//엑셀 업로드 후 콜백
var excelUploadCallBack = function(result){
	mainTable.destroy();
	makeDataTable(result[Constant.OUT_DATA][0]);
};