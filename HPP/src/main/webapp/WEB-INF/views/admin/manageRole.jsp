<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
/**
 * @화면명: 권한그룹 관리
 * @작성자: KimSangMin
 * @생성일: 2023. 5. 3. 오후 8:18:17
 * @설명:
**/
%>

<div>
	<%@include file="/WEB-INF/views/com/menuInfo.jsp" %>
	<div id="mainTableDiv"><table id="mainTable" class="display" style="width:100%;"></table></div>
	
	<div class="tableTitleDiv">
		<span id="tableTitle">
			<img src="<%=request.getContextPath() %>/resources/images/title-logo/arrow.png" style="width: 30px; margin-bottom: 4px; margin-right: -10px;">
			그룹 사용자 목록[<span id="roleNmSpan"></span>]
		</span>
	</div>
	
	<div id="groupUserTableDiv"><table id="groupUserTable" class="display" style="width:100%;"></table></div>
</div>	