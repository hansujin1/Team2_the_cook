<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/QA.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/board.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script type="text/javascript" src="login_js/check.js"></script>
<script type="text/javascript" src="login_js/validCheck.js"></script>
<script type="text/javascript" src="board.js/boardCheck.js"></script>
<script type="text/javascript" src="board.js/valid.js"></script>
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

	<!-- header -->
	<header id="header" style="margin: none;">

		<div id="mainlogo">
			<!-- 로고 이미지 클릭시 이동-->
			<a href="HC"> <img id="logo" src="img/Logo2.png"></a>
		</div>
		
	<form action="SearchC">
		<div>
			<!-- 검색창 -->
			<input name="board_title" id="query" type="search"
				placeholder="셰프님, 오늘은 어떤 맛의 세계로 떠나볼까요?">
		</div>
		
		<div>
			<!-- 검색 button -->
				<button id="search">
					<img class="searchEgg" src="img/SearchEgg.png">
				</button>
				
		</div>
		<div>
			<c:if test="${empty post}">
					<div class="no_recipe_wrapper">
						<span class="no_recipe">Sorry!
						We Can't Find Recipe!</span>
						<h3>새로운 레시피를 공유해주세요<h3>
					</div>
					
			</c:if>
		</div>
		</form>
	
		<div id="login">
			<!-- before:login after:myPage -->
			<h3>
				<jsp:include page="${loginPage }"></jsp:include>
			</h3>
		</div>

		<nav id="nav">
			<ul>
				<li class="Korea"><a href="ShowBoardListController?category=1">
						KOREAN </a></li>
				<li class="Japan"><a href="ShowBoardListController?category=2">
						JAPANESE </a></li>
				<li class="Western"><a href="ShowBoardListController?category=3"> 
						WESTERN </a></li>
				<li class="China"><a href="ShowBoardListController?category=4">
						CHINESE </a></li>
				<li class="Baking"><a href="ShowBoardListController?category=5"> 
						HOME BAKING </a></li>
			</ul>
		</nav>
	</header>



	<span><jsp:include page="${contentPage}"></jsp:include> </span>

	<footer class="footer">
		<img id="footerlogo" name="footerlogo" src="img/Logo_s.png">

		<div class="f_company">
			<h4>㈜더 쿡</h4>
			<p>사업자정보 / 서울특별시 종로구 종로12길 15 5층 (관철동 13-13)</p>
			<p>COPYRIGHT © THECOOK ALL RIGHTS RESERVED</p>


		</div>
	</footer>



</body>
</html>