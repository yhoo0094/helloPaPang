/**
* @파일명: manageRole.js
* @작성자: KimSangMin
* @생성일: 2023. 5. 3. 오후 8:20:50
* @설명: 권한그룹 관리
*/

//$(document).ready(function () {
//	selectData();
//});	

$(document).ready(function() {
	selectData();
	
    var table = $('#example').DataTable( {
        rowReorder: {
            selector: 'tr'
        },
//        columnDefs: [
//            { targets: 0, visible: false }
//        ]
    } );
} );

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
	{ title: "표시순서"	, data: "roleOrder"		, width: "10%"		, className: "text_align_center"},
	{ title: "그룹명"		, data: "roleNm"		, width: "20%"		, className: "text_align_center"},
	{ title: "비고"		, data: "rmrk"			, width: "70%"		, className: "text_align_center"	, defaultContent: ""},
]

//DataTable 만들기
function makeDataTable(data) {
    mainTable = $('#mainTable').DataTable({
        data: data,
        columns: columInfo,		
//        paging: false,
//        ordering: false,
//        info: false,
//        searching: false,
//        lengthChange: false,
//        autoWidth: false,						//자동 열 너비 조정
//  		scrollY: 600,							//테이블 높이
//  		scrollCollapse: true,   				//테이블 최대 높이 고정 여부     
//        preDrawCallback : function(settings){	//테이블 그리기 전에 동작
//			$com.loadingStart();				//로딩패널 보이기
//		},
//        drawCallback : function(settings){		//테이블 그리기 후에 동작
//			$com.loadingEnd();					//로딩패널 숨기기
//		},
//		language : {
//			zeroRecords	: '조회된 결과가 없습니다.',
//		},
		
//		ordering: true,
        rowReorder: {
            selector: 'tr'
        },
//	    columnDefs: [
//            { targets: 0, visible: false }
//        ]
    });	
}
