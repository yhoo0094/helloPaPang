/**
 * @화면명: 로그인 모달 
 * @작성자: 김상민
 * @생성일: 2022. 11. 8. 오전 7:53:55
 * @설명: 로그인 정보 입력 모달
**/

$(()=>{
	
})

//에디터 생성
function createEditor(){
    ClassicEditor
        .create( document.querySelector( '#noticeEditor' ),{
	        plugins: [ SimpleUploadAdapter],
	        toolbar: [],
	        simpleUpload: {
	            // The URL that the images are uploaded to.
	            uploadUrl: 'http://localhost:8080\resources\images\editor\example.jpg',
	
	            // Enable the XMLHttpRequest.withCredentials property.
	            withCredentials: true,
	
	            // Headers sent along with the XMLHttpRequest to the upload server.
	            headers: {
	                'X-CSRF-TOKEN': 'CSRF-Token',
	                Authorization: 'Bearer <JSON Web Token>'
	            }
	        }			
		} )
        .catch( error => {
            console.error( error );
        } );
}

//공지사항 팝업 열기
function noticeModalOpen(data){
	//createEditor();modal('open')
	if(data == null){
		noticeModalEmpty()
	} else {
		$('#title').val(data.BOARD_TITLE);
		$('#content').val(data.BOARD_CN);
		$('#bizId').val(data.BIZ_ID);
		selectFile(data);
	}
	$('#noticeModal').modal({
		clickClose: false
	});	
}

//공지사항 팝업 비우기
function noticeModalEmpty(){
	$('#title').val('');
	$('#content').val('');
	$('#bizId').val('');
	resetFile();
}

//공지사항 저장
function saveNotice(){
	var formData = new FormData($("#noticeForm")[0]);
	
	var url;    
    if($('#bizId').val() == ''){
		url = '/notice/insertNotice.do';
	} else {
		url = '/notice/updateNotice.do';
	}
	
	//파일첨부가 포함된 글 저장
	saveFile(url, formData).then(function(result){
        if (result.RESULT == Constant.RESULT_SUCCESS){
            // 데이타 성공일때 이벤트 작성
            alert("완료되었습니다.");
            $('.jquery-modal').fadeOut();
        } else {
			alert(result.Constant.OUT_RESULT_MSG)
		}		
	});
}	