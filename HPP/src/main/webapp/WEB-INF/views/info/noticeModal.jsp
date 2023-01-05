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
	<form id="noticeForm" name="noticeForm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="boardType" value="01">
		<input type="hidden" name="bizDvcd" value="001">
		<input type="hidden" id = "bizId" name="bizId" value="">
		
		<table class="papang-table">
			<colgroup>
				<col style="width: 100px">
				<col style="width: *">
			</colgroup>
			<tbody>
				<tr>
					<th>제목</th>
					<td><input id="title" class="form-control" type="text" name="title" title="제목" onkeypress="if(event.keyCode == 13){}"/></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea id="content" name="content" class="form-control" rows="" cols="" style="height: 500px"></textarea>
						<!-- <div id="noticeEditor"></div> -->
					</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<!-- 첨부파일 div -->
						<%@include file="/WEB-INF/views/com/fileAttach.jsp" %>
					</td>
				</tr>
			</tbody>
		</table>
		
		<div class="modal_btn_wrapper">
			<button type="button" class="btn papang-save-btn papang_btn" onclick="saveNotice()">저장</button>
			<button type="button" class="btn papang-del-btn papang_btn" onclick="deleteBoard()">삭제</button>
			<button type="button" class="btn papang-close-btn papang_btn" onclick="closeModal()">닫기</button>
		</div>
	</form>
</div>
