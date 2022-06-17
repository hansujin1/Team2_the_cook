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

		<div>
			TO.${sessionScope.loginInfo.name } <br> 안녕하세요 The Cook 운영진입니다. <br>
			항상 많이 부족하고 모자른 저희 커뮤니티를 아껴주시고 이용해주셔서 너무 감사합니다.<br> 저희 The Cook이
			${sessionScope.loginInfo.name } 고객님의 요리 항해에 함께 할 수 있어서 너무 기쁜 마음입니다. <br>
			저희 The Cook 운영진 일동은 ${sessionScope.loginInfo.name } 고객님께서 항상 행복하시고
			하시는 일이 모든 잘 되기를 기원합니다.<br> 다시 만나는 그 날 까지 저희는 더 많은 요리레시피와 더 좋은
			기능을 가지고 기다리겠습니다.<br> <br> From.GM 수진
		</div>

		<div>
			<div>회원 탈퇴 동의서</div>
			<div>
				사용하고 계신 아이디(${sessionScope.loginInfo.id })는 탈퇴할 경우 재사용 및 복구가 불가능
				합니다.<br> 탈퇴 후 회원정보는 삭제되지만, 올리신 글은 그대로 유지가 됩니다.<br>
			</div>
			<label for="agree"> <input type="checkbox" id="agree" onchange="agree()">
				위의 내용을 읽었으며, 내용에 동의합니다
			</label>
		</div>
		<button id="delete_bt" disabled="disabled" onclick="location.href='realdeleteController'">탈퇴하기</button>
		<button onclick="location.href='HC'">홈으로</button>
	</div>


</body>
<script type="text/javascript">
function agree() {
	let btn = document.getElementById('delete_bt');
	let a=btn.disabled;
	if(a){
		btn.disabled = false;
	}else {
		btn.disabled = true;
		
	}
}
</script>
</html>