<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
/**
 * @화면명: 로그인 모달 
 * @작성자: 김상민
 * @생성일: 2022. 11. 8. 오전 7:53:55
 * @설명: 로그인 정보 입력 모달
**/
%>
<script src="<%=request.getContextPath() %>/resources/js/user/loginModal.js"></script>

<div id="loginModal" class="modal" style="width: 400px;">
	<form id="loginForm" method="post">
		<table>
			<colgroup>
				<col style="width: 50%">
				<col style="width: *">
			</colgroup>
			<tbody>
				<tr>
					<th>아이디</th>
					<th><input id="id" type="text" name="id" title="아이디" onkeypress="if(event.keyCode == 13){login()}"></th>
				</tr>
				<tr>
					<th>비밀번호</th>
					<th><input id="pw" type="password" name="pw" title="비밀번호" onkeypress="if(event.keyCode == 13){login()}"></th>
				</tr>				
			</tbody>
		</table>
		
		<div>
			<button type="button" onclick="login()">로그인</button>
			<button type="button" onclick="location.href='/user/signUp'">회원가입</button>
		</div>
	</form>
</div>