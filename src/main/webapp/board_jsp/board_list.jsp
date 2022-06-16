<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="mainWrapper">

		<li id="Table_n"></li>
		<button class="text_Bt"
			onclick="location.href='BoardController?category=${param.category}'">
			글쓰기 <img src="img/pencil.png" class="pencil">
		</button>

		<ul id="ulTable">
			<li>
				<div class="hidden"></div>
				<ul>
					<li class="img">image</li>
					<li class="left">제목</li>
					<li class="user">user</li>
					<li class="date">date</li>
					<li class="no">조회수</li>
				</ul>
			</li>
		</ul>
		<!-- 게시물이 출력될 영역 -->
		<div>
		
			<c:forEach var="p" items="${post}">
				<div class="ulTable">
				
				<div><img class="imgs" src="fileFolder/${p.board_file}"></div>
				<div class="left"><a onclick="location.href='ShowPostDetailController?num=${p.board_number}'">${p.board_title}</a></div>
				<div class="user">${p.board_id}</div>
				<div class="date">
				<fmt:formatDate value="${p.board_date}" type="date" dateStyle="short"/><br>
				<fmt:formatDate value="${p.board_date}" type="time" pattern="HH:mm"/> 
				</div>
				<div class="no"> ${p.board_count}</div>
					 
				</div>
			</c:forEach>
			
		</div>
		<div id="divPaging">
			<div>◀</div>
			<c:forEach var="i" begin="1" end="${lastpage}">
				<div
					onclick="location.href='ShowBoardListController?vpage=${i}&lastpage=${lastpage}&category=${param.category}'">
					<c:out value="${i}" />
				</div>
			</c:forEach>
			<div>▶</div>
		</div>

	</div>


</body>
</html>