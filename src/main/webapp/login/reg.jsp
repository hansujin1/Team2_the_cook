..<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="regController" method="post" name="regForm" onsubmit="return call()" >
		<div>
			<div>회원가입</div>
			<div>
				<div>이름</div>
				<div>
					<input name="name"  placeholder="필수">
				</div>
			</div>
			<div>
				<div>아이디</div>
				<div>
					<input name="id" placeholder="영어와 숫자로 5글자 이상">
				</div>
			</div>
			<div>
				<div>비밀번호</div>
				<div>
					<input type="password" name="pw" onchange="isSame()" placeholder="대소문자 숫자 포함 3글자 이상">
				</div>
			</div>
			<div>
				<div>비밀번호 제확인</div>
				<div>
					<input type="password" name="pw1" onchange="isSame()">
				</div>
			</div>
			<div>
				<div>e-mail</div>
				<div>
					<input type="email" name="e_mail" placeholder="필수">
				</div>
			</div>
		</div>
		<button>회원가입하기</button>
	</form>
</body>
</html>