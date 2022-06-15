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
				<h2 id="reg_h2">회원 정보 수정</h2>
				<label class="reg_label"> <span>이름</span><br>
					<input class="reg_input" name="name" value="${sessionScope.loginInfo.name }"/></label>
					
				<label class="reg_label"> <span>아이디</span><br>
					${sessionScope.loginInfo.id }</label>
					
				<label class="reg_label"> <span>Password</span><br>
					<input class="reg_input" type="password" name="pw" onchange="isSame()" 
					value="${sessionScope.loginInfo.pw }" /></label>
					
				<label class="reg_label"> <span>Password</span><br>
					<input class="reg_input" type="password" name="pw1" onchange="isSame()"
					value="${sessionScope.loginInfo.pw }"/></label>
					
				<label class="reg_label"> <span>e-mail</span><br>
					${sessionScope.loginInfo.mail }</label>
					
				<button class="reg_bt">변경</button>
				
			</div>	
			
			
		</form>
		</div>
</body>
</html>