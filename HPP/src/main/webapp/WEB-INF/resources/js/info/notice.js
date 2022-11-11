/**
 * @화면명: 공지사항 목록
 * @작성자: 김상민
 * @생성일: 2022. 11. 10. 오후 6:12:31
 * @설명: 공지사항 목록 조회 페이지
**/

$(document).ready(function () {
    $('#mainTable').DataTable({
        paging: true,
        pagingType: "full_numbers",
        ordering: false,
        info: false,
        searching: false,
        lengthChange: false,
        pageLength: 15,
        rowId: '',
	    scrollY: 550,
	    scroller: {
	        rowHeight: 500
	    },    
	    buttons: [ 'copy', 'csv', 'excel' ]
    });
    
    $.fn.DataTable.ext.pager.numbers_length = 9;
});