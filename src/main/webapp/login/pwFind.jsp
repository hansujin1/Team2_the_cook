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
	<form action="pwFindController" method="post" name="pwFindForm" onsubmit="return pwFind_call()">
	
	<div class="find">
	
		<h2 id="find_id">비밀번호 찾기</h2>
		
		<label class="find_label"> <span>ID</span><br>
		<input class="find_name" name="find_id"></label><br>
		
		<label class="find_label"> <span>이름</span><br>
		<input class="find_name" name="find_name"></label><br>
		
		<label class="find_label"> <span>e-mail</span><br>
		<input class="find_mail" name="find_mail" type="email"></label>
		<span class="pw_alert">${r}</span><br>
		
		<button class="find_bt">GO</button>
	</div>
	
	</form>
</body>
</html>