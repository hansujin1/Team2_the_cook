<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<style>
/* jquery.bxslider.css 적용부분 */
	 
.bx-wrapper {
	overflow: hidden;
	border: 0;
	background: #fbfbfb;
	box-shadow: none; /* bxslider border 지우기 및 그림자 지우기. */
	height: 650px; 
	/* 자식속성인 bx-viewport의 height값과 
	.bxslider height값을 같이 줘야 bottom에 추가된 회색 background가 사라짐*/
}
</style>
</head>
<body>
	<div class="bx_div">
	<ul class="bxslider">
		<!-- slide -->
		<li>
			<img src="img/sliderImg2.jpg" >
			<h1 class="mainText1">
				JOIN US!
				<br>더 많은 레시피를 공유해요
			</h1>
		</li>
		<li>
			<img src="img/sliderImg.jpg">
			<h1 class="mainText2">
				The Cook과 함께라면?
				<br> 어려운 요리도 뚝딱!  
			</h1>
		</li>
		<li>
			<img src="img/tteokbokki.jpg">
			<h1 class="mainText3">
				Korean Food
				<br>
			</h1>
		</li>	
		<li>
			<img src="img/sushi2.jpg">
			<h1 class="mainText4">
				Japanese Food
				<br> 
			</h1>
		</li>
		<li>
			<img src="img/pasta3.jpg">
			<h1 class="mainText5">
				Western Food
				<br> 
			</h1>
		</li>
	
		<li>
			<img src="img/Baking.jpg" style="">
			<h1 class="mainText6">
				Home Baking 
				<br>
			</h1>
		</li>
		

	</ul>
</div>
	<script>
		$('.bxslider').bxSlider({
			auto : true,
			mode: 'fade',
			autoControls : false,
			slideWidth : 1670,
			slideMargin : 0,
			maxSlides : 1,
			shrinkItems: true, // 반응형
			captions : false,
			autoHover : false, 
			responsive : false,
			controls : false, // 이전/다음 버튼 노출 여부
			pager : false,	// 동그라미 (불릿) 버튼 노출 여부  
			speed : 1500,
			pause : 4500,
			adaptiveHeight:false // 이미지 높이에 맞추어 자동으로 조절
		});
	</script>
	<div class="currentDiv">
		<h2 class= "mainText">최근게시물</h2>
		<c:forEach var="p" items="${post}">
		<div class="currentCont">
			<img class="current_img" onclick="location.href='ShowPostDetailController?num=${p.board_number }'" 
			src="fileFolder/${p.board_file}">
		</div>
		</c:forEach>
	</div>

	<div class="popularDiv">
		<h2 class= "mainText">인기게시물</h2>
		<c:forEach var="p" items="${post1}">
			<div class="popularCont">
			<img class="popular_img"
				 onclick="location.href='ShowPostDetailController?num=${p.board_number }'"
				 src="fileFolder/${p.board_file}">
			</div>
		</c:forEach>
		
	</div>

	<div class="event_div">
	<div class="event_sub_div">
	
	
		<div class="event_left">
			<ul>
				<li><img class = "event_img" src="img/event.jpg"></li>
			</ul>
		</div>
		
		
		
		<div class="event_right">

			<div class="event_txt">
				<h3 class="event_h3">★EVENT★</h3>
				<p class="event_label">
					The Cook은 레시피를 공유해주신 셰프님들 중<br> 높은 조회수를 기록하신 셰프님들을 대상으로 랜덤으로
					추첨하여<br> 감사의 마음을 담은 문화상품권을 증정하고 있습니다.<br>
					<br>
				</p>
				<p class="event_txt3">
					기간 중 레시피를 한번 이상 작성하신 셰프님은 <br> 이벤트에 자동 참여 됩니다.
				</p>
				<h6 class="event_h6">2022.06.17~2099.12.31</h6>



			</div>

	</div>
		</div>


	</div>
</body>
</html>