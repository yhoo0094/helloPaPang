<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
/**
 * @화면명: 요청 로그 조회 
 * @작성자: KimSangMin
 * @생성일: 2023. 1. 30. 오후 2:25:23
 * @설명: 클라이언트에서 서버로 넘어오는 요청관련 로그 조회
**/
 %>
<div>
	<%@include file="/WEB-INF/views/com/menuInfo.jsp" %>
	<div class="searchDiv">
		<form action="#">
			<table>
				<tr>
					<th>발생일시:</th>
					<td>
						<input id="datetimepicker" type="text" >
						<input id="reqDttiStr" class="" name="reqDttiStr" title="발생일시" type="datetime-local" required="all1"> ~ 
						<input id="reqDttiEnd" class="" name="reqDttiEnd" title="발생일시" type="datetime-local" required="all1">
					</td>	
					<th>아이디:</th>
					<td><input id="userId" class="" name="userId" title="아이디" type="text" maxlength="20"></td>
					<th>아이피:</th>
					<td><input id="userIp" class="" name="userIp" title="아이피" type="text" maxlength="39"></td>
					<td rowspan="3"><button>검색</button></td>
				</tr>
				<tr>
					<th>URI:</th>
					<td><input id="reqUri" class="" name="reqUri" title="URI" type="text" maxlength="100"></td>
					<th>파라미터:</th>
					<td colspan="3"><input id="reqParam" class="" name="reqParam" title="파라미터" type="text" maxlength="1000"></td>
				</tr>
				<tr>					
					<th>유형:</th>
					<td colspan="5">
						<input class="" name="reqTypeCode" title="메뉴" type="checkbox" value="admin" checked="checked"> 관리자
						<input class="" name="reqTypeCode" title="메뉴" type="checkbox" value="active" checked="checked"> 활동
						<input class="" name="reqTypeCode" title="메뉴" type="checkbox" value="board" checked="checked"> 게시판
						<input class="" name="reqTypeCode" title="메뉴" type="checkbox" value="info" checked="checked"> 정보
						<input class="" name="reqTypeCode" title="메뉴" type="checkbox" value="market" checked="checked"> 장터
						<input class="" name="reqTypeCode" title="메뉴" type="checkbox" value="sitter" checked="checked"> 베이비시터
						<input class="" name="reqTypeCode" title="메뉴" type="checkbox" value="user" checked="checked"> 사용자
						<input class="" name="reqTypeCode" title="메뉴" type="checkbox" value="etc" checked="checked"> 기타
					</td>
				</tr>
			</table>
		</form>
	</div>
	<table id="mainTable" class="display" style="width:100%"></table>
</div>	