<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
<%
String pageCss = null;
String vpage = request.getParameter("vpage");

if(vpage != null){
  if(vpage.length()>0){
      pageCss = "page"+vpage;
     }
} else{
      pageCss = "page"+"1";
}
%>

#<%=pageCss%>{
	font-weight:900;
	color:#ff0080;
}
</style>
</head>
<body>

	<div id="mainWrapper">
		<li id ="Table_n">
		<button class="text_Bt"
			onclick="location.href='BoardController?category=${param.category}'">
			WRITE 
			<img src="img/pencil.png" class="pencil">
		</button>
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
		<div id="divPaging">
			<div class="control">◀</div>
			<c:forEach var="i" begin="1" end="${lastpage}">
				<div onclick="location.href='ShowBoardListController?vpage=${i}&lastpage=${lastpage}&category=${param.category}&count=${count}'">
					<span id="page${i}"><c:out value="${i}" /></span>
				</div>
			</c:forEach>
			<div class="control">▶</div>
		</div>

	</div>


</body>
</html>