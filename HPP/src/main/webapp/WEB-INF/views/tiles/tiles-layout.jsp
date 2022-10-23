<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>

<!DOCTYPE html>
<html>
  <head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font.css"> <!-- 폰트적용 -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/template.css"> <!-- 전체 공통 css -->
    <link rel="stylesheet" href="<%=request.getContextPath() %><tiles:getAsString name="css"/>"> <!-- 페이지 개별 css -->
    
    <link rel="shortcut icon" type="image/x-icon" href="/resources/images/title-logo/superhero.png"> <!-- title 아이콘 변경 -->	
	
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script src="https://kit.fontawesome.com/e2689e2fa2.js"></script> <!-- 아이콘 -->
	<script src="<%=request.getContextPath() %><tiles:getAsString name="js"/>"></script> <!-- 페이지 개별 js -->
	
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