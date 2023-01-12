/**
 * @화면명: 사용자 접속 기록 조회
 * @작성자: 김상민
 * @생성일: 2023. 1. 12. 오후 2:46:04
 * @설명: 관리자가 사용자 접속 기록을 조회할 수 있는 페이지
**/

//페이지 전역 변수
var mainTable

$(document).ready(function () {
	selectData();
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
            makeDataTable(result.list);
        }
    });	
}

//DataTable 만들기
function makeDataTable(data) {
    mainTable = $('#mainTable').DataTable({
        data: data,
        columns: [
            { title: "발생일시"	, data: "loginDtti"		, width: "25%"		, className: "text_align_center"}
          , { title: "아이디"		, data: "userId"		, width: "25%"		, className: "text_align_center"}
          , { title: "아이피"		, data: "userIp"		, width: "25%"		, className: "text_align_center"	,"defaultContent": ""}
          , { title: "유형"		, data: "loginCodeNm"	, width: "25%"		, className: "text_align_center"	,"defaultContent": ""}
        ],		
        paging: true,
        pagingType: "full_numbers",
        ordering: false,
        info: false,
        searching: false,
        lengthChange: false,
        pageLength: 10,
    });	
    
    var excelDownBtn = $('<div class="table_btn_wrapper"><button type="button" class="papang-excel-btn papang_btn paginate_button">엑셀 다운로드</button></div>');
    excelDownBtn.on('click', function(){
		alert('excelBtn');
	})
    $('#mainTable_paginate').after(excelDownBtn);
    
	$('#mainTable tbody').on('dblclick', 'tr', function () {
	    var data = mainTable.row( this ).data();
	    alert(data);
	});
    
}