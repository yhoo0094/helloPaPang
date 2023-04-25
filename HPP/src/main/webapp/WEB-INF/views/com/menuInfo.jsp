<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<a href="/"><span>Hello Papang</span></a> &gt
	<a href="/" id='mnuTopUrl'><span id='mnuUpperNm'></span></a> &gt
	<a href="/" id='mnuUrl'><span id='mnuNm'></span></a> -
	<span id='info'></span>
</div>
