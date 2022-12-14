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
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font.css"> <!-- 폰트적용 -->
    <link rel="shortcut icon" type="image/x-icon" href="/resources/images/title-logo/superhero.png"> <!-- title 아이콘 변경 -->	
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />	<!-- jQuery Modal -->
    
    <!-- datatable -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.13.1/datatables.min.css"/>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
    <!--<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/2.3.2/css/buttons.dataTables.min.css"/> -->
    <!-- datatable -->
    
    
 	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/template.css"> <!-- 전체 공통 css -->
    <link rel="stylesheet" href="<%=request.getContextPath() %><tiles:getAsString name="css"/>"> <!-- 페이지 개별 css -->   
	
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	
	<!-- datatable 시작 -->
	<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.13.1/datatables.min.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/2.3.2/js/dataTables.buttons.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/2.3.2/js/buttons.html5.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/2.3.2/js/buttons.print.min.js"></script>	 
	<!-- datatable 끝 -->
	
	<script src="https://cdn.ckeditor.com/ckeditor5/35.3.1/classic/ckeditor.js"></script><!-- ck에디터 -->
	<script src="https://kit.fontawesome.com/e2689e2fa2.js"></script> <!-- 아이콘 -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script><!-- jQuery Modal -->
	<script src="<%=request.getContextPath() %>/resources/js/com/common.js"></script> <!-- 페이지 공통 -->
	<script src="<%=request.getContextPath() %>/resources/js/framework/util.js"></script> <!-- 유틸 -->
	<script src="<%=request.getContextPath() %>/resources/js/framework/dateUtil.js"></script> <!-- 날짜 유틸 -->
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
  		<%-- <tiles:insertAttribute name="foot"/> --%>
  	</div>
  </body>
  
</html>