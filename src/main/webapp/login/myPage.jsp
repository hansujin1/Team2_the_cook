<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="myPageChangeController" >
		
			<div>
				<h2 id="reg_h2">회원 정보</h2>
				<label class="reg_label"> <span>이름</span><br>
					${sessionScope.loginInfo.name }</label>
					
				<label class="reg_label"> <span>아이디</span><br>
					${sessionScope.loginInfo.id }</label>
					
				<label class="reg_label"> <span>e-mail</span><br>
					${sessionScope.loginInfo.mail }</label>
					
				<button class="reg_bt">수정하기</button>
				
			</div>	
			
			
		</form>
</body>
</html>