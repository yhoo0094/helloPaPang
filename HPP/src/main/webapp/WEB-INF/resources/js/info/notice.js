/**
 * @화면명: 공지사항 목록
 * @작성자: 김상민
 * @생성일: 2022. 11. 10. 오후 6:12:31
 * @설명: 공지사항 목록 조회 페이지
**/

$(document).ready(function () {
    $('#example').DataTable({
        paging: true,
        ordering: false,
        info: false,
        searching: false,
    });
});