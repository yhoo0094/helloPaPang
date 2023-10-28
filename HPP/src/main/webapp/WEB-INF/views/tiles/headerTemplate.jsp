<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.LOGIN_INFO eq null}">
	<%@ include file="/WEB-INF/views/user/loginModal.jsp" %><!-- 로그인 모달 -->
</c:if>

<script>
	//자동 로그아웃 타이머
	let timeInterval;
	var sessionTime = '<%= session.getMaxInactiveInterval() %>';
	if(sessionTime != null){
		timeInterval = setInterval(function(){
			sessionTime = parseInt(sessionTime) - 1
			var leftTime = $dateUtil.secondToHour(sessionTime);
			$('#sessionTimer').text(leftTime);
			
			if(sessionTime == 0){
			    $.ajax({
			        url: '/user/logout.do',
			        type: 'POST',
			        contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
			        dataType: 'json',
			        success: function (result) {
				        if (result.RESULT == Constant.RESULT_SUCCESS){
				            alert('장시간 동작이 없어 자동 로그아웃 되었습니다.')
				            location.replace('/');
				        } else {
							alert(result[Constant.OUT_RESULT_MSG])
						}
			        }
			    });					
			}
		}, 1000)
	}	
	
	//세션 시간 리셋하기
	function sessionTimeReset() {
		sessionTime = '<%= session.getMaxInactiveInterval() %>';
	}
	
	//로그아웃
	function loginOut() {
		if(!confirm("정말 로그아웃 하시겠습니까?")){
			return;
		}
		
		$com.loadingStart();
	    $.ajax({
	        url: '/user/logout.do',
	        type: 'POST',
	        contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
	        dataType: 'json',
	        success: function (result) {
				$com.loadingEnd();
		        if (result.RESULT == Constant.RESULT_SUCCESS){
		            location.replace('/');
		        } else {
					alert(result[Constant.OUT_RESULT_MSG])
				}
	        },
	        error: function(textStatus, jqXHR, thrownError){
				$com.loadingEnd();
			}        
	    });		
	}	
	
	//헤더 메뉴 hover하면 서브 메뉴 나타나기
	function headerHover() {
		$(".navMnuDiv").hover(
	        function() {
	            $(this).find('.dropdownDiv').show();
	        },
	        function() {
	            $(this).find('.dropdownDiv').hide();
	        }
	    );
	}
	
	$(document).ready(function() {
		headerHover();
	});
</script>

<!-- Navbar (sit on top) -->
<div class="top">
	<div id="myNavbar">
		<div class="logoDiv">  
	    	<a href="/" class="logo-font color-black">Hello Papang</a>
	 	</div>
	 	<div class="navDiv">
		 	<div class="loginMnuDiv">
		 		<span style="width: 15px; float: right;">&nbsp;</span>
		 		<c:choose>
		 			<c:when test="${sessionScope.LOGIN_INFO eq null}">
						<a href="<%=request.getContextPath()%>/user/signUp" class="loginMnu color-black"><i class="fa-solid fa-door-open loginMnuIcon"></i>회원가입</a>			 			
						<a id="loginModalbtn" class="loginMnu color-black" href="javascript:loginModalOpen()"><i class="fa-solid fa-door-open loginMnuIcon"></i>로그인</a>
		 			</c:when>
		 			<c:otherwise>
						<span class="sessionTimer"><i class="fa-solid fa-clock loginMnuIcon"></i>자동 로그아웃: <span id="sessionTimer">02:00:00</span></span> 
						<a href="#about" class="loginMnu color-black"><i class="fa-solid fa-user loginMnuIcon"></i>마이페이지</a>
						<a href="javascript:loginOut()" class="loginMnu color-black"><i class="fa-solid fa-door-open loginMnuIcon"></i>로그아웃</a>	
		 			</c:otherwise>
		 		</c:choose>
			</div>	
			<div class="navMnuDiv">
				<div class="navMnuThDiv">
					<table class="navMnuTh">
						<colgroup>
							<col class="navMnuCol">
							<col class="navMnuCol">
							<col class="navMnuCol">
							<col class="navMnuCol">
							<col class="navMnuCol">
						</colgroup>
						<tbody>
							<tr>
								<td class="navIcon"><a href="<%=request.getContextPath()%>/admin/adminHome" class="navMnu color-black"><i class="fa fa-gear navIcon"></i> 관리자</a></td>
								<td class="navIcon"><a href="#about" class="navMnu color-black"><i class="fa fa-comment navIcon"></i> 게시판</a></td>
								<td class="navIcon"><a href="#team" class="navMnu color-black"><i class="fa-sharp fa-solid fa-store navIcon"></i> 장터</a></td>
								<td class="navIcon"><a href="#pricing" class="navMnu color-black"><i class="fa-solid fa-ice-cream navIcon"></i> 활동</a></td>								
								<td class="navIcon"><a href="#work" class="navMnu color-black"><i class="fa-solid fa-baby-carriage navIcon"></i> 베이비시터</a></td>
								<td class="navIcon"><a href="<%=request.getContextPath()%>/info/notice" class="navMnu color-black"><i class="fa-sharp fa-solid fa-circle-info navIcon"></i> 정보</a></td>
							</tr>	
						</tbody>
					</table>
				</div>
				<div class="dropdownDiv">
					<table style="width: 100%; text-align: center;">
						<colgroup>
							<col class="navMnuCol">
							<col class="navMnuCol">
							<col class="navMnuCol">
							<col class="navMnuCol">
							<col class="navMnuCol">
						</colgroup>
						<tbody>
							<tr>
								<td>게시판 하위메뉴1</td>
								<td>장터 하위메뉴1</td>
								<td>베이비시터 하위메뉴1</td>
								<td>활동 하위메뉴1</td>
								<td><a href="/info/notice" class="dropdownMnu">공지사항</a></td>
							</tr>	
							<tr>
								<td>게시판 하위메뉴2</td>
								<td>장터 하위메뉴2</td>
								<td>베이비시터 하위메뉴2</td>
								<td>활동 하위메뉴2</td>
								<td>정보 하위메뉴2</td>
							</tr>							
						</tbody>
					</table>			
				</div>
			</div>	
		</div>
	</div>
</div>