<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function valuecheck(){
	document.getElementById("userId").value=opener.document.regForm.id.value;
}
</script>
</head>
<body onload="valuecheck()">
<input type="text" name="idinput" id="userId">
<input type="button" value="중복확인" onclick=??>
</body>
</html>