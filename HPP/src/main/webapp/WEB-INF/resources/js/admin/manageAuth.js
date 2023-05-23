/**
 * @화면명: 권한 관리
 * @작성자: KimSangMin
 * @생성일: 2023. 5. 23. 오후 7:18:19
 * @설명: 관리자가 권한 정보를 조회 및 관리할 수 있는 메뉴입니다.
**/

$(document).ready(function () {
	selectMnuListLv1();
	selectRoleListAuth();
	selectMnuListTable();
});	

//메뉴 목록 조회(메뉴 select)
function selectMnuListLv1(){
    $.ajax({
        url: '/admin/selectMnuListLv1.do',
        type: 'POST',
        data: '',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
        dataType: 'json',
        success: function (result) {
	        if (result.RESULT == Constant.RESULT_SUCCESS){
	            var mnuList = result.OUT_DATA;
	            for(var i in mnuList){
					var $option = $('<option value"' + mnuList[i].mnuSeq +'">' + mnuList[i].mnuNm +'</option>');
					$('#mnuSeq').append($option);
				}
	        } else {
				alert(result[Constant.OUT_RESULT_MSG])
			}			
        }
    });	
}

//권한그룹 목록 조회(권한 select)
function selectRoleListAuth(){
    $.ajax({
        url: '/admin/selectRoleListAuth.do',
        type: 'POST',
        data: '',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
        dataType: 'json',
        success: function (result) {
	        if (result.RESULT == Constant.RESULT_SUCCESS){
	            var roleList = result.OUT_DATA;
	            for(var i in roleList){
					var $option = $('<option value"' + roleList[i].roleSeq +'">' + roleList[i].roleNm +'</option>');
					$('#roleSeq').append($option);
				}
	        } else {
				alert(result[Constant.OUT_RESULT_MSG])
			}			
        }
    });	
}

//메뉴 목록 조회(메뉴 목록 테이블)
function selectMnuListTable(){
    $.ajax({
        url: '/admin/selectMnuListTable.do',
        type: 'POST',
        data: $('#searchForm').serialize(),
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
        dataType: 'json',
        success: function (result) {
	        if (result.RESULT == Constant.RESULT_SUCCESS){
	            var mnuList = result.OUT_DATA;
	            console.log(mnuList);
	        } else {
				alert(result[Constant.OUT_RESULT_MSG])
			}			
        }
    });	
}
