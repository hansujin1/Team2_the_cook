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
		<table class = "create_B">
			<tr>
				<td><input class = "create_Binput" name="title"
				placeholder="제목을 입력해 주세요."></td>
			</tr>
			<tr>
				<td><textarea class = "create_Btxt" name="txt"
				placeholder="내용을 입력해 주세요."></textarea>
				<input type="hidden" name="category" value="${param.category}"></td>
			</tr>
			<tr>
				<td><input class = "create_Bfile" type="file" name="file">
					<button>업로드</button> ${param.category}</td>
			</tr>
		</table>
	</form>

</body>
</html>