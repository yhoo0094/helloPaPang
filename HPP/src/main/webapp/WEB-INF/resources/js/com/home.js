$(() => {
	//이미지 슬라이드
	var swiper = new Swiper('.swiper', {
		effect: "coverflow",
		grabCursor: true,
		centeredSlides: true,
		slidesPerView: "auto",
		coverflowEffect: {
			rotate: 50,
			stretch: 0,
			depth: 100,
			modifier: 1,
			slideShadows: true,
		},
		autoplay: {
			delay: 2500,
			disableOnInteraction: true,
		},

		// Optional parameters
//		loop: true,

		// If we need pagination
		pagination: {
			el: '.swiper-pagination',
		},
	});
})

