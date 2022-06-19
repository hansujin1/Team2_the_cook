<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>

		<div class="Say">
			<h2>${sessionScope.loginInfo.name }셰프님!</h2>
			<br> <span class="Good">안녕하세요 The Cook 운영진입니다. <br>
				항상 많이 부족하고 모자른 저희 커뮤니티를 아껴주시고 이용해주셔서 너무 감사합니다.<br>
				${sessionScope.loginInfo.name } 셰프님의 요리 항해에 함께 할 수 있어서 너무 기쁜
				마음이었습니다. <br> The Cook 운영진 일동은 ${sessionScope.loginInfo.name }
				셰프님께서 항상 행복하시고 하시는 일이 모두 잘 되기를 기원합니다♥<br> 지속적인 레시피 업데이트와 더욱더
				다양한 기능을 구현할 수 있도록 일동 노력하겠습니다.
			</span><br>
			<p class="Bye">- The Cook 개발팀 수진 -
			<p>

				<img src="img/Pretzel.png"> <img src="img/Pretzel.png">
				<img src="img/Pretzel.png"> <img src="img/Pretzel.png">
		</div>

		<div class="delete_acc">
			<h4>※ 회원 탈퇴 동의서</h4>
			<div class="delete_txt">
				사용하고 계신 아이디(${sessionScope.loginInfo.id })는 탈퇴할 경우 재사용 및 복구가 불가능
				합니다.<br> 탈퇴 후 회원정보는 삭제되지만, 올리신 글은 그대로 유지가 됩니다.<br>
			</div>
			<label class="agree" for="agree"> 위의 내용을 읽었으며, 내용에 동의합니다 <input
				type="checkbox" id="agree" onchange="agree()">
			</label>
			<button id="delete_bt" disabled="disabled"
				onclick="location.href='realdeleteController'">탈퇴하기</button>
			<button onclick="location.href='HC'">홈으로</button>
		</div>
	</div>


</body>
<script type="text/javascript">
	function agree() {
		let btn = document.getElementById('delete_bt');
		let a = btn.disabled;
		if (a) {
			btn.disabled = false;
		} else {
			btn.disabled = true;

		}
	}
</script>
</html>