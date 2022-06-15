<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="BoardController" method="post"
		enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td><input name="title"></td>
			</tr>
			<tr>
				<td><textarea name="txt"></textarea><input type="hidden"
					name="category" value="${param.category}"></td>
			</tr>
			<tr>
				<td><input type="file" name="file">
					<button>업로드</button> ${param.category}</td>
			</tr>
		</table>
	</form>

</body>
</html>