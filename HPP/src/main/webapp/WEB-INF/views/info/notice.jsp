<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
/**
 * @화면명: 공지사항 목록
 * @작성자: 김상민
 * @생성일: 2022. 11. 10. 오후 6:12:31
 * @설명: 공지사항 목록 조회 페이지
**/
%>

<%@ include file="/WEB-INF/views/info/noticeModal.jsp" %><!-- 로그인 모달 -->

<div>
	<%@include file="/WEB-INF/views/com/menuInfo.jsp" %>
	
<table id="mainTable" class="display" style="width:100%"></table>
</div>	