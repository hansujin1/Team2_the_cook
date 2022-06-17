<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table class="create_B">
		<tr>
			<td class="title_P">${r.board_title}</td>
		</tr>
		<tr>
			<td><img class="imgs2" src="fileFolder/${r.board_file}"><br>
				${r.board_txt}</td>
		</tr>
		<tr>
			<td>
				<button type="button" class="update_P"
					onclick="location.href='UpdatePostController?num=${r.board_number}'">수정</button>
				<button type="button" class="del_P"
					onclick="location.href='DeletePostController?num=${r.board_number}&category=${r.board_category}'">삭제</button>
			</td>
		</tr>

		<tr>
			<td>조회수${r.board_count}</td>
		</tr>
		<tr>
			<td><fmt:formatDate value="${r.board_date}" type="both" dateStyle="short" timeStyle="short"/></td>
		</tr>

	</table>



</body>
</html>