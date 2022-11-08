//회원가입
function signUp(){
	
	$util.checkRequired({group:["all1"]});
	return;
	
	var formData = $('#signUpForm').serialize();
    $.ajax({
        url: '/user/signUp.do',
        type: 'POST',
        data: formData,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
        dataType: 'json',
        success: function (result) {
            if (result){
                // 데이타 성공일때 이벤트 작성
            }
        }
    });
}