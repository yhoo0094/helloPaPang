/**
 * @작성자: 김상민
 * @생성일: 2022. 11. 8. 오후 6:51:35
 * @설명: js 유틸
**/

var $util = {};
 
 /*
필수값 입력 여부 점검
return: true/false
option: {
	group : [] - 검사 대상 그룹 목록 정의. "all0", "least1" 등의 형식으로 그룹 지정 가능. all = 해당그룹 모두 입력, least = 해당 그룹 중 하나 이상 입력 
	target : [] - 해당 태그만 검사
}
*/
$util.checkRequired = function(option){
	//해당 객체 없을 경우 빈 값 만들기
	option = option || {};
	option.target = option.target || [];
	option.group = option.group || [];
	
	if(option.group.length > 0){
		for(i = 0; i < option.group.length; i++){
			var grp = option.group[i];
			var selector = '';
			
			//제이쿼리 설렉터 구현
			if(option.target.length > 0){
				for(k = 0; k < option.target.length; i++){
					selector = selector + option.target[k] + "[required=" + grp + "] "
				};				
			} else {
				selector = "[required=" + grp + "]"
			}
			
			if(grp.indexOf("all") >= 0){ 
				console.log($(selector)); //여기부터 구현
			} else if (grp.indexOf("least") >= 0){
				
			};
		};
	}
}	


$util.isEmpty = function(obj){
	if(obj == null || obj == undefined || obj == "" || obj == empty){
		return true;
	} else {
		return false;
	}
};	