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
/* bxslider border 지우기 및 그림자 지우기 */
.bx-wrapper {
	overflow: hidden;
	border: 0;
	background: #fbfbfb;
	box-shadow: none;
}
</style>
</head>
<body>

	<div class="bxslider">
		<!-- slide -->
		<div>
			<img src="img/마늘빵.jpg">
			<h1 class="mainText1">
			홈베이킹 <br> 바삭한 마늘빵
			</h1>
		</div>
		<div>
			<img src="img/레어치즈케이크.jpg">
			<h1 class="mainText2">
				홈베이킹<br> 촉촉한 레어치즈케이크
			</h1>
		</div>
		<div>
			<img src="img/규동.jpg" style="width: 830px;">
			<h1 class="mainText3">
				일식<br> 든든한 규동 한끼
			</h1>
		</div>
		<div>
			<img src="img/loginPage.jpg">
			<h1 class="mainText4">
				중식<br> 촉촉하고 부드러운 유린기
			</h1>
		</div>

	</div>

	<script>
		$('.bxslider').bxSlider({
			auto : true,
			autoControls : false,
			slideWidth : 850,
			slideMargin : 0,
			maxSlides : 2,
			shrinkItems: true, // 반응형
			captions : false,
			autoHover : false, 
			responsive : false,
			controls : false, // 이전/다음 버튼 노출 여부
			pager : false	// 동그라미 (불릿) 버튼 노출 여부  

		});
	</script>
	
	<div class="currentDiv">
		<h2 class= "mainText">최근게시물</h2>
		<c:forEach var="p" items="${post}">
		<div class="currentCont">
			<img class="current_img" onclick="location.href='ShowPostDetailController?num=${p.board_number }'" 
			src="fileFolder/${p.board_file}">
			${p.board_title }
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
				 ${p.board_title }
			</div>
		</c:forEach>
	</div>


</body>
</html>