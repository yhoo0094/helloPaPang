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

<script type="module">
    import editor from '/resources/js/framework/ckeditor5/build/editor.js'

    $(document).ready(function () {
		editor(".editor").then(editor => {
			window.cn = editor;	//cn 전역변수
        	// some code..
            // then 이후에 받은 editor를 다른 변수로 받아주시는 편이 좋습니다!
        })
    })
</script> 

<style>
	.ck-editor__editable[role="textbox"] {
	    /* editing area */
	    min-height: 500px;
	}
</style>

<div id="noticeModal" class="modal" style="width: 1000px; height: 800px;">
	<form id="noticeForm" name="noticeForm" method="post" enctype="multipart/form-data">
		<input type="hidden" id="boardSeq" name="boardSeq" value="">
		<input type="hidden" id="boardCode" name="boardCode" value="01">
		
		<table class="papang-table">
			<colgroup>
				<col style="width: 100px">
				<col style="width: 400px">
				<col style="width: 100px">
				<col style="width: *">
			</colgroup>
			<tbody>
				<tr>
					<th>제목</th>
					<td colspan="3"><input id="title" name="title" class="form-control" type="text" title="제목" maxlength="100" required="all1"/></td>
				</tr>
				<tr>
					<th>게시기간</th>
					<td>
						<input id="strDt" name="strDt" class="form-control" type="date" title="게시시작일" required="all1"/> 
					  ~ <input id="endDt" name="endDt" class="form-control" type="date" title="게시종료일" required="all1"/>
					</td>
					<th>팝업여부</th>
					<td>
						Y <input id="popY" name="popYn" type="radio" value="Y">
						N <input id="popN" name="popYn" type="radio" value="N" checked="checked">
					</td>
				</tr>				
				<tr>
					<th>내용</th>
					<td colspan="3">
						<div id="cn" name="cn" title="내용" class="editor form-control"></div>
					</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="3">
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
