<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body id="Check_pw">
	<form action="deleteController" method="post" name="pwForm" onsubmit="return pw_call()">
		<div class = "find">
			<h2 class = "check_pw">탈퇴 전 비밀번호 확인</h2>
			<input placeholder="비밀번호를 입력해주세요." name="check_pw2" type="password"><br>
			<span class="pw_alert">${r}</span><br>
			<button class="reg_bt">확인</button>
		</div>
	</form>
</body>
</html>