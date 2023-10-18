<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<!-- Slideshow container -->
<div class="slideshow-container">

  <!-- Full-width images with number and caption text -->
  <div class="mySlides fadeIn">
    <div class="numbertext">1 / 3</div>
    <img src="<%=request.getContextPath()%>/resources/images/image-slide/img1.jpg" style="width:100%; height: 500px;">
    <div class="text">Caption Text</div>
  </div>

  <div class="mySlides fadeIn">
    <div class="numbertext">2 / 3</div>
    <img src="<%=request.getContextPath()%>/resources/images/title-logo/arrow.png" style="width:100%; height: 500px;">
    <div class="text">Caption Two</div>
  </div>

  <div class="mySlides fadeIn">
    <div class="numbertext">3 / 3</div>
    <img src="<%=request.getContextPath()%>/resources/images/title-logo/arrow.png" style="width:100%; height: 500px;">
    <div class="text">Caption Three</div>
  </div>

  <!-- Next and previous buttons -->
  <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
  <a class="next" onclick="plusSlides(1)">&#10095;</a>
</div>
<br>

<!-- The dots/circles -->
<div style="text-align:center">
  <span class="dot" onclick="currentSlide(1)"></span>
  <span class="dot" onclick="currentSlide(2)"></span>
  <span class="dot" onclick="currentSlide(3)"></span>
</div>
	
