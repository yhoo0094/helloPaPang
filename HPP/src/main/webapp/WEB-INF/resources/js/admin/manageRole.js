/**
* @파일명: manageRole.js
* @작성자: KimSangMin
* @생성일: 2023. 5. 3. 오후 8:20:50
* @설명: 권한그룹 관리
*/

$(document).ready(function () {
	selectData();
});	

//권한그룹 조회
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

//DataTable 만들기
function makeDataTable(data) {
    mainTable = $('#mainTable').DataTable({
        data: data,
        columns: columInfo,		
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