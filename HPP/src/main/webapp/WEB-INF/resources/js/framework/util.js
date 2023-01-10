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
	group : [] - 검사 대상 그룹 목록 정의. "all0", "least1" 등의 형식으로 그룹 지정 가능. all = 해당 그룹 모두 입력 필요, least = 해당 그룹 중 적어도 하나 입력 필요
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
			var selectTags = $(selector);
			
			if(grp.indexOf("all") >= 0){	//모두 입력 필요
				for(k = 0; k < selectTags.length; k++){
					if($util.isEmpty($(selectTags[k]).val())){
						alert(selectTags[k].title + "이(가) 입력되지 않았습니다.")
						$(selectTags[k]).focus();
						return false;
					}
				}
				return true;
			} else if (grp.indexOf("least") >= 0){	//적어도 하나 입력 필요
				var tagTitles = "";	//대상 태그 타이틀 변수 저장
				for(k = 0; k < selectTags.length; k++){
					if($util.isEmpty($(selectTags[k]).val())){
						if(tagTitles == ""){
							tagTitles = selectTags[k].title
						} else {
							tagTitles = tagTitles + ", " + selectTags[k].title
						}
					} else {
						return true;
					}
				}
				alert(tagTitles + " 중 적어도 하나는 입력되어야 합니다.")
				$(selectTags[0]).focus();
				return false;				
			};
		};
	}
}	

//빈 값 여부 확인
$util.isEmpty = function(obj){
	if(obj == null || obj == undefined || obj == ""){
		return true;
	} else {
		return false;
	}
};	

/**
 * element 하위 input의 값 비우기
 * @param el 범위 element
 * @param type 대상 input 타입
 */
$util.inputTextEmpty = function(el, type){
	$(el).find('input[type="' + type + '"]').val('');
};

/**
 * 쿠키 생성
 * @param name 쿠키 이름
 * @param value 쿠키 값
 * @param days 쿠키 보존 기간
 */
$util.setCookie = function(name, value, days){
	var expires = "";
	if(days){
		var date = new Date();
		date.setTime(date.getTime() + (days*24*60*60*1000));
		expires = "; expires=" + date.toUTCString();
	}
	document.cookie = name + "=" + value + expires + "; path=/";
}

/**
 * 쿠키 조회
 * @param name 쿠키 이름
 * @return value 쿠키 값
 */
$util.getCookie = function(name){
	var value = document.cookie
	  .split('; ')
	  .find((row) => row.startsWith(name))
	  ?.split('=')[1];	
	return value;
}

/**
 * 배열(Array)에서 객체(object) 가져오기
 * @param arr 배열(array)
 * @param key 키
 * @param val 값(value)
 * @return obj 객체(object)
 */
$util.getObjFromArr = function(arr, key, val){
	var obj;
	
	for(i in arr){
		if(val == (arr[i][key])){
			obj = arr[i];
		}
	}
	
	return obj;
}
