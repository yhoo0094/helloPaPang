<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<% 
/**
 * @화면명: 메뉴 경로
 * @작성자: KimSangMin
 * @생성일: 2023. 9. 11. 오후 1:27:30
 * @설명: 메뉴 접속 경로를 보여준다
**/
 %>

    
<script>
	var mnuUpperNm = '<%= request.getAttribute("mnuUpperNm") %>';
	var mnuNm = '<%= request.getAttribute("mnuNm") %>';
	var mnuTopUrl = '<%= request.getAttribute("mnuTopUrl") %>';
	var mnuUrl = '<%= request.getAttribute("mnuUrl") %>';
	var info = '<%= request.getAttribute("info") %>';
	
	window.onload = function(){
		$('#mnuTitle').text(mnuNm);
		$('#mnuUpperNm').text(mnuUpperNm);
		$('#mnuNm').text(mnuNm);
		$('#mnuTopUrl').attr('href', '/' + mnuTopUrl);
		$('#mnuUrl').attr('href', '/' + mnuUrl);
		$('#info').text(info);
	}
</script>

	
<div class="menuNmDiv">
	<span id='mnuTitle'></span>
</div>
<div class="menuPathDiv">
	<a href="/" class="remove-a"><span>Hello Papang</span></a> &gt
	<a href="/" id='mnuTopUrl' class="remove-a"><span id='mnuUpperNm'></span></a> &gt
	<a href="/" id='mnuUrl' class="remove-a"><span id='mnuNm'></span></a> -
	<span id='info'></span>
</div>
