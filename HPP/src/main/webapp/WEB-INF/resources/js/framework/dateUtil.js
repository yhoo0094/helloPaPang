/**
 * @작성자: 김상민
 * @생성일: 2022. 11. 8. 오후 6:51:35
 * @설명: date 유틸
**/

var $dateUtil = {};
 
/**
 * 날짜 계산
 * @param strDate 날짜(yyyymmdd)
 * @param year 연도
 * @param month 월
 * @param day 일
 * @return yyyymmdd 계산 결과(yyyymmdd)
 */
$dateUtil.addDate = function(strDate, year, month, day){
	//strDate = strDate.replace(/(\d{4})(\d{2})(\d{2})/g, '$1-$2-$3');
	
	var originYear = strDate.substr(0, 4);
	var originMonth = strDate.substr(4, 2);
	var originDay = strDate.substr(6, 2);
	
	var date = new Date(parseInt(originYear) + parseInt(year)
						, parseInt(originMonth) + parseInt(month) - 1
						, parseInt(originDay) + parseInt(day)
						);

    var year = date.getFullYear();
    var month = ("0" + (1 + date.getMonth())).slice(-2);
    var day = ("0" + date.getDate()).slice(-2);						
	return year + month + day;
};

/**
 * 오늘 날짜(yyyymmdd)
 * @return yyyymmdd 오늘 날짜
 */
$dateUtil.todayYYYYMMDD = function(){
	var date = new Date();
    var year = date.getFullYear();
    var month = ("0" + (1 + date.getMonth())).slice(-2);
    var day = ("0" + date.getDate()).slice(-2);						
	return year + month + day;	
}


$dateUtil.secondToHour = function(origSecond){
	var hour = parseInt(origSecond/3600);
	var minute = parseInt((origSecond%3600)/60);
	var second = parseInt((origSecond%3600)%60);
	var result = ("0" + hour).slice(-2) + ":" + ("0" + minute).slice(-2) + ":" + ("0" + second).slice(-2)
	return result;
}

/**
 * yyyymmdd를 yyyy-mm-dd로 변경
 * @param strDate 날짜(yyyymmdd)
 * @return yyyy-mm-dd
 */
$dateUtil.dateHyphen = function(strDate){
	return strDate.replace(/(\d{4})(\d{2})(\d{2})/g, '$1-$2-$3');
}