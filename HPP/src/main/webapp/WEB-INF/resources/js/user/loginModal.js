/**
 * @화면명: 로그인 모달 
 * @작성자: 김상민
 * @생성일: 2022. 11. 8. 오전 7:53:55
 * @설명: 로그인 정보 입력 모달
**/

//로그인 팝업 열기
function loginModalOpen(){
	$('#loginModal').modal({
		clickClose: false
	});		
}	

//로그인
function login(){
	var formData = $('#loginForm').serialize();
	
	//필수입력 검증(추후 구현)
	
    $.ajax({
        url: '/user/login',
        type: 'POST',
        data: formData,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
        dataType: 'json',
        success: function (result) {
                console.log(result);
        }
    });		
	
}