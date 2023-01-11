/**
 * @화면명: 로그인 모달 
 * @작성자: 김상민
 * @생성일: 2022. 11. 8. 오전 7:53:55
 * @설명: 로그인 정보 입력 모달
**/


//로그인 팝업 열기
function loginModalOpen(){
	//아이디 저장 여부 확인
	if($util.getCookie('hpp_save_id')){
		$('#userIdModal').val($util.getCookie('hpp_user_id'));
		$('#rememberIdChk').prop("checked", true);
	}
	
	//로그인 모달 열기
	$('#loginModal').modal({
		clickClose: false
	});		
}	

//로그인
function login(){
	//필수입력 검증
	if(!$util.checkRequired({group:["allM1"]})){return;};
	
	//아이디 저장 여부 확인
	if($('#rememberIdChk').is(":checked")){
		$util.setCookie('hpp_user_id', $('#userIdModal').val());
		$util.setCookie('hpp_save_id', true);
	} else {
		$util.setCookie('hpp_user_id', '');
		$util.setCookie('hpp_save_id', false);		
	};
	
	var formData = $('#loginForm').serialize();
	$com.loadingStart();
    $.ajax({
        url: '/user/login.do',
        type: 'POST',
        data: formData,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
        dataType: 'json',
        success: function (res, textStatus, jqXHR) {
			$com.loadingEnd();
	        if (res.RESULT == Constant.RESULT_SUCCESS){
	            loginModalClose();
	            //$('#loginModalbtn').css('display', 'none');
	            
	            //비밀번호 유효기간이 만료된 경우
	            var obj = $util.getObjFromArr(res.userPoli, 'POLI_NM', 'PSWD_LIM_DAYS');	//비밀번호 변경 주기 객체
	            var pswdLimDays = obj['POLI_VAL'];	//비밀번호 변경 주기(일)
	            var pswdLimDate = $dateUtil.addDate(res.loginInfo.PW_CH_DTTI, 0, 0, pswdLimDays);	//비밀번호 유효 날짜(yyyymmdd)
	            if(pswdLimDate - $dateUtil.todayYYYYMMDD() < 0){
					alert('비밀번호 변경 후 ' + pswdLimDays + '일 이상 경과하였습니다.\n계정 보호를 위해 비밀번호를 변경해 주십시오.');
					//비밀번호 변경 모달 띄우기(추후 구현)
				}
				
				location.reload();
	        } else {
				alert(res[Constant.OUT_RESULT_MSG])
			}
        },
        error: function(textStatus, jqXHR, thrownError){
			$com.loadingEnd();
		}
    });		
}

//로그아웃
function loginOut() {
	if(!confirm("정말 로그아웃 하시겠습니까?")){
		return;
	}
	
    $.ajax({
        url: '/user/logout.do',
        type: 'POST',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
        dataType: 'json',
        success: function (result) {
	        if (result.RESULT == Constant.RESULT_SUCCESS){
	            location.replace('/');
	        } else {
				alert(result[Constant.OUT_RESULT_MSG])
			}
        }
    });		
}

//모달 닫기
function loginModalClose(){
	$.modal.close();
	
	//모달 내용 초기화
	var el = $('#loginModal');
	$util.inputTextEmpty(el, 'text');
	$util.inputTextEmpty(el, 'password');
}