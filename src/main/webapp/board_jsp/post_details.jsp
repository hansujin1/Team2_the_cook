<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<td class="view_c"><fmt:formatDate value="${r.board_date}"
					type="both" dateStyle="short" timeStyle="short" /> <span>
					조회 ${r.board_count} </span></td>
		</tr>
		<tr>
			<td class="txt_c"><img class="imgs2"
				src="fileFolder/${r.board_file}"><br> ${r.board_txt}</td>
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
			<td>
				<button class="heart" name="like"
					onclick="location.href='likeC?num=${r.board_number}'">♥</button> 
					<span class="like">좋아요 ${r.board_like}</span>
			</td>
		</tr>

	</table>

	<c:if test="${comment != null}">
		<c:forEach var="c" items="${comment}">
			<div class="list_C">
					<label class="c_id"><span>${c.c_id}</span></label>
					<label class="c_com"><span>${c.c_contents}</span></label>
					<label class="c_date"><span >${c.c_date}</span></label>
					
			</div>
		</c:forEach>
	</c:if>
	<form action="CommentUploadController">
		<table class="create_C">
			<tr>
				<td><span class="comment">댓글</span></td>
			</tr>
			<tr>
				<td><input name="num" value="${r.board_number}" type="hidden">
					<input class="contents" name="contents" placeholder="댓글을 남겨보세요 :)">
					<button class="contents_btn">작성</button></td>
			</tr>
		</table>
	</form>






</body>
</html>