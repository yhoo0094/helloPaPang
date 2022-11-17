//회원가입
function signUp(){
	if(!$util.checkRequired({group:["all1"]})){return;};
	
	//아이디 입력 형식 체크(추후 구현)
	
	//비밀번호 입력 형식 체크(추후 구현)
	
	var formData = $('#signUpForm').serialize();
    $.ajax({
        url: '/user/signUp.do',
        type: 'POST',
        data: formData,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
        dataType: 'json',
        success: function (result) {
            if (result.RESULT == Constant.RESULT_SUCCESS){
                // 데이타 성공일때 이벤트 작성
                alert("회원가입이 완료되었습니다.")
                location.href = "/"
            } else {
				alert(Constant.OUT_RESULT_MSG)
			}
        }
    });
}