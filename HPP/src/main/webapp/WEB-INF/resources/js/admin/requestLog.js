/**
 * @화면명: 요청 로그 조회 
 * @작성자: KimSangMin
 * @생성일: 2023. 1. 30. 오후 2:25:23
 * @설명: 클라이언트에서 서버로 넘어오는 요청관련 로그 조회
**/

//페이지 전역 변수
var mainTable

$(document).ready(function() {
	setDatetimepicker();
	
	makeDataTableServerSide();	//DataTable 만들기(페이지네이션 서버 처리)
});

//datetimepicker 설정
function setDatetimepicker() {
	var reqDttiStr = $dateUtil.addDate($dateUtil.todayYYYYMMDDHHMM(),0,0,-1,0,0);
	reqDttiStr = $dateUtil.dateHyphenTime(reqDttiStr);
	
	$com.datetimepicker('reqDttiStr',$dateUtil.todayYYYY_MM_DD_HHMM(reqDttiStr));
	$com.datetimepicker('reqDttiEnd',$dateUtil.todayYYYY_MM_DD_HHMM());	
}

//검색
function doSearch(){
	var formData = $('#searchForm').serialize();
	$com.loadingStart();
}

var columInfo = [
        { title: "발생일시"	, data: "reqDtti"		, width: "200px"	, className: "text_align_center"}
      , { title: "아이디"		, data: "userId"		, width: "100px"	, className: "text_align_center"	, defaultContent: ""}
      , { title: "아이피"		, data: "userIp"		, width: "100px"	, className: "text_align_center"	, defaultContent: ""}
      , { title: "URI"		, data: "reqUri"		, width: "200px"	, className: "text_align_left"		, defaultContent: ""}      
      , { title: "파라미터"	, data: "reqParam"		, width: "*"		, className: "text_align_left"		, defaultContent: ""}      
      , { title: "메뉴"		, data: "reqTypeNm"		, width: "100px"	, className: "text_align_center"	, defaultContent: ""}
]

//엑셀 다운로드 버튼
var excelDownBtn = $('<div class="table_btn_wrapper"><button type="button" class="papang-excel-btn papang_btn paginate_button">Excel</button></div>');

//DataTable 만들기(페이지네이션 서버 처리)
function makeDataTableServerSide() {
	var url = '/admin/selectRequestLog.do';
	var param = $('#searchForm').serialize();
	
    mainTable = $('#mainTable').DataTable({
		serverSide: true,
		ajax: {
			url: url,
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
        pagingType: "full_numbers",
        ordering: false,
        info: false,
        searching: false,
        lengthChange: false,
        autoWidth: false,		//자동 열 너비 조정
        
  		scrollY: 600,			//테이블 높이
  		scrollCollapse: true,   //테이블 최대 높이 고정 여부     
        
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
		}		
    });	
    
    //엑셀 작업을 위해 컬럼 정보 추가
    mainTable.columInfo = columInfo;
    
    //엑셀 다운로드 버튼
    excelDownBtn.on('click', function(){
		//$excelUtil.downloadData(mnuNm, mnuNm, mainTable.columInfo, data);
		$excelUtil.downloadURL(mnuNm, mnuNm, mainTable.columInfo, url);
	})
    $('#mainTable_paginate').after(excelDownBtn);    
}