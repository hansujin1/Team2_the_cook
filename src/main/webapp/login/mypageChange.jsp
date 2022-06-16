<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="reg">
	
	<form action="myPageController" method="post">
		
			<div>
				<h2 id="reg_h2">비밀번호 변경</h2>
					
				<label class="reg_label"> <span>Password</span><br>
					<input class="reg_input" type="password" name="pw" onchange="isSame()"  /></label>
					
				<label class="reg_label"> <span>Password</span><br>
					<input class="reg_input" type="password" name="pw1" onchange="isSame()"/></label>
				
				<button class="reg_bt">변경</button>
				
			</div>	
			
			
		</form>
		</div>
</body>
</html>