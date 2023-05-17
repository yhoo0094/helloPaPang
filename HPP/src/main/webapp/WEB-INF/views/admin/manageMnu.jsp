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
	<div style="display: inline-block; width: 30%;">
		<div class="titleDiv">
			<img src="<%=request.getContextPath()%>/resources/images/title-logo/arrow.png" style="width: 30px; margin-bottom: 4px; margin-right: -10px;">
			메뉴 목록
		</div>
		<div id="jstree"></div>
	</div>
	
	<div id="mnuInfoTableDiv" style="display: inline-block; width: 67%; float: right;">
		<div class="titleDiv">
			<img src="<%=request.getContextPath()%>/resources/images/title-logo/arrow.png" style="width: 30px; margin-bottom: 4px; margin-right: -10px;">
			메뉴정보
		</div>
		<div class="papang-info-div">
			<form id="writeForm" action="#">		
				<table id="mnuInfoTable" class="display papang-info-table" style="width:100%;">
					<colgroup>
						<col width="150px">	
						<col width="*">	
						<col width="150px">	
						<col width="*">	
					</colgroup>		
					<tr>
						<th>메뉴명</th>
						<td>
							<input type="text" id="mnuNm" name="mnuNm" class="form-control" title="메뉴명">
						</td>	
						<th>메뉴경로</th>
						<td>
							<input type="text" id="url" name="url" class="form-control" title="메뉴경로">
						</td>				
					</tr>		
					<tr>
						<th>최상위메뉴경로</th>
						<td>
							<input type="text" id="topUrl" name="topUrl" class="form-control" title="최상위메뉴경로">
						</td>	
						<th>상위메뉴경로</th>
						<td>
							<input type="text" id="upperUrl" name="upperUrl" class="form-control" title="상위메뉴경로">
						</td>				
					</tr>
					<tr>
						<th>메뉴노출여부</th>
						<td class="tc">
							<label for="openY">노출 </label> <input type="radio" value="Y" id="openY" name="openYn">
							&nbsp;&nbsp;&nbsp;&nbsp;
							<label for="openN">숨기기 </label> <input type="radio" value="N" id="openN" name="openYn">
						</td>	
						<th>권한체크여부</th>
						<td>
							<input type="text" id="authYn" name="authYn" class="form-control" title="권한체크여부">
						</td>				
					</tr>	
					<tr>
						<th>메뉴레벨</th>
						<td>
							<input type="text" id="mnuLv" name="mnuLv" class="form-control" title="메뉴레벨">
						</td>	
						<th>표시순서</th>
						<td>
							<input type="text" id="mnuOrder" name="mnuOrder" class="form-control" title="표시순서">
						</td>				
					</tr>					
					<tr>
						<th>메뉴정보</th>
						<td colspan="3">
							<input type="text" id="info" name="info" class="form-control" title="메뉴정보">
						</td>
					</tr>	
					<tr>
						<th>비고</th>
						<td colspan="3">
							<textarea id="rmrk" name="rmrk" class="form-control" title="비고" style="height: 300px; resize: none;"></textarea>
						</td>				
					</tr>																			
				</table>
			</form>
		</div>		
	</div>
</div>	