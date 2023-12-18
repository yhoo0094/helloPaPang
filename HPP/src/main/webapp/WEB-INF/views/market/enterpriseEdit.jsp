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
		<form id="viewForm" method="post" enctype="multipart/form-data">
			<input type="hidden" id="boardSeq" name="boardSeq" value="">
			<input type="hidden" id="boardCode" name="boardCode" value="02"><!-- 게시판구분코드(01:공지사항,02:자유게시판,03:질문게시판,04:지역게시판,05:놀이) -->
			
			<table class="papang-table">
				<colgroup>
					<col style="width: 10%">
					<col style="width: 40%">
					<col style="width: 10%">
					<col style="width: 40%">
				</colgroup>
				<tbody>
					<tr>
						<th>썸네일</th>
						<td colspan="3">
							<div class="thumbnailDiv">
								<input type="file" id="thumbnail" name="thumbnail" accept="image/*">
							    <img id="thumbnailImg" class="thumbnailImg" title="썸네일을 선택하세요." src="<%=request.getContextPath()%>/resources/images/etc/upload.png" alt="no image"/>
							    <span id="cardImgMsg" title="썸네일을 선택하세요.">썸네일을 선택하세요.</span>						        
					        </div>
						</td>
					</tr>
					<tr>
						<th>제품명</th>
						<td colspan="3"><input id="proName" name="proName" class="form-control" type="text" title="제품명" maxlength="100" required="all1"/></td>
					</tr>
					<tr>
						<th>가격</th>
						<td><input id="price" name="price" class="form-control w50 tr" type="text" title="가격" maxlength="9" required="all1"/><b>원</b></td>
						<th></th>
						<td></td>
					</tr>
					<tr>
						<th>분류</th>
						<td>
							<select id="marketTypeCode" name="marketTypeCode" class="form-select w50 makeSelectTag" title="분류" required="all1">
								<option value="">선택하세요
							</select>
						</td>
						<th>재고</th>
						<td>
							<input id="cnt" name="cnt" class="form-control w50 tr" type="text" maxlength="9" title="재고">
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							<div class="editor-container">
								<div id="cn" title="내용" class="editor form-control"></div>
								<div id="cnByteDisplay" class="byteDisplay"></div>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			
			<div class="modal_btn_wrapper">
				<button type="button" id="saveBtn" class="btn papang-save-btn papang_btn" onclick="saveBtnClick()" style="display: none;">저장</button>
				<button type="button" id="modifyBtn" class="btn papang-save-btn papang_btn" onclick="modifyBtnClick()" style="display: none;">수정</button>
				<button type="button" id="delBtn" class="btn papang-del-btn papang_btn" onclick="deleteBtnClick()" style="display: none;">삭제</button>
				<button type="button" id="historyBackBtn" class="btn papang-close-btn papang_btn" onclick="moveList()">돌아가기</button>
			</div>
		</form>
	</div>	
</div>	
