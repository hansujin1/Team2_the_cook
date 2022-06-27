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

		<li id="Table_MP">
		MY TEXT
		</li>
	<ul id="ulTable">
			<li>
				<div class="hidden"></div>
				<ul>
					<li class="img">Image</li>
					<li class="title">Title</li>
					<li class="user">UserID</li>
					<li class="date" onclick="location.href='ShowBoardListController?vpage=1&lastpage=${lastpage}&category=${param.category}&count=0'">
					Date<img class="dates_calender" src="img/calender.png"></li>
					<li class="no" onclick="location.href='ShowBoardListController?vpage=1&lastpage=${lastpage}&category=${param.category}&count=1'">
					View</li>
					<li class="like" onclick="location.href='ShowBoardListController?vpage=1&lastpage=${lastpage}&category=${param.category}&count=2'">
					Like</li>
				</ul>
			</li>
		</ul>
		<!-- 게시물이 출력될 영역 -->
		<div>
		
			<c:forEach var="p" items="${post}">
				<div class="ulTable">
				
				<div><img class="imgs" src="fileFolder/${p.board_file}" onclick="location.href='ShowPostDetailController?num=${p.board_number}'"></div>
				<div class="titles"><a onclick="location.href='ShowPostDetailController?num=${p.board_number}'">${p.board_title}</a></div>
				<div class="users">${p.board_id}</div>
				<div class="dates">
				<fmt:formatDate value="${p.board_date}" type="date" dateStyle="short"/>
				<fmt:formatDate value="${p.board_date}" type="time" pattern="HH:mm"/> 
				</div>
				<div class="nos"> ${p.board_count}</div>
				<div class="likes">${p.board_like}</div>
				
					 
				</div>
			</c:forEach>
			
		</div>
		

	</div>


</body>
</html>