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
/*  				mydiv.innerHTML = "비번 일치!"; */
			}
		
		});
	
};
</script>
</head>
<body>
<div class="reg">
	
	<form action="myPageController" method="post" name="changePwForm" onsubmit="return changePw_call()">
		
			<div>
				<h2 id="reg_h2">비밀번호 변경</h2>
					
				<label class="reg_label"> <span>Password</span><br>
					<input class="reg_input" type="password" name="pw" id="pw1" onchange="isSame()"  /></label>
					
				<label class="reg_label"> <span>Password</span><br>
					<input class="reg_input" type="password" name="pw1" id="pw2" onchange="isSame()"/></label>
					<div class="mydiv" id='mydiv'></div>

				<button class="reg_bt">변경</button>
				
			</div>	
			
			
		</form>
		</div>
</body>
</html>