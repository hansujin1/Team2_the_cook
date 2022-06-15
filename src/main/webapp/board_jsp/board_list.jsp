<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table border="1" width="700px" style="text-align: center; margin-left: auto; margin-right: auto;">
<tr>
<td>이미지</td>
<td>제목</td>
<td>날짜</td>
<td>작성자</td>
<td>글번호</td>
</tr>
<c:forEach var="p" items="${post}">
<tr>
<td><img src="fileFolder/${p.board_file}" style="height: 100px"></td>
<td><a onclick="location.href='ShowPostDetailController?num=${p.board_number}'">${p.board_title}</a></td>
<td>${p.board_date}</td>
<td>${p.board_id}</td>
<td>${p.board_number}</td>
</tr>
</c:forEach>
</table>
<button type="button" onclick="location.href='BoardController?category=${param.category}'">글쓰기</button>


</body>
</html>