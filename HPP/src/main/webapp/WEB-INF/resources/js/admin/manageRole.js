/**
* @파일명: manageRole.js
* @작성자: KimSangMin
* @생성일: 2023. 5. 3. 오후 8:20:50
* @설명: 권한그룹 관리
*/

$(document).ready(function () {
	selectData();
	makeGroupUserDataTable();
});	

//권한그룹 목록 조회
function selectData(){
    $.ajax({
        url: '/admin/selectRoleList.do',
        type: 'POST',
        data: $('#searchForm').serialize(),
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
        dataType: 'json',
        success: function (result) {
            makeDataTable(result.data);
        }
    });	
}

var columInfo = [
	{ title: "표시순서"	, data: "roleOrder"		, width: "100px"		, className: "text_align_center"},
	{ title: "그룹명"		, data: "roleNm"		, width: "100px"		, className: "text_align_center"},
	{ title: "비고"		, data: "rmrk"			, width: "*"			, className: "text_align_left"		, defaultContent: ""},
]

//DataTable 만들기
var mainTable;
function makeDataTable(data) {
    mainTable = $('#mainTable').DataTable({
        data: data,
        columns: columInfo,		
        paging: false,
        ordering: false,
        info: false,
        searching: false,
        lengthChange: false,
        autoWidth: false,						//자동 열 너비 조정
  		scrollY: 600,							//테이블 높이
  		scrollCollapse: true,   				//테이블 최대 높이 고정 여부     
        preDrawCallback : function(settings){	//테이블 그리기 전에 동작
			$com.loadingStart();				//로딩패널 보이기
		},
        drawCallback : function(settings){		//테이블 그리기 후에 동작
			$com.loadingEnd();					//로딩패널 숨기기
		},
		language : {
			zeroRecords	: '조회된 결과가 없습니다.',
		},
        rowReorder: {							//행 드래그해서 순서 바꾸기
            selector: 'td:first-child'
        },
    });	
    
    //테이블 클릭 이벤트
	$('#mainTable tr').on('click', function () {
	    var data = mainTable.row(this).data();
	    $('#roleNmSpan').text(data.roleNm);
	    param.roleSeq = data.roleSeq;
	    groupUserTable.ajax.reload();
	});	    
	
	$('#mainTable tr').eq(1).click();
}

var groupUserCol = [
	{ title: "ID"		, data: "userId"		, width: "100px"		, className: "text_align_center"},
	{ title: "ID"		, data: "userId"		, width: "100px"		, className: "text_align_center"},
	{ title: "이름"		, data: "userName"		, width: "100px"		, className: "text_align_center"},
]

//권한그룹에 속한 사용자 목록 테이블 만들기
var param = {
	pageLength : '10',
	roleSeq : '1',
}

var groupUserTable;
function makeGroupUserDataTable(){
    groupUserTable = $('#groupUserTable').DataTable({
		serverSide: true,						//페이징 처리 서버에서 수행
		ajax: {
			url: '/admin/selectGroupUser.do',
        	type: 'POST',
			data: function(){
				if($util.isEmpty(mainTable)){
					param.strIdx = 0;
				} else {
					param.strIdx = 0 + (param.pageLength * parseInt(mainTable.page()));		//시작 레코드 인덱스 
				};
				return param;
			},
		},
        columns: groupUserCol,
        pagingType: "numbers",					//v페이지 표시 옵션
        ordering: false,
        info: false,
        searching: false,
        lengthChange: false,
        autoWidth: false,						//자동 열 너비 조정
  		scrollY: 600,							//테이블 높이
  		scrollCollapse: true,   				//테이블 최대 높이 고정 여부     
        preDrawCallback : function(settings){	//테이블 그리기 전에 동작
			$com.loadingStart();				//로딩패널 보이기
		},
        drawCallback : function(settings){		//테이블 그리기 후에 동작
			$com.loadingEnd();					//로딩패널 숨기기
		},
		language : {
			zeroRecords	: '조회된 결과가 없습니다.',
		},
    });	
}
