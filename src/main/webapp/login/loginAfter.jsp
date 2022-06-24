<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var tid;
var cnt = parseInt(3000);//초기값(초단위)

function counter_init() { //메인화면 세션 카운트 실행
	tid = setInterval("counter_run()", 1000);
}
function counter_run() {
	document.all.counter.innerText = time_format(cnt);
	cnt --;
	
	if(cnt<0){
		window.location.replace("http://localhost/Team2_The_cook/loginCont");
	}
}

function time_format(s) {
	var nHour=0;
	var nMin=0;
	var nSec=0;
	if(s>0) {
		nMin = parseInt(s/60);
		nSec = s%60;

		if(nMin>60) {
			nHour = parseInt(nMin/60);
			nMin = nMin%60;
		}
	} 
	if(nSec<10) nSec = "0"+nSec;
	if(nMin<10) nMin = "0"+nMin;

	return ""+nHour+":"+nMin+":"+nSec;
}
</script>
</head>
<body onload="counter_init()">

	<div class="login_dropdown" >
		
		<span class="dropbtn">My page</span>
		(<span id="counter"></span>)
		<div class="dropdown-content">
			<p>
				<a href="myPageController">내 정보</a>
			</p>
			<p>
				<a href="myTextC">내가 쓴 글</a></p>
			<p>
				<a href="MyLikeListC">좋아요 한 글</a></p>
			<p>
				<a href="allScrapController">스크랩 한 글</a></p>
			<p>
				<a href="DoLoginController">로그아웃</a></p>
		</div>
	</div>
	
</body>
</html>