<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
<tr>
<td>${r.board_title}</td>
</tr>
<tr>
<td><img src="fileFolder/${r.board_file}"><br>${r.board_txt}</td>
</tr>

</table>


</body>
</html>