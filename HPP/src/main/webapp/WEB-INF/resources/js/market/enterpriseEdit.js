/**
 * @화면명: 자유게시판 조회
 * @작성자: KimSangMin
 * @생성일: 2023. 11. 23. 오후 7:01:06
 * @설명: 자유게시판 등록/조회/수정 화면 
**/

const curUrl = new URL(window.location.href);
const curParams = new URLSearchParams(curUrl.search);
const entMarketSeq = curParams.get('entMarketSeq');

$(()=>{
	$editorUtil.createEditor('cn');
	
	pageInit();	//권한 및 조회/등록 목적에 따른 버튼, 내용 표시 여부 조정
})

//권한 및 조회/등록 목적에 따른 버튼, 내용 표시 여부 조정 
function pageInit(){
	if($util.isEmpty(entMarketSeq)){
		//entMarketSeq 변수가 null이면 신규 등록
		chViewMode('01');		//화면 모드 바꾸기(01: 등록, 02: 수정, 03: 조회)
		thumbnailPreview();		//등록 이미지 미리보기
		clickThumbnail();		//썸네일 이미지 클릭
	} else {
		//데이터 조회해서 작성자와 id가 같으면 수정 모드
		$.ajax({
	        url: '/enterprise/selectEnterprise.do',
	        type: 'POST',
	        data: {boardSeq: entMarketSeq},
	        contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
	        dataType: 'json',
	        success: function (result) {
				let data = result.OUT_DATA[0];
				data = $util.XssReverseObj(data);	//XSS방지를 위한 문자열 변환 되돌리기

				//데이터 조회
				for (let key in data) {
				    let input = document.getElementById(key);
				    if (input) {
				        input.value = data[key];
				    }
				}
				edit.setData(data.cn); //에디터 조회
				
				chViewMode('03');	//화면 모드 바꾸기(01: 등록, 02: 수정, 03: 조회)
				
				if($com.getUserInfo('userId') == data.fstRegId){	
					//작성자ID와 조회ID가 같을 경우 -> 수정
					chViewMode('02');	//화면 모드 바꾸기(01: 등록, 02: 수정, 03: 조회)
				} else {
					
				}
				
				//첨부파일 조회
				data.boardCode = '02';								//게시판구분코드(01:공지사항,02:자유게시판,03:질문게시판,04:지역게시판)
				$fileUtil.selectFile(data);							//첨부파일 조회
	        }
	    });
	}
}

//화면 모드 바꾸기
function chViewMode(type){
	switch(type){ 
		case('01'):	//등록
			$('#saveBtn').css('display','inline-block');
			$('#modifyBtn').css('display','none');
			$('#delBtn').css('display','none');
			$('#cnByteDisplay').css('display','inline-block');
			$('#cardImgMsg').show();	//'썸네일을 선택하세요.' 보이기
			break;
		case('02'):	//수정
			$('#saveBtn').css('display','none');
			$('#modifyBtn').css('display','inline-block');
			$('#delBtn').css('display','inline-block');
			$('#cnByteDisplay').css('display','inline-block');	 
			break;
		case('03'):	//조회
			$('#saveBtn').css('display','none');
			$('#modifyBtn').css('display','none');
			$('#delBtn').css('display','none');	 
			
			$('#freeBoardForm .form-control').attr('readonly','readonly');		//readonly 적용
			$('#freeBoardForm select').attr('disabled',true);					//disabled 적용
			edit.enableReadOnlyMode('Y');										//에디터 readonly 적용
			break;		
		default:
			break;
	}
}

//썸네일 이미지 클릭
function clickThumbnail(){
	$('#thumbnailImg, #cardImgMsg').on({
		click: function(){
			$('#thumbnail').click()
		}
	})	
}

//등록 이미지 미리보기
function thumbnailPreview(){
	document.getElementById('thumbnail').addEventListener('change', function(event) {
		$('#cardImgMsg').hide();	//'썸네일을 선택하세요.' 숨기기
		
	    const file = event.target.files[0];
	    if (file) {
	        const reader = new FileReader();
	
	        reader.onload = function(e) {
	            const img = document.getElementById('thumbnailImg');
	            img.src = e.target.result;
	            img.style.display = 'block';
	        };
	
	        reader.readAsDataURL(file);
	    }
	});
}

//저장
function saveBtnClick(){
	//유효성 검사
	if(!$util.checkRequired({group:["all1"]})){return;};
	if($util.isEmpty(edit.getData())){
		alert("내용이 입력되지 않았습니다.");
		$('#cn').focus();
		return;
	}; 
	
	var formData = new FormData($("#viewForm")[0]);
	
	// input 태그에서 파일을 가져와서 FormData 객체에 추가
    var fileData = $('#thumbnail').prop('files')[0];
    formData.append('image', fileData);	
	
	//에디터 내용 저장
	formData.set('cn',edit.getData());	
	
	var url;    
    if($util.isEmpty(entMarketSeq)){
		if(fileData == undefined){
			alert("썸네일이 선택되지 않았습니다.");
			$('#thumbnail').click();
			return;
		}
		url = '/enterprise/insertEnterprise.do';
	} else {
		url = '/enterprise/updateEnterprise.do';
	}
	
    $.ajax({
		type: 'POST',
		enctype: 'multipart/form-data',
        url: url,
        data: formData,
        processData: false,	// 데이터를 문자열로 변환하지 않음
        contentType: false,	// 기본 컨텐트 타입 설정 해제
        cache: false, 
        success: function (result) {
	        if (result.RESULT == Constant.RESULT_SUCCESS){
	            alert("완료되었습니다.");
	            
	            //수정 화면으로 이동
	            window.location.href = contextPath + '/market/enterprise/enterpriseView?entMarketSeq=' + result.OUT_DATA.entMarketSeq;
	        } else {
				alert(result[Constant.OUT_RESULT_MSG])
			}	
        }
    });	
}

//돌아가기
function moveList(){
	window.location.href = '/market/enterprise';
}