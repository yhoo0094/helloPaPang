/**
 * @화면명: 파일첨부 Div
 * @작성자: 김상민
 * @생성일: 2022. 11. 17. 오후 7:28:00
 * @설명: 파일첨부 Div
**/

var fileNo = 0;
var filesArr = new Array();
var delFiles = new Array();

//첨부파일 추가
function addFile(obj){
    var maxFileCnt = 5;   // 첨부파일 최대 개수
    var attFileCnt = document.querySelectorAll('.filebox').length;    // 기존 추가된 첨부파일 개수
    var curFileCnt = obj.files.length;  // 현재 선택된 첨부파일 개수
 
    // 첨부파일 개수 확인
    if (curFileCnt > maxFileCnt - attFileCnt) {
        alert("첨부파일은 " + maxFileCnt + "개 까지 첨부 가능합니다.");
        return;
    }    
    
    for (const file of obj.files) {
	    // 첨부파일 검증
	    if (validation(file)) {
	        // 파일 배열에 담기
	        var reader = new FileReader();
	        reader.onload = function () {
	            filesArr.push(file);
	        };
	        reader.readAsDataURL(file);
	
	        // 목록 추가
	        let htmlData = '';
	        htmlData += '<div id="file' + fileNo + '" class="filebox">';
	        htmlData += '   <p class="attachedFile">' + file.name + ' (' + formatBytes(file.size) + ')</p>';
	        htmlData += '   <a class="delete" onclick="deleteFile(' + fileNo + ');"><i class="far fa-minus-square"></i></a>';
	        htmlData += '</div>';
	        $('.fileListDiv').append(htmlData);
	        fileNo++;
	    } else {
	        continue;
	    }
    }
    //초기화
    document.querySelector("input[type=file]").value = "";   
}

//첨부파일 삭제
function deleteFile(num) {
    document.querySelector("#file" + num).remove();
    filesArr[num].is_delete = true;
}

//첨부파일 초기화
function resetFile() {
	fileNo = 0;
	filesArr = new Array();	
	$('.filebox').remove();
}

//첨부파일 조회
function selectFile(data) {
	resetFile();	//첨부파일 초기화
	
    $.ajax({
        url: '/file/selectFile',
        type: 'POST',
        data: data,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
        dataType: 'json',
        success: function (result) {
            //권한에 따라 수정 가능 여부 추후 구현
            
            //파일 리스트 그리기
            for(var i in result.list){
				var fileData = result.list[i];
				
				fileData.is_delete = false;	//파일삭제 여부
				filesArr.push(fileData);
				
		        // 목록 추가
		        let htmlData = '';
		        htmlData += '<div id="file' + fileNo + '" class="filebox">';
		        htmlData += '   <p class="attachedFile" onclick="downloadFile(' + fileData.BIZ_ID + ',' + fileData.ATCFILE_SEQ + ');">' + fileData.ATC_FILE_NM + ' (' + formatBytes(fileData.ATC_FILE_CAPA_VAL) + ')</p>';
		        htmlData += '   <a class="delete" onclick="deleteFile(' + fileNo + ');"><i class="far fa-minus-square"></i></a>';
		        htmlData += '</div>';
		        $('.fileListDiv').append(htmlData);
		        fileNo++;					
			}
        }
    });		
}

//첨부파일을 포함한 페이지 저장
function saveFile(url, formData){
	return new Promise(function(resolve, reject){
	    /*
	    for (var i = 0; i < filesArr.length; i++) {
	        formData.append("files", filesArr[i]);
	    }	
	    */
	    
	    for(var i in filesArr){
			formData.append("files", filesArr[i]);
			
			//삭제된 파일 처리(undefinded면 false로 처리됨)
			if(filesArr[i].is_delete){
				delFiles.push(filesArr[i].ATCFILE_SEQ);
			};
		}
		formData.append("delFiles", delFiles);
	    
	    $.ajax({
			type: 'POST',
			enctype: 'multipart/form-data',
	        url: url,
	        data: formData,
	        processData: false,
	        contentType: false,
	        cache: false, 
	        success: function (result) {
				resolve(result);
	        }
	    });   
    })
}

//첨부파일 다운로드
function downloadFile(BIZ_ID, ATCFILE_SEQ){
    $("[id='downloadForm']").remove();	//이미 생성된 form이 있으면 제거
    
    //form 생성
    var form = document.createElement("form");
    form.id = 'downloadForm';
    form.action = '/file/downloadFile';
    form.method = 'post';
    document.body.appendChild(form);
    
    //input 생성
    var bizId = document.createElement("input");
    bizId.type = "text";
    bizId.name = "BIZ_ID";
    bizId.value = BIZ_ID;
    form.appendChild(bizId);
 
    var atcfileSeq = document.createElement("input");
    atcfileSeq.type = "text";
    atcfileSeq.name = "ATCFILE_SEQ";
    atcfileSeq.value = ATCFILE_SEQ;
    form.appendChild(atcfileSeq);
    form.submit();
    
    $("[id='downloadForm']").remove();	
}

//첨부가능한 파일 타입
const fileTypes = [
	'application/pdf'
  , 'image/gif'
  , 'image/jpeg'
  , 'image/png'
  , 'image/bmp'
  , 'image/tif'
  , 'application/haansofthwp'
  , 'application/x-hwp'
  , 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'
  , 'text/plain'
];

/* 첨부파일 검증 */
function validation(obj){
    if (obj.name.length > 100) {
        alert("파일명이 100자 이상인 파일은 제외되었습니다.");
        return false;
    } else if (obj.size > (100 * 1024 * 1024)) {
        alert("최대 파일 용량인 100MB를 초과한 파일은 제외되었습니다.");
        return false;
    } else if (obj.name.lastIndexOf('.') == -1) {
        alert("확장자가 없는 파일은 제외되었습니다.");
        return false;
    } else if (!fileTypes.includes(obj.type)) {
        alert("첨부가 불가능한 파일은 제외되었습니다.");
        return false;
    } else {
        return true;
    }
}

//첨부파일 사이즈 단위 변경
function formatBytes(bytes){
	var sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB'];
	if(bytes == 0) return '0 Bytes';
	var i = parseInt(Math.floor(Math.log(bytes) / Math.log(1024)));
	return Math.round(bytes / Math.pow(1024, i), 2) + ' ' + sizes[i];
}