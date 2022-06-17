<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdatePostController" method="post"
		enctype="multipart/form-data">

		<table class = "update_B">
			<tr>
				<td><input class="update_title" name="title" value="${r.board_title}"
				placeholder="수정할 제목을 입력하세요."></td>
			</tr>
			<tr>
				<td><img class = "imgs3" src="fileFolder/${r.board_file}"></td>
			</tr>
			<tr>
				<td><input class="update_txt" name="txt" value="${r.board_txt}"></td>
			</tr>
			<tr>
				<td><input class = "update_Bfile" name="file" type="file" value="${r.board_file}">
					<input name="num" value="${r.board_number}" type="hidden">
					<button class = "update_Bfile2">수정</button>
				</td>
			</tr>
		</table>
	</form>




</body>
</html>