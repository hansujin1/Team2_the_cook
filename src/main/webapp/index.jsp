<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	border: 0;
	background: #fbfbfb;
	box-shadow: none;
}
</style>
</head>
<body>

	<form action="HC">

		<!-- header -->
		<header id="header" style="margin: none;">
			<div id="mainlogo">
				<!-- 로고 이미지 클릭시 이동--가칭 "index.jsp"-->
				<a href="HC"> <img id="logo" src="img/Logo2.png">
				</a>
			</div>
			<div>
				<!-- 검색창 -->
				<input id="query" type="text"
					placeholder="셰프님, 오늘은 어떤 맛의 세계로 떠나볼까요?">
			</div>
			<div>
				<!-- 검색 button 태그 -->
				<button id="search">
					<img class="searchEgg" src="img/SearchEgg.png">
				</button>
			</div>

			<div id="login">
				<!-- login post 연결, LoginC로  -->
				<h3>
					<a href="#" class="login">LOGIN</a>
				</h3>
			</div>

		</header>
		<nav id="nav">
			<ul>
				<li class="Korea"><a href="#"> 한식 </a></li>
				<li class="Japan"><a href="#"> 일식 </a></li>
				<li class="Western"><a href="#"> 양식 </a></li>
				<li class="China"><a href="#"> 중식 </a></li>
				<li class="Baking"><a href="#"> 홈베이킹 </a></li>
				<li class="Event"><a href="#"> EVENT </a></li>
			</ul>
		</nav>
		
		<span> <jsp:include page="${contentPage}"></jsp:include></span>

	</form>





</body>
</html>