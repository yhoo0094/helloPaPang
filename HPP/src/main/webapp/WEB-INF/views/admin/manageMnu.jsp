<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
/**
 * @화면명: manageMnu.jsp
 * @작성자: KimSangMin
 * @생성일: 2023. 5. 13. 오전 11:47:10
 * @설명: 메뉴 관리
**/
 %>

<div>
	<%@include file="/WEB-INF/views/com/menuInfo.jsp" %>
	<div style="display: inline-block; width: 50%;">
		<div class="titleDiv">
			<img src="<%=request.getContextPath()%>/resources/images/title-logo/arrow.png" style="width: 30px; margin-bottom: 4px; margin-right: -10px;">
			메뉴 목록
		</div>
		<div id="jstree"></div>
	</div>
	
	<div id="mnuInfoTableDiv" style="display: inline-block; width: 47%; float: right;">
		<div class="titleDiv">
			<img src="<%=request.getContextPath()%>/resources/images/title-logo/arrow.png" style="width: 30px; margin-bottom: 4px; margin-right: -10px;">메뉴정보
		</div>
		<table id="mnuInfoTable" class="display" style="width:100%;"></table>
	</div>
</div>	