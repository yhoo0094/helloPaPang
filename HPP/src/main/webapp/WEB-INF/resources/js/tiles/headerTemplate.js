/**
 * @화면명: 헤더 템플릿
 * @작성자: KimSangMin
 * @생성일: 2023. 11. 23. 오후 6:49:10
 * @설명: 헤더 메뉴에 대한 tiles 템플릿
**/

$(document).ready(function() {
	headerHover();
});

//로그아웃
function loginOut() {
	if(!confirm("정말 로그아웃 하시겠습니까?")){
		return;
	}
	
	$com.loadingStart();
    $.ajax({
        url: '/user/logout.do',
        type: 'POST',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
        dataType: 'json',
        success: function (result) {
			$com.loadingEnd();
	        if (result.RESULT == Constant.RESULT_SUCCESS){
				sessionStorage.removeItem("loginInfo");
	            location.replace('/');
	        } else {
				alert(result[Constant.OUT_RESULT_MSG])
			}
        },
        error: function(textStatus, jqXHR, thrownError){
			$com.loadingEnd();
		}        
    });		
}	

//헤더 메뉴 hover하면 서브 메뉴 나타나기
function headerHover() {
	$(".navMnuDiv").hover(
        function() {
            $(this).find('.dropdownDiv').show();
        },
        function() {
            $(this).find('.dropdownDiv').hide();
        }
    );
}
	
	