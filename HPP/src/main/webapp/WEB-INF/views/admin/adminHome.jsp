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

<script>
<%-- 	location.href = "<%=request.getContextPath() %>/admin/loginLog"; --%>
	location.href = "<%=request.getContextPath() %>/admin/requestLog";
</script>

<div>
	<%@include file="/WEB-INF/views/com/menuInfo.jsp" %>
</div>	