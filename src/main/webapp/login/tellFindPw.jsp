<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="loginCont">
		<div class="find2">
			<label class="IDis"><span>비밀번호는</span></label><br>
			<br> <label class="IDwas"><span>${findPw }입니다</span></label><br>
			<button class = "backLogin_bt">로그인으로 돌아가기</button>
		</div>
	</form>
</body>
</html>