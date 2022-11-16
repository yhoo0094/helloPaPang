<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ include file="/WEB-INF/views/user/loginModal.jsp" %><!-- 로그인 모달 -->
    
<!-- Navbar (sit on top) -->
<div class="top">
	<div id="myNavbar">
		<div class="logoDiv">  
	    	<a href="/" class="logo-font">Hello Papang</a>
	 	</div>
 	
	 	<div class="navDiv">
		 	<div class="loginMnuDiv">
		 		<span style="width: 15px; float: right;">&nbsp;</span>
				<a href="javascript:loginModalOpen()" class="loginMnu"><i class="fa-solid fa-door-open loginMnuIcon"></i>로그인</a>
				<a href="#about" class="loginMnu"><i class="fa-solid fa-user loginMnuIcon"></i>마이페이지</a>
				<a href="#about" class="loginMnu"><i class="fa-solid fa-door-open loginMnuIcon"></i>로그아웃</a>
				<a href="/user/signUp" class="loginMnu"><i class="fa-solid fa-door-open loginMnuIcon"></i>회원가입</a>				
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
								<td><a href="#about" class="navMnu"><i class="fa fa-comment navIcon"></i> 게시판</a></td>
								<td><a href="#team" class="navMnu"><i class="fa-sharp fa-solid fa-store navIcon"></i> 장터</a></td>
								<td><a href="#work" class="navMnu"><i class="fa-solid fa-baby-carriage navIcon"></i> 베이비시터</a></td>
								<td><a href="#pricing" class="navMnu"><i class="fa-solid fa-ice-cream navIcon"></i> 활동</a></td>
								<td><a href="#contact" class="navMnu"><i class="fa-sharp fa-solid fa-circle-info navIcon"></i> 정보</a></td>
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