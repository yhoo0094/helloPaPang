/**
 * @작성자: 김상민
 * @생성일: 2022. 11. 8. 오후 6:51:35
 * @설명: 다양한 프레임워크에서 큰 제약 없이 사용 가능한 js 기능 모음
**/

var $util = {};
 
/**
 * 필수값 입력 여부 점검
 * @param option {group : []} 일 때 - 검사 대상 그룹 목록 정의. "all0", "least1" 등의 형식으로 그룹 지정 가능. all = 해당 그룹 모두 입력 필요, least = 해당 그룹 중 적어도 하나 입력 필요
 				 {target : []} 일 때 - 해당 태그만 검사
 * @return boolean
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
			
			//제이쿼리 설렉터
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

/**
 * 빈 값 여부 확인(boolean 반환)
 * @param obj 오브젝트
 * @return boolean
 */
$util.isEmpty = function(obj){
	//string이면 공백 제거
	if(typeof(obj) == 'string'){obj = obj.trim();};
	
	if(obj == null || obj == undefined || obj == ""){
		return true;
	} else {
		return false;
	}
};

/**
 * 두 개의 텍스트가 같은지 확인(대소문자 구분 X)
 * @param val1 텍스트
 * @param val2 텍스트 
 * @return boolean
 */
$util.isSameText = function(val1, val2){
	if(val1.trim().toLowerCase() == val2.trim().toLowerCase()){
		return true;
	} else {
		return false;
	}
}

/**
 * element 하위 input의 값 비우기
 * @param el 범위 element
 * @param type 대상 input 타입
 */
$util.inputTypeEmpty = function(el, type){
	$(el).find('input[type="' + type + '"]').val('');
};

/**
 * 쿠키 생성
 * @param name 쿠키 이름
 * @param value 쿠키 값
 * @param days 쿠키 보존 기간
 */
$util.setCookie = function(name, value, days){
	var expires = 360;
	if(days){
		expires = days; 
	}
	var date = new Date();
	date.setTime(date.getTime() + (expires*24*60*60*1000));
	expires = date.toUTCString();
	document.cookie = name + "=" + value + "; expires=" + expires + "; path=/";
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
 * 쿠키에 값 추가하기
 * @param name string - 쿠키 이름
 * @param value string - 추가할 값
 * @param days number - 쿠키 보존 기간(일)
 */
$util.addToCookie = function(name, value, days) {
    var cookieValue = $util.getCookie(name);
    var cookieArray = cookieValue ? cookieValue.split(',') : [];
    if (cookieArray.indexOf(value) === -1) {
        cookieArray.push(value);
        $util.setCookie(name, cookieArray.join(','), days); // 1일 유지
    }
}

/**
 * 쿠키에 값 제거하기
 * @param name string - 쿠키 이름
 * @param value string - 제거할 값
 * @param days number - 쿠키 보존 기간(일)
 */
$util.rmFromCookie = function(name, value, days) {
    var cookieValue = $util.getCookie(name);
    var cookieArray = cookieValue ? cookieValue.split(',') : [];
    var index = cookieArray.indexOf(value);
    if (index !== -1) {
        cookieArray.splice(index, 1);
        $util.setCookie(name, cookieArray.join(','), days); // 1일 유지
    }
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

/**
 * Xss 방지를 위한 텍스트 변환
 * @param param String
 * @return String
 */
$util.XssReplace = function(param) {
		param = param.replaceAll("&", "&amp;");
		param = param.replaceAll("\"", "&quot;");
		param = param.replaceAll("'", "&apos;");
		param = param.replaceAll("<", "&lt;");
		param = param.replaceAll(">", "&gt;");
		param = param.replaceAll("\r", "<br>");
		param = param.replaceAll("\n", "<p>");

		return param;	
}

/**
 * XSS방지를 위한 문자열 변환 되돌리기
 * @param param String
 * @return String
 */
$util.XssReverse = function(param) {
		param = param.replaceAll("<p>", "\n");
		param = param.replaceAll("<br>", "\r");
		param = param.replaceAll("&gt;", ">");
		param = param.replaceAll("&lt;", "<");
		param = param.replaceAll("&apos;", "'");
		param = param.replaceAll("&quot;", "\"");
		param = param.replaceAll("&amp;", "&");
		return param;	
}

/**
 * object에 대해 XSS방지를 위한 문자열 변환 되돌리기
 * @param param object
 * @return object
 */
$util.XssReverseObj = function(obj) {
	for(key in obj){
		if(typeof(obj[key]) == 'string'){
			obj[key] = $util.XssReverse(obj[key]);
		}	
	}
	return obj;	
}

/**
 * url에 포함된 파라미터 값 가져오기
 * @param name string 파라미터명
 * @return string 파라미터값
 */
$util.getParameterByName = function getParameterByName(name) {
	var url = window.location.href
    name = name.replace(/[\[\]]/g, '\\$&');
    const regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
          results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, ' '));
}