<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {

		$(".btn_toggle").click(function() {
			$(this).parent().find('div').toggle();
		});

	});
</script>
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
				<c:if test="${scrap == 1 }">
					<span onclick="location.href='doScrapController?num=${r.board_number}'"
						style="color: red;">스크랩</span>
				</c:if> 
				<c:if test="${scrap == 0 }">
					<span onclick="location.href='doScrapController?num=${r.board_number}'">스크랩</span>
				</c:if>
			</td>
		</tr>

	</table>

	<form action="CommentUploadController">
		<table class="create_B">
			<tr>
				<td>댓글쓰기 <input name="num" value="${r.board_number}"
					type="hidden">
				</td>
				<td><input name="contents">
				<button>작성</button></td>
			</tr>
		</table>
	</form>


	<c:if test="${comment != null}">
		<table class="create_B" border="">
			<tr>
				<td>작성자</td>
				<td>내용</td>
				<td>작성일</td>
			</tr>
			<c:forEach var="c" items="${comment}">
				<tr>
					<td>${c.c_id}</td>
					<td>${c.c_contents}</td>
					<td>${c.c_date}



						<button class="btn_toggle">수정</button>
						<button
							onclick="location.href='DeleteCommentController?commentnum=${c.c_no}&num=${r.board_number}'">삭제</button>

						<div style="display: none;">
							<form action="UpdateCommentControlle">
								<input name="commentnum" value="${c.c_no}" type="hidden">
								<input name="num" value="${r.board_number}" type="hidden">
								<br> 댓글수정 : <input name="contents">
								<button>수정완료</button>
							</form>
						</div>



					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>




</body>
</html>