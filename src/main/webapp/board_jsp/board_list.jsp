<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div id="mainWrapper">
        <ul>
            <li id="Table_n">
             <button class="text_Bt" onclick="location.href='BoardController?category=${param.category}'">
   					 글쓰기
   					 <img src="img/pencil.png" class="pencil">
   				 </button>
            <ul id="ulTable">
                <li><ul>
                    <li class="img">image</li>
                    <li class="left">제목</li>
                    <li class="user">user</li>
                    <li class="date">date</li>
                    <li class="no">no</li>
                </ul></li>
            <!-- 게시물이 출력될 영역 -->
            <c:forEach var="p" items="${post}">
                <li>
                    <ul id="ulTable">
                    
                        <li class="imgs"><img src="fileFolder/${p.board_file}"
                                    style="height: 100px"></li>
                        <li class="title" style="height:100px;"><a
                                    onclick="location.href='ShowPostDetailController?num=${p.board_number}'">${p.board_title}</a></li>
                        <li class="user" style="height:100px;">${p.board_id}</li>
                        <li class="date" style="height:100px;">${p.board_date}</li>
                        <li class="no" style="height:100px;">${p.board_number}</li>
                    </ul>
                </li>
            </c:forEach>
                </ul>
            <li>
                <div id="divPaging">
                    <div>◀</div>
                    <c:forEach var="i" begin="1" end="${lastpage}">
                    <div onclick="location.href='ShowBoardListController?vpage=${i}&lastpage=${lastpage}&category=${param.category}'">
                    <c:out value="${i}"/>
                    </div>
                    </c:forEach>
                    <div>▶</div>
                </div>
            </li>
        </ul>
    </div>
    
    
</body>
</html>