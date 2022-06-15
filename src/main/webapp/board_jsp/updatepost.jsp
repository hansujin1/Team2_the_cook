<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="UpdatePostController" method="post" enctype="multipart/form-data">



<table border="1">
<tr>
<td><img src="fileFolder/${r.board_file}"></td>
</tr>
<tr>
<td><input name="title" value="${r.board_title}"></td>
</tr>
<tr>
<td><input name="txt" value="${r.board_txt}"></td>
</tr>
<tr>
<td>
<input name="file" type="file" value="${r.board_file}">사진수정
<input name="num" value="${r.board_number}" type="hidden">
</td>
</tr>
<tr>
<td><button>수정${r.board_number} </button></td>
</tr>
</table>
</form>




</body>
</html>