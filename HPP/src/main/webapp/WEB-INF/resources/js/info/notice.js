/**
 * @화면명: 공지사항 목록
 * @작성자: 김상민
 * @생성일: 2022. 11. 10. 오후 6:12:31
 * @설명: 공지사항 목록 조회 페이지
**/

//전역 변수
var mainTable

$(document).ready(function () {
	selectNotice();
});

//공지사항 목록 조회
function selectNotice(){
    $.ajax({
        url: '/notice/selectNotice.do',
        type: 'POST',
        data: {},
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
        dataType: 'json',
        success: function (result) {
                mkNoticeTable(result.list);
        }
    });	
}

//DataTable 만들기
function mkNoticeTable(data) {
    mainTable = $('#mainTable').DataTable({
        data: data,
        columns: [
            { title: "제목"	, data: "BOARD_TITLE"	, width: "*"		, className: "text_align_left"}
          , { title: "작성자"	, data: "FST_REG_ID"	, width: "100px"	, className: "text_align_center"}
          , { title: "게시일"	, data: "LT_UPD_ID"		, width: "100px"	, className: "text_align_center"}
          , { title: "조회수"	, data: "BOARD_HIT"		, width: "50px"		, className: "text_align_center"}
        ],		
        paging: true,
        pagingType: "full_numbers",
        ordering: false,
        info: false,
        searching: false,
        lengthChange: false,
        pageLength: 10,
        rowId: '',
		dom : 'Bfrtip',	
	    buttons: {
	        buttons: [
	            {text: '신규', className: 'btn papang-create-btn btn-sm papang_btn' , extend: '', action: function ( e, dt, node, config ) {
                    noticeModalOpen();
                },},
	            {text: '삭제', className: 'btn papang-create-btn btn-sm papang_btn' , extend: '', action: function ( e, dt, node, config ) {
                    alert( 'Button activated' );
                },},                
	        ]
	    },       
    });	
    
	$('#mainTable tbody').on('dblclick', 'tr', function () {
	    var data = mainTable.row( this ).data();
	    noticeModalOpen(data);
	});
    
}