<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function valuecheck(){
	document.getElementById("userMail").value=opener.document.regForm.email.value;
}
</script>
</head>
<body onload="valuecheck()">
<form action="emailOverlapCheckController" method="post">
<input type="text" name="mailinput" id="userMail">
<button>중복</button>
</form>
</body>
</html>