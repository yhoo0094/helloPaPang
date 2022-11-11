<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>

<%
/**
 * @화면명: tiles layout
 * @작성자: 김상민
 * @생성일: 2022. 11. 8. 오후 6:51:35
 * @설명: 타일즈 적용을 위한 레이아웃 페이지
**/
%>

<!DOCTYPE html>
<html>
  <head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font.css"> <!-- 폰트적용 -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/template.css"> <!-- 전체 공통 css -->
    <link rel="stylesheet" href="<%=request.getContextPath() %><tiles:getAsString name="css"/>"> <!-- 페이지 개별 css -->
    <link rel="shortcut icon" type="image/x-icon" href="/resources/images/title-logo/superhero.png"> <!-- title 아이콘 변경 -->	
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />	<!-- jQuery Modal -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.13.1/datatables.min.css"/><!-- datatable -->
	
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<!-- datatable 시작 -->
	<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.13.1/datatables.min.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
	<!-- datatable 끝 -->
	
	<script src="https://kit.fontawesome.com/e2689e2fa2.js"></script> <!-- 아이콘 -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script><!-- jQuery Modal -->
	
	<script src="<%=request.getContextPath() %>/resources/js/com/common.js"></script> <!-- 페이지 공통 -->
	<script src="<%=request.getContextPath() %>/resources/js/framework/util.js"></script> <!-- 유틸 -->
	<script src="<%=request.getContextPath() %>/resources/js/framework/constant.js"></script> <!-- js 공통 변수 -->
	<script src="<%=request.getContextPath() %><tiles:getAsString name="js"/>"></script> <!-- 페이지 개별 -->
	

	
    <title><tiles:insertAttribute name="title" /></title>
  </head>
  
  <body>
  	<div class='wrap'>
  		<tiles:insertAttribute name="header"/>
		<div class='content'>  	
  			<tiles:insertAttribute name="left"/>
	  		<div class="page_content">
	  			<tiles:insertAttribute name="body"/>
	  		</div>
	  		<tiles:insertAttribute name="right"/>
  		</div>
  		<tiles:insertAttribute name="foot"/>
  	</div>
  </body>
  
</html>