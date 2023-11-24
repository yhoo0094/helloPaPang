/**
 * @화면명: 자유게시판 조회
 * @작성자: KimSangMin
 * @생성일: 2023. 11. 23. 오후 7:01:06
 * @설명: 자유게시판 등록/조회/수정 화면 
**/

var edit;
$(()=>{
	createEditor('.editor').then( newEditor => {
			edit = watchdog.editor
	} );
	
	$util.getCodeForSelectTag('BOARD_FREE_CODE', 'boardFreeCode');
})