<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
/**
 * @화면명: 권한 관리
 * @작성자: KimSangMin
 * @생성일: 2023. 5. 23. 오후 7:18:19
 * @설명: 관리자가 권한 정보를 조회 및 관리할 수 있는 메뉴입니다.
**/
%>

<div>
	<%@include file="/WEB-INF/views/com/menuInfo.jsp" %>
	<div class="papang-search-div">
		<form id="searchForm" action="#">
			<table class="papang-search-table">
				<colgroup>
					<col width="100px">	
					<col width="230px">	
					<col width="100px">	
					<col width="*">	
				</colgroup>
				<tbody>
				<tr>
					<th>메뉴:</th>
					<td>
						<select id="mnuSeq" name="mnuSeq" class="form-select" style="width: 230px;">
							<option value="">전체
						</select>
					</td>
					<th>권한그룹:</th>
					<td>
						<select id="roleSeq" name="roleSeq" class="form-select" style="width: 230px;">
							<option value="">전체
						</select>
					</td>	
				</tr>
				</tbody>
			</table>
		</form>
		
	</div>
</div>	