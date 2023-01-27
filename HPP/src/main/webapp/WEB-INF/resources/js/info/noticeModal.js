/**
 * @화면명: 로그인 모달 
 * @작성자: 김상민
 * @생성일: 2022. 11. 8. 오전 7:53:55
 * @설명: 로그인 정보 입력 모달
**/

$(()=>{
	
})

//공지사항 팝업 열기
function noticeModalOpen(data){
	//createEditor();modal('open')
	if(data != null){
		//기존 입력에 대한 조회
		$('#boardSeq').val(data.boardSeq);			//공지사항일련번호
		$('#noticeTitle').val(data.noticeTitle);	//공지사항제목
		noticeCn.setData(data.noticeCn);			//공지사항내용
		$('#noticeStrDt').val(data.noticeStrDt.replace(/(\d{4})(\d{2})(\d{2})/g, '$1-$2-$3'));	//공지사항게시시작일
		$('#noticeEndDt').val(data.noticeEndDt.replace(/(\d{4})(\d{2})(\d{2})/g, '$1-$2-$3'));	//공지사항게시종료일
		(data.noticePopYn == 'Y')? $('#noticePopY').prop('checked','checked') : $('#noticePopN').prop('checked','checked');	//공지사항팝업여부
		
		data.boardCode = '01';			//게시판구분코드(01:공지사항,02:자유게시판,03:질문게시판,04:지역게시판)
		data.boardSeq = data.boardSeq;	//게시글일련번호
		$fileUtil.selectFile(data);		//첨부파일 조회
	} else {
		//모달 내용 초기화
		resetModal();		
	}
	$('#noticeModal').modal({
		clickClose: false
	});	
}

//공지사항 저장
function saveNotice(){
	var formData = new FormData($("#noticeForm")[0]);
	
	//날짜 하이픈(-) 제거
	formData.set('noticeStrDt',$('#noticeStrDt').val().replace(/-/g,''));
	formData.set('noticeEndDt',$('#noticeEndDt').val().replace(/-/g,''));
	
	//에디터 내용 저장
	formData.set('noticeCn',noticeCn.getData());
	
	var url;    
    if($util.isEmpty($('#boardSeq').val())){
		url = '/notice/insertNotice.do';
	} else {
		url = '/notice/updateNotice.do';
	}
	
	//파일첨부가 포함된 글 저장
	$fileUtil.saveFile(url, formData).then(function(result){
        if (result.RESULT == Constant.RESULT_SUCCESS){
            // 데이타 성공일때 이벤트 작성
            alert("완료되었습니다.");
            location.reload();
        } else {
			alert(result[Constant.OUT_RESULT_MSG])
		}		
	});
}	

//모달 닫기
function closeModal(){
	$.modal.close();
	
	//모달 내용 초기화
	resetModal();
	$fileUtil.resetFile();
}

//모달 내용 초기화
function resetModal(){
	var today = new Date();
	document.getElementById('noticeStrDt').valueAsDate = today	//게시시작일 기본값 = 오늘 날짜
	document.getElementById('noticeEndDt').valueAsDate = new Date(today.setDate(today.getDate() + 7));	//게시종료일 기본값 = 일주일 후

	var el = $('#noticeModal');
	$util.inputTypeEmpty(el, 'text');
	
	noticeCn.setData('');			//공지사항내용
}

//게시글 삭제
function deleteBoard(){
		if(!confirm('정말로 삭제 하시겠습니까?')){
			return;
		};
		
		var formData = new FormData($("#noticeForm")[0]);
	
	    $.ajax({
			type: 'POST',
			enctype: 'multipart/form-data',
	        url: '/notice/deleteNotice.do',
	        data: formData,
	        processData: false,
	        contentType: false,
	        cache: false, 
	        success: function (result) {
	            if (result.RESULT == Constant.RESULT_SUCCESS){
	                alert("삭제가 완료되었습니다.")
	                closeModal();
	            } else {
					alert(Constant.OUT_RESULT_MSG)
				}
	        }
	    });  	
}
