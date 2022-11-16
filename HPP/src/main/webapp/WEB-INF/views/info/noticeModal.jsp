<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/**
 * @화면명: 공지사항 모달 
 * @작성자: 김상민
 * @생성일: 2022. 11. 15. 오전 8:11:13
 * @설명: 공지사항 조회 및 관리 모달
**/
%>

<script src="<%=request.getContextPath() %>/resources/js/info/noticeModal.js"></script>

<style>
	.ck-editor__editable[role="textbox"] {
	    /* editing area */
	    min-height: 500px;
	}
</style>

<div id="noticeModal" class="modal" style="width: 1000px; height: 800px;">
	<form id="noticeForm" method="post">
		<table class="papang-table">
			<colgroup>
				<col style="width: 100px">
				<col style="width: *">
			</colgroup>
			<tbody>
				<tr>
					<th>제목</th>
					<td><input id="title" class="form-control" type="text" name="title" title="제목" onkeypress="if(event.keyCode == 13){#}"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea class="form-control" rows="" cols="" ></textarea>
						<!-- <div id="noticeEditor"></div> -->
					</td>
				</tr>				
			</tbody>
		</table>
		
		<div>
			<button type="button" onclick="#">저장</button>
		</div>
	</form>
</div>
