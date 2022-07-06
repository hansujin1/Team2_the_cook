<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="loginCont">
		<div class = "find2" >
			<label class = "IDis" ><span>아이디는</span></label><br><br>
			<label class = "IDwas"><span>${findId }입니다</span></label><br>
			<button class = "backLogin_bt">로그인으로 돌아가기</button>
		</div>
	</form>
</body>
</html>