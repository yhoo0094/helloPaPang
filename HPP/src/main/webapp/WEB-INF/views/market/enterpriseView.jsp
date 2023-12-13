<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
/**
 * @화면명: 공지사항 팝업 
 * @작성자: KimSangMin
 * @생성일: 2023. 11. 20. 오후 8:17:36
 * @설명: 공지사항 조회 팝업
**/
 %>
<div>
	<%@include file="/WEB-INF/views/com/menuInfo.jsp" %>
	<div class="papang-content-div">
		<div id="marketItem">
		    <img id="marketThumbnail" src="/common/images/enterprise/smart-home-3148026_1920_170749.jpg" alt="Market Thumbnail"/>
		    <div id="marketContent">
			    <div id="title">제품 이름</div>
			    <div id="price">가격 정보</div>
			    <div id="btnBox">버튼 영역</div>
			<div id="marketInfoBox">
		</div>

			
<!-- 		<div class="modal_btn_wrapper"> -->
<!-- 			<button type="button" id="saveBtn" class="btn papang-save-btn papang_btn" onclick="saveBtnClick()" style="display: none;">저장</button> -->
<!-- 			<button type="button" id="modifyBtn" class="btn papang-save-btn papang_btn" onclick="modifyBtnClick()" style="display: none;">수정</button> -->
<!-- 			<button type="button" id="delBtn" class="btn papang-del-btn papang_btn" onclick="deleteBtnClick()" style="display: none;">삭제</button> -->
<!-- 			<button type="button" id="historyBackBtn" class="btn papang-close-btn papang_btn" onclick="moveList()">돌아가기</button> -->
<!-- 		</div> -->
	</div>	
</div>	
