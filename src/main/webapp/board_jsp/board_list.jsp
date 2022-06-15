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
            <li id="Table_n">Board
            <ul id="ulTable">
                <li><ul>
                    <li>image</li>
                    <li>제목</li>
                    <li>date</li>
                    <li>user</li>
                      <li>no</li>
                </ul></li>
            <!-- 게시물이 출력될 영역 -->
            <c:forEach var="p" items="${post}">
                <li>
                    <ul>
                        <li class="img"><img src="fileFolder/${p.board_file}"
                                    style="height: 100px"></li>
                        <li class="left"><a
                                    onclick="location.href='ShowPostDetailController?num=${p.board_number}'">${p.board_title}</a></li>
                        <li>${p.board_date}</li>
                        <li>${p.board_id}</li>
                        <li>${p.board_number}</li>
                    </ul>
                </li>
            </c:forEach>
                </ul>
            <li>
                <div id="divPaging">
                    <div>◀</div>
                    <c:forEach var="i" begin="1" end="${lastpage}">
                    <div>
                    <a href="ShowBoardListController?vpage=${i}&lastpage=${lastpage}&category=${param.category}">
                    <c:out value="${i}"/>
                    </a>
                    </div>
                    </c:forEach>
                    <div>▶</div>
                </div>
            </li>
        </ul>
    </div>
    
    <button onclick="location.href='BoardController?category=${param.category}'">글쓰기</button>
    
</body>
</html>