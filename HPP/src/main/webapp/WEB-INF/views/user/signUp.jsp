<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
/**
 * @화면명: 회원가입
 * @작성자: 김상민
 * @생성일: 2022. 10. 26. 오전 8:37:17
 * @설명: 회원가입 정보 입력 페이지
**/
%>


<div>
	<%@include file="/WEB-INF/views/com/menuInfo.jsp" %>
	<form id="signUpForm" method="post">
		<table>
			<colgroup>
				<col style="width: 50%">
				<col style="width: *">
			</colgroup>
			<tbody>
				<tr>
					<th>아이디</th>
					<th><input type="text" name="userId" title="아이디" onkeypress="if(event.keyCode == 13){signUp()}" required="all1"></th>
				</tr>
				<tr>
					<th>비밀번호</th>
					<th><input type="text" name="userPw" title="비밀번호" onkeypress="if(event.keyCode == 13){signUp()}" required="all1"></th>
				</tr>				
			</tbody>
		</table>
		
		<button type="button" onclick="signUp()">가입</button>
	</form>
</div>	

