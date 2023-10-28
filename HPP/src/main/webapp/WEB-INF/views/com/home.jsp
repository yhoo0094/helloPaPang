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
	<p class="homeTitle">Papang 서비스를 소개합니다</p>

    <!-- Marketing Icons Section -->
	<div class="row">
		<div class="col-lg-4 mb-4 fadein" align="center">
			<figure class="snip1200">
				<img src="${pageContext.request.contextPath}/resources/images/etc/main_sitterMenu.png" />
				<figcaption>
					<p>
						어머니의 마음과 전문가의 <br /> 손길이 함게합니다. <br /> 파팡 언제 어디서나 <br /> 우리아이들과 <br />
						행복한 돌봄을 만들어 갑니다!
					</p>
					<div class="heading">
						<h2>
							시터<span> 서비스</span>
						</h2>
					</div>
				</figcaption>
			</figure>
		</div>

		<div class="col-lg-4 mb-4 fadein" align="center">
			<figure class="snip1200">
				<img src="${pageContext.request.contextPath}/resources/images/etc/main_shopMenu.jpg" />
				<figcaption>
					<p>
						엄마의 마음으로, <br /> 우리아이가 안전한 세상을 꿈꿉니다. <br /> 100% 순면제작, 무형광 <br />
						제품을 만나보세요
					</p>
					<div class="heading">
						<h2>
							파파존스<span> SHOP</span>
						</h2>
					</div>
				</figcaption>
			</figure>
		</div>

		<div class="col-lg-4 mb-4 fadein" align="center">
			<figure class="snip1200">
				<img src="${pageContext.request.contextPath}/resources/images/etc/main_boardMenu.jpg" />
				<figcaption>
					<p>
						새로운 놀이 아이디어가 필요할 때. <br /> 놀면서 아이 성장발달을 <br /> 도와주고 싶을 때. <br />
						파파존스의 놀이 패키지를 <br /> 만나보세요!
					</p>
					<div class="heading">
						<h2>
							육아대디<span> 첫 걸음</span>
						</h2>
					</div>
				</figcaption>
			</figure>
		</div>
	</div>
	<!-- /.row -->

	<hr />
	
	<!-- Portfolio Section -->
	<h2 class="homeTitle">Papang SHOP</h2>
	<p class="moreClass" id="moreBtn">더보기 ></p>
	<div class="row">
	
			<div class="col-lg-4 col-sm-6 portfolio-item mainBox sample_image">
				<div class="card h-100">
					<p class="pro_no">${product.pro_no}</p>
					<a href="#"><img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/market/보행기.jpg" alt="상품 사진이없습니다"></a>
					<div class="card-body">
						<div class="proNameDiv">
							<h4 class="card-title">
								<a class="card_title2" href="#">${product.pro_name}</a>
							</h4>
						</div>
						<div class="proPriceDiv">
							<p class="card-text">&#8361;${product.pro_price}</p>
						</div>
					</div>
				</div>
			</div>
			
	</div>
	<!-- /.row -->

</div>




