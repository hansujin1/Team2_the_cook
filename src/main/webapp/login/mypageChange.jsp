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
	
	<form action="myPageController" method="post" name="changePwForm" onsubmit="return changePw_call()">
		
			<div>
				<h2 id="reg_h2">비밀번호 변경</h2>
					
				<label class="reg_label"> <span>Password</span><br>
					<input class="reg_input" type="password" name="pw" onchange="isSame()"  /></label>
					
				<label class="reg_label"> <span>Password</span><br>
					<input class="reg_input" type="password" name="pw1" onchange="isSame()"/></label><br>
					<div>
					<div class="pw_alert" id="changePW_m" style="display:none;">비밀번호가 일치하지 않습니다</div>
					</div>
					
				
				<button class="reg_bt">변경</button>
				
			</div>	
			
			
		</form>
		</div>
</body>
</html>