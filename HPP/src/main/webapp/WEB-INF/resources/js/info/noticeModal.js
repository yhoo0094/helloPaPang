/**
 * @화면명: 로그인 모달 
 * @작성자: 김상민
 * @생성일: 2022. 11. 8. 오전 7:53:55
 * @설명: 로그인 정보 입력 모달
**/

$(()=>{
	
})

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

//로그인 팝업 열기
function noticeModalOpen(){
	//createEditor();
	$('#noticeModal').modal('open')	
}
	