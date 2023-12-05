<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
/**
 * @화면명: 놀이
 * @작성자: KimSangMin
 * @생성일: 2023. 11. 29. 오후 8:12:18
 * @설명: 아이와 함께할 수 있는 놀이 정보를 나누는 메뉴입니다.
**/
 %>

<div>
	<%@include file="/WEB-INF/views/com/menuInfo.jsp" %>
	<div class="papang-search-div lh50px">
		<form id="searchForm" action="#">
			<table class="papang-search-table">
				<colgroup>
					<col width="*">
					<col width="60rem">	
					<col width="20%">	
					<col width="60rem">	
					<col width="14%">	
					<col width="14%">
				</colgroup>
				<tbody>
				<tr>
					<td></td>
					<th>제목:</th>
					<td><input id="title" name="title" class="w100 form-control forSearch" title="제목" type="text" maxlength="20"></td>	
					<th>정렬:</th>
					<td>
						<select id="playOrderCode" name="playOrderCode" class="form-control w100 makeSelectTag" title="정렬"></select>
						<!-- 좋아요, 제목, 등록일 -->
					</td>
					<td class="tc">
						<button type="button" class="papang-search-btn papang_btn lh30px" onclick="doSearch()">검색</button>
						<button type="button" class="papang-save-btn papang_btn lh30px" onclick="mvCreatePlay()">신규</button>
					</td>
				</tr>
				</tbody>
			</table>
		</form>
	</div>	
	<div class="cardWrap">
	    <div class="cardItem">
	        <div class="cardImg"></div>
	        <div class="cardContent">
	            <div class="cardBtn">
	            	<img src="<%=request.getContextPath()%>/resources/images/etc/search.png" alt="no image"/>
	            	<img src="<%=request.getContextPath()%>/resources/images/etc/like.png" alt="no image"/>	
	            </div>
	            <div class="cardTitle">Card Title</div>
	            <div class="cardIntro">Card Introduction</div>
	        </div>
	    </div>
	    <div class="cardItem">
	        <div class="cardImg"></div>
	        <div class="cardContent">
	            <div class="cardBtn">Card Button</div>
	            <div class="cardTitle">Card Title</div>
	            <div class="cardIntro">Card Introduction</div>
	        </div>
	    </div>
	    <div class="cardItem">
	        <div class="cardImg"></div>
	        <div class="cardContent">
	            <div class="cardBtn">Card Button</div>
	            <div class="cardTitle">Card Title</div>
	            <div class="cardIntro">Card Introduction</div>
	        </div>
	    </div>
	    <div class="cardItem">
	        <div class="cardImg"></div>
	        <div class="cardContent">
	            <div class="cardBtn">Card Button</div>
	            <div class="cardTitle">Card Title</div>
	            <div class="cardIntro">Card Introduction</div>
	        </div>
	    </div>
	    <div class="cardItem">
	        <div class="cardImg"></div>
	        <div class="cardContent">
	            <div class="cardBtn">Card Button</div>
	            <div class="cardTitle">Card Title</div>
	            <div class="cardIntro">Card Introduction</div>
	        </div>
	    </div>
	    <div class="cardItem">
	        <div class="cardImg"></div>
	        <div class="cardContent">
	            <div class="cardBtn">Card Button</div>
	            <div class="cardTitle">Card Title</div>
	            <div class="cardIntro">Card Introduction</div>
	        </div>
	    </div>
	    <div class="cardItem">
	        <div class="cardImg"></div>
	        <div class="cardContent">
	            <div class="cardBtn">Card Button</div>
	            <div class="cardTitle">Card Title</div>
	            <div class="cardIntro">Card Introduction</div>
	        </div>
	    </div>
	</div>
	
	
</div>	