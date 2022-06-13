<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="BoardController" method="post" enctype="multipart/form-data">
<table border="1">
<tr>
<td><input name="title"></td>
</tr>
<tr>
<td><textarea name="txt"></textarea></td>
</tr>
<tr>
<td><input type="file" name="file">
<button>업로드</button>
</td>
</tr>
</table>
</form>

</body>
</html>