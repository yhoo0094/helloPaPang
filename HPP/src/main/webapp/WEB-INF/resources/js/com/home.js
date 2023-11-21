$(() => {
	createImgSlide();	//이미지 슬라이드 생성
	noticePop();		//공지사항 팝업 열기		
})

//공지사항 팝업 열기
function noticePop(){
	$.ajax({
        url: '/notice/selectNotice.do',
        type: 'POST',
        data: {periodToggle: true},
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
        dataType: 'json',
        success: function (result) {
			for (var i in result.OUT_DATA){
				//window.open("popup/noticePop?boardSeq=" + result.OUT_DATA[i].boardSeq, result.OUT_DATA[i].title, "width=1000,height=800");
				
				window.open("popup.do?view_nm=noticePop&boardSeq=" + result.OUT_DATA[i].boardSeq, result.OUT_DATA[i].title, "width=1000,height=800");
			}
        }
    });	
}

//이미지 슬라이드 생성
function createImgSlide(){
	new Swiper('.swiper', {
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
		pagination: {
			el: '.swiper-pagination',
		},
	});
}

