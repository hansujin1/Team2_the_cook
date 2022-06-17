<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = function() {
	const pw1 = document.getElementById('pw1');
	const pw2 = document.getElementById('pw2');
	const mydiv = document.getElementById('mydiv');
	
	pw2.addEventListener('keyup', () => {
			if(pw1.value != pw2.value){
				mydiv.innerHTML = "비번 불일치";
			} else{
				mydiv.innerHTML = "비번 일치!";
			}
		
		});
	
};
</script>

</head>
<body class="reg_body">

	<div class="reg">
	
	<form action="regController" method="post" name="regForm" ><!-- onsubmit="return call()" --> 
		
			<div>
				<h2 id="reg_h2">회원 가입</h2>
				<label class="reg_label"> <span>이름</span><br>
					<input class="reg_input" name="name" placeholder="필수" /></label>
					
				<label class="reg_label"> <span>아이디</span><br>
					<input class="reg_input" name="id" placeholder="영어와 숫자로 5글자 이상" /></label>
					
				<label class="reg_label"> <span>Password</span><br>
					<input id="pw1" class="reg_input" type="password" name="pw" onchange="isSame()" 
					placeholder="대소문자 숫자 포함 3글자 이상" /></label>
					
				<label class="reg_label"> <span>Password</span><br>
					<input id="pw2" class="reg_input" type="password" name="pw1" onchange="isSame()"
					placeholder="비밀번호 재확인" /></label>
					<div style="width: 200px; border: 1px solid black" id="mydiv"></div>
				<label class="reg_label"> <span>e-mail</span><br>
					<input class="reg_input" type="email" name="e_mail" placeholder="필수" /></label>
					
				<button class="reg_bt">JOIN</button>
				
			</div>	
			
			
		</form>
		</div>
	
	
</body>
</html>