$(()=>{
	selectUser();
})

function selectUser(){
    $.ajax({
        url: '/user/selectUser.do',
        type: 'POST',
        data: '',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
        dataType: 'json',
        success: function (result) {
                console.log(result);
        }
    });		
}	

function insertUserInfo(){
	var formData = $('#userInfoForm').serialize()
    $.ajax({
        url: '/user/insertUser.do',
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