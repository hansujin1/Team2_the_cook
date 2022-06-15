<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="pwFindController" method="post" name="pwFindForm" onsubmit="return pwFind_call()">
	
	<div>
		<div>비밀번호 찾기</div>
		<div>
		<div>아이디</div>
		<div><input name="find_id"></div>
		</div>
		<div>
		<div>이름</div>
		<div><input name="find_name"></div>
		</div>
		<div>
		<div>이메일</div>
		<div><input name="find_mail" type="email"></div>
		</div>
		
		<button>찾기</button>
	</div>
	
	</form>
</body>
</html>