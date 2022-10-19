<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>

<!DOCTYPE html>
<html>
  <head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/style.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/template.css">
    <title><tiles:insertAttribute name="title" /></title>
    
    <!-- title 아이콘 변경 -->
    <link rel="shortcut icon" type="image/x-icon" href="resources/images/title-logo/superhero.png">
    
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
  </head>
  
  <body>
  	<div class='wrap'>
  		<tiles:insertAttribute name="header" />
		  <div class='content'>  	
  			<tiles:insertAttribute name="left"/>
	  		<div class="page_content">
	  			<tiles:insertAttribute name="body"/>
	  		</div>
  		</div>
  		<tiles:insertAttribute name="foot" />
  	</div>
  </body>
  
</html>