<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="reg_body">
<form action="idFindController" method="post" name="idFindForm" onsubmit="return idFind_call()">
	
	<div class="find">
	
		<h2 id="find_id">아이디 찾기</h2>
		
		<label class="find_label"> <span>이름</span><br>
		<input class="find_name" name="find_name"></label><br>
		
		<label class="find_label"> <span>e-mail</span><br>
		<input class="find_mail" name="find_mail"></label><br>
		
		<button class="find_bt">GO</button>
	</div>
	
	</form>	
</body>
</html>