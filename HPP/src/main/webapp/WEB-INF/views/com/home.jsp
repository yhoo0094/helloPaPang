<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<!-- Swiper -->
<div class="swiper mySwiper">
	<div class="swiper-wrapper">
		<div class="swiper-slide">
			<img class="slideImg" src="${pageContext.request.contextPath}\resources\images\image-slide\img1.jpg" />
		</div>
		<div class="swiper-slide">
			<img class="slideImg" src="${pageContext.request.contextPath}\resources\images\image-slide\img2.jpg" />
		</div>
		<div class="swiper-slide">
			<img class="slideImg" src="${pageContext.request.contextPath}\resources\images\etc\father-and-son.jpg" />
		</div>
	</div>
	<div class="swiper-pagination"></div>
</div>
<!-- Swiper -->

<div class="container">
	<p class="homeTitle">Hello Papang 서비스를 소개합니다</p>

    <!-- Marketing Icons Section -->
	<div class="row">
	
		<!-- 장터 -->
<!-- 		<div class="col-lg-4 mb-4 fadein" align="center"> -->
<!-- 			<figure class="snip1200"> -->
<%-- 				<img src="${pageContext.request.contextPath}/resources/images/etc/main_sitterMenu.png" /> --%>
<!-- 				<figcaption> -->
<!-- 					<p> -->
<!-- 						어머니의 마음과 전문가의 <br /> 손길이 함게합니다. <br /> 파팡 언제 어디서나 <br /> 우리아이들과 <br /> -->
<!-- 						행복한 돌봄을 만들어 갑니다! -->
<!-- 					</p> -->
<!-- 					<div class="heading"> -->
<!-- 						<h2> -->
<!-- 							시터<span> 서비스</span> -->
<!-- 						</h2> -->
<!-- 					</div> -->
<!-- 				</figcaption> -->
<!-- 			</figure> -->
<!-- 		</div> -->
		
		<!-- 게시판 -->
		<div class="col-lg-4 mb-4 fadein" align="center">
			<figure class="snip1200" onclick="window.location.href = '${pageContext.request.contextPath}/board/freeBoard'">
				<img src="${pageContext.request.contextPath}/resources/images/etc/main_boardMenu.jpg" />
				<figcaption>
					<p>
						궁금한 것이 있을 때. <br /> 
						공유하고 싶은 이야기가 있을 때. <br /> 
						<span class="color-hpp">Hello Papang</span>에서 <br />
						자유롭게 이야기 하세요!
					</p>
					<div class="heading">
						<h2>
							즐거운 <span>소통 공간</span>
						</h2>
					</div>
				</figcaption>
			</figure>
		</div>		

		<!-- 활동 -->
		<div class="col-lg-4 mb-4 fadein" align="center">
			<figure class="snip1200" onclick="window.location.href = '${pageContext.request.contextPath}/active/play'">
				<img src="${pageContext.request.contextPath}/resources/images/etc/main_activeMenu.jpg" />
				<figcaption>
					<p>
						새로운 육아 아이디어가 필요할 때. <br />
						신나게 놀면서 육아하고 싶을 때.<br />
						<span class="color-hpp">Hello Papang</span>에서 <br />
						다양한 활동을 경험하세요! 
					</p>
					<div class="heading">
						<h2>
							육아대디<span> 첫 걸음</span>
						</h2>
					</div>
				</figcaption>
			</figure>
		</div>
		
		<!-- 장터 -->
		<div class="col-lg-4 mb-4 fadein" align="center">
			<figure class="snip1200" onclick="window.location.href = ''">
				<img src="${pageContext.request.contextPath}/resources/images/etc/main_shopMenu.jpg" />
				<figcaption>
					<p>
						부모의 마음으로, <br /> 
						아이가 안전한 세상을 꿈꿉니다. <br /> 
						100% 순면제작, 무형광 제품 <br />
						<span class="color-hpp">Hello Papang</span>에서 만나보세요
					</p>
					<div class="heading">
						<h2>
							Papang<span> SHOP</span>
						</h2>
					</div>
				</figcaption>
			</figure>
		</div>		
	</div>
	<!-- /.row -->

	<hr />
	
	<p class="homeTitle display-inb">Papang ACTIVE</p>
	<p class="moreClass" onclick="window.location.href = '${pageContext.request.contextPath}/active/play'">더보기 ></p>
	<div id="cardWrap" class="cardWrap"></div>

	<hr />
	
	<!-- Portfolio Section -->
	<p class="homeTitle display-inb">Papang SHOP</p>
	<p class="moreClass" id="moreBtn">더보기 ></p>
	
	<div id="gridCardWrap" class="entCardWrap container"></div>
	
