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
					<th>
						발생일시: 
					</th>
					<td>
						<input id="reqDttiStr" class="" name="reqDttiStr" title="발생일시" type="datetime-local" required="all1"> ~ 
						<input id="reqDttiEnd" class="" name="reqDttiEnd" title="발생일시" type="datetime-local" required="all1">
					</td>
					<th>
						아이디: 
					</th>
					<td>
						<input id="userId" class="" name="userId" title="아이디"  type="text" maxlength="20">
					</td>	
					<th>
						아이피: 
					</th>
					<td>
						<input id="userIp" class="" name="userIp" title="아이피"  type="text" maxlength="39">
					</td>									
				</tr>
				<tr>
					<td>
						<button>검색</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<table id="mainTable" class="display" style="width:100%"></table>
</div>	