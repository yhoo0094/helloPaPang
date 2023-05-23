<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/**
 * @화면명: 관리자 보드
 * @작성자: 김상민
 * @생성일: 2023. 1. 12. 오후 2:46:04
 * @설명: 관리자가 페이지 현황을 전체적으로 조회할 수 있는 페이지
**/
%>

<div>
	<%@include file="/WEB-INF/views/com/menuInfo.jsp" %>
	
	<p><a href="<%=request.getContextPath()%>/admin/loginLog">로그인 로그</a></p>
	<p><a href="<%=request.getContextPath()%>/admin/requestLog">요청 로그</a></p>
	<p><a href="<%=request.getContextPath()%>/admin/manageRole">권한그룹 관리</a></p>
	<p><a href="<%=request.getContextPath()%>/admin/manageMnu">메뉴 관리</a></p>
	<p><a href="<%=request.getContextPath()%>/admin/manageAuth">권한 관리</a></p>
</div>	