<!-- 	<div class="row"> -->
<!-- 		<div class="col-lg-4 portfolio-item sample_image"> -->
<!-- 			<div class="card h100"> -->
<!-- 				<a href="#"><img class="card-img-top" -->
<%-- 					src="${pageContext.request.contextPath}/resources/images/market/보행기.jpg" --%>
<!-- 					alt="상품 사진이없습니다"></a> -->
<!-- 				<div class="card-body"> -->
<!-- 					<h4 class="card-title"> -->
<!-- 						<a class="card_title2" href="#">card_title</a> -->
<!-- 					</h4> -->
<!-- 					<div> -->
<!-- 						<p class="card-text">&#8361;card-text</p> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->

<!-- 		<div class="col-lg-4 portfolio-item sample_image"> -->
<!-- 			<div class="card h100"> -->
<!-- 				<a href="#"><img class="card-img-top" -->
<%-- 					src="${pageContext.request.contextPath}/resources/images/market/상품2.jpg" --%>
<!-- 					alt="상품 사진이없습니다"></a> -->
<!-- 				<div class="card-body"> -->
<!-- 					<h4 class="card-title"> -->
<!-- 						<a class="card_title2" href="#">card_title</a> -->
<!-- 					</h4> -->
<!-- 					<div> -->
<!-- 						<p class="card-text">&#8361;card-text</p> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->

<!-- 		<div class="col-lg-4 portfolio-item sample_image"> -->
<!-- 			<div class="card h100"> -->
<%-- 				<a href="#"><img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/market/상품3.jpg" alt="상품 사진이없습니다"></a> --%>
<!-- 				<div class="card-body"> -->
<!-- 					<h4 class="card-title"> -->
<!-- 						<a class="card_title2" href="#">card_title</a> -->
<!-- 					</h4> -->
<!-- 					<div> -->
<!-- 						<p class="card-text">&#8361;card-text</p> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->

<!-- 		<div class="col-lg-4 portfolio-item sample_image"> -->
<!-- 			<div class="card h100"> -->
<%-- 				<a href="#"><img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/market/상품4.jpg" alt="상품 사진이없습니다"></a> --%>
<!-- 				<div class="card-body"> -->
<!-- 					<h4 class="card-title"> -->
<!-- 						<a class="card_title2" href="#">card_title</a> -->
<!-- 					</h4> -->
<!-- 					<div> -->
<!-- 						<p class="card-text">&#8361;card-text</p> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->

<!-- 		<div class="col-lg-4 portfolio-item sample_image"> -->
<!-- 			<div class="card h100"> -->
<!-- 				<a href="#"><img class="card-img-top" -->
<%-- 					src="${pageContext.request.contextPath}/resources/images/market/상품5.jpg" --%>
<!-- 					alt="상품 사진이없습니다"></a> -->
<!-- 				<div class="card-body"> -->
<!-- 					<h4 class="card-title"> -->
<!-- 						<a class="card_title2" href="#">card_title</a> -->
<!-- 					</h4> -->
<!-- 					<div> -->
<!-- 						<p class="card-text">&#8361;card-text</p> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->

<!-- 		<div class="col-lg-4 portfolio-item sample_image"> -->
<!-- 			<div class="card h100"> -->
<%-- 				<a href="#"><img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/market/상품6.jpg" alt="상품 사진이없습니다"></a> --%>
<!-- 				<div class="card-body"> -->
<!-- 					<h4 class="card-title"> -->
<!-- 						<a class="card_title2" href="#">card_title</a> -->
<!-- 					</h4> -->
<!-- 					<div> -->
<!-- 						<p class="card-text">&#8361;card-text</p> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
	<!-- /.row -->

	<hr />
	<!-- Features Section -->
	<div class="row introDiv">
		<div class="col-lg-6">
			<h2>HelloPapang</h2>
			<p>파파존스는 고객님의 편리를 위해 항상 노력하겠습니다.</p>
			<ul>
				<p>
					<strong>주요 서비스</strong>
				</p>
				<li>베이비시터 예약</li>
				<li>파파존스 SHOP</li>
				<li>육아 정보</li>
				<li>육아 예방접종 일지 캘린더</li>
			</ul>
			<p>믿고 맏길 수 있는 베이비시터 서비스 제공. 100% 순면 무형광 제작된 파파존스 핸드메이드 상품 판매.초보
				육아대디를 위한 유용한 정보 제공.육아 예방접종 일지 등록 제공.</p>
		</div>
		<div class="col-lg-6">
			<img class="img-fluid rounded famImage"
				src="${pageContext.request.contextPath}/resources/images/etc/team_papang_ai.png">
		</div>
	</div>
	<!-- /.row -->

	<hr>


	<div>
		<a href="#" class="f-right"><img class="topnav" src="${pageContext.request.contextPath}/resources/images/etc/topnav.png" /></a>
	</div>
			
</div>




