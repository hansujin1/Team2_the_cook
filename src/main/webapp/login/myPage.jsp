<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body id="Mypage">



	<div class="find">
		<h2 id="reg_h2">회원 정보</h2>
		<label class="reg_label2"> <span>이름</span>
		</label> <span class="myPage_value">${sessionScope.loginInfo.name }</span><br>

		<label class="reg_label2"> <span>아이디</span>
		</label> <span class="myPage_value">${sessionScope.loginInfo.id }</span><br>

		<label class="reg_label2"> <span>e-mail</span>
		</label> <span class="myPage_value">${sessionScope.loginInfo.mail }</span><br>

		<button class="reg_bt"
			onclick="location.href='myPageChangeController'">비밀번호 변경</button>
		<button class="reg_bt" onclick="location.href='deleteController'">탈퇴하기</button>


	</div>



</body>
</html>