<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class = "post_board">
	
			<div>${r.board_title}</div>
			
			<div><img src="fileFolder/${r.board_file}"></div>
			
			<div>${r.board_txt}</div>
			
			<div>
				<button type="button"
					onclick="location.href='UpdatePostController?num=${r.board_number}'">수정</button>
				<button
					onclick="location.href='DeletePostController?num=${r.board_number}&category=${r.board_category}'">삭제</button>
			</div>
	</div>
	${r.board_category}

</body>
</html>