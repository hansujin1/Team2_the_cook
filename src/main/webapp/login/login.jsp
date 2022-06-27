<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body class="login_body">

	<div class="login_cont">
	
	<form action="DoLoginController" method="post" name="loginForm" onsubmit="return login_call()">

		<div class="login_txt sign-in">
			<h2 class="login_h2">Welcome!</h2>
			
			<label class="login_label"> <span>ID</span> 
			<input class="login_input" name="id" />
			</label> <label class="login_label"> <span>Password</span> 
			<input class="login_input" name="pw" type="password" />
			</label>
			<span class="pw_alert">${r}</span>
			<p class="forgot-pass" onclick="location.href='idFindController'">아이디를 잊으셨나요?</p>
			<p class="forgot-pass" onclick="location.href='pwFindController'">비밀번호를 잊으셨나요?</p>
			<button class="login_bt">LOGIN</button>
			


		</div>

		<div class="sub-cont">
			<div class="login_img">
				<div class="login_img__text m--up">
					<h2 class="login_h2">첫 방문이신가요?</h2>
					<p>당신의 레시피를 공유해주세요!</p>
				</div>

				<div class="login_img__btn">
					<button type="button" class="joinBt" onclick="location.href='regController'">JOIN</button>
				</div>
			</div>

		</div>

</form>
	</div>


</body>
</html>