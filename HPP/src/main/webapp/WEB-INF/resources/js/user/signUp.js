//회원가입
function insertUser(){
	if(!$util.checkRequired({group:["all1"]})){return;};
	
	//아이디 유효성 검증
	//if(!idValidation()){return;}
	
	//비밀번호 유효성 검증
	if(!pwValidation()){return;}
	
	var formData = $('#signUpForm').serialize();
    $.ajax({
        url: '/user/insertUser.do',
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

//아이디 유효성 검증
function idValidation(value){
	
}


//비밀번호 유효성 검증
function pwValidation(){
	var result;	//처리 결과
	var value = $('#userPw').val();
	
	//조건: 숫자, 영어, 특수문자를 포함하여 8글자 이상
	var allChk = /^(?=.*\d)(?=.*[A-Za-z])(?=.*[~!@#\$%\^&\*()_\+\-={}\[\]\\:;"'<>,.\/]).{8,20}$/;
	var numChk = /\d/gim;		//숫자 포함
	var enChk = /[A-Za-z]/gim;	//영어 포함
	var speChaChk = /[~!@#\$%\^&\*()_\+\-={}\[\]\\:;"'<>,.\/]/gim;	//특수문자 포함
	var lenChk = /.{8,}$/gim;	//최소 길이
	var maxLenChk = /.{,50}$/gim;	//최대 길이
	
	if(allChk.test(value)){ //비밀번호 입력 조건 검증
		if(value == $('#userPwChk').val()){ //비밀번호와 비밀번호 확인이 같은지 검증
			result = true;
		} else {
			alert('비밀번호와 비밀번호 확인이 일치하지 않습니다.');
			result = false;
		}
	} else {
		if(!numChk.test(value)){
			alert('비밀번호에 숫자가 포함되지 않았습니다.');
		} else if(!enChk.test(value)) {
			alert('비밀번호에 영어가 포함되지 않았습니다.');
		} else if(!speChaChk.test(value)) {
			alert('비밀번호에 특수문자가 포함되지 않았습니다.');
		} else if(!lenChk.test(value)) {
			alert('비밀번호의 길이가 8글자보다 길어야합니다.');
		} else if(!maxLenChk.test(value)) {
			alert('비밀번호의 최대 길이는 50글자입니다.');
		} 
		result = false;				
	}
	
	return result;
}

//아이디 중복 확인
function chkUniqId(){
	var userId = $('#userId').val();
	
	//유효성 검사
	if($util.isEmpty(userId)){
		alert('아이디가 입력되지 않았습니다.')
		return;
	}
	
    $.ajax({
        url: '/user/chkUniqId.do',
        type: 'POST',
        data: {userId : userId},
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
        dataType: 'json',
        success: function (result) {
            if (result.RESULT == Constant.RESULT_SUCCESS){
				if(result.data == null){
					alert("아이디를 사용할 수 있습니다.");
				} else {
					alert("중복된 아이디입니다.");
				}
            } else {
				alert(Constant.OUT_RESULT_MSG)
			}
        }
    });	
}
