/**
 * @작성자: 김상민
 * @생성일: 2022. 11. 8. 오후 6:51:35
 * @설명: 페이지 공통 js
**/

var $com = {};

//로딩패널 보이기
$com.loadingStart = function(){
	$('#loadingPanel').css('display','flex');	
};

//로딩패널 숨기기
$com.loadingEnd = function(){
	$('#loadingPanel').css('display','none');	
};