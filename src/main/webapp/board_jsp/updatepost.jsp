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

		<div class= "post_board">
				<div><img src="fileFolder/${r.board_file}"></div>
				<div><input name="title" value="${r.board_title}"></div>
				<div><textarea name="txt" value="${r.board_txt}"></textarea> </div>
				<div><input name="file" type="file" value="${r.board_file}">사진수정
					<input name="num" value="${r.board_number}" type="hidden">
				</div>
				<div><button>수정${r.board_number}</button></div>
		</div>
	</form>




</body>
</html>