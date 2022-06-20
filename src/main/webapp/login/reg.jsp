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
				mydiv.innerHTML = "비밀번호 불일치";
			} else{
				mydiv.innerHTML = "비밀번호 일치"; 
			}
		
		});
	
};

function overlapCheck()  {
	let id =regForm.id;
	if (id.value=="") {
		alert("아이디를 입력해주세요");
		id.focus();
	}else {
		
		window.open('overlapIdcheckController','overlapCheck','width=300,height=250');
	}
	}
	
function overlapCheckMail() {
	let mail=regForm.e_mail;
	if (mail.value=="") {
		alert("이메일을 입력해주세요");
		mail.focus();
	}else {
		window.open('emailOverlapCheckController','overlapCheck','width=300,height=250');
	}
}
</script>

</head>
<body class="reg_body">

	<div class="reg">

		<form action="regController" method="post" name="regForm"
			onsubmit="return call()">

			<div>
				<h2 id="reg_h2">회원 가입</h2>
				<label class="reg_label"> <span>이름</span><br> <input
					class="reg_input" name="name" placeholder="필수" /></label> <label
					class="reg_label"> <span>아이디</span><br> <input
					class="reg_input" name="id" id="id" placeholder="영어와 숫자로 5글자 이상" />
					<input id='overlap' type='button' onclick='overlapCheck()'
					value='중복 체크' /></label> 
					 <label class="reg_label">
					<span>Password</span><br> <input id="pw1" class="reg_input"
					name="pw" onchange="isSame()" placeholder="대소문자 숫자 포함 3글자 이상" />
				</label> <label class="reg_label"> <span>Password</span><br> <input
					id="pw2" class="reg_input" name="pw1" onchange="isSame()"
					placeholder="비밀번호 재확인" /></label>

				<!-- 비밀번호 일치 불일치 -->
				<p class="mydiv" id="mydiv"></p>


				<label class="reg_label"> <span>e-mail</span><br> <input
					class="reg_input" id="email" type="email" name="e_mail" placeholder="필수" />
					<input id='overlapMail' type='button' onclick='overlapCheckMail()'
					value='중복 체크' /> 
					</label>
					

				<button class="reg_bt">JOIN</button>

			</div>


		</form>

	</div>



</body>
</html>