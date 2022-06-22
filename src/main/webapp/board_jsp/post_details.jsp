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

	<table class="details_B">
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
				src="fileFolder/${r.board_file}"> 
				<div style="white-space: pre;"><c:out value="${r.board_txt}"/></div>
			</td>
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
				<c:if test="${likeCk == 1 }">
					<span onclick="location.href='MyLikeC?num=${r.board_number}'"
						style="color: red;">♥${r.board_like}</span>
				</c:if> 
				
				
				<c:if test="${likeCk == 0 }">
					<span onclick="location.href='MyLikeC?num=${r.board_number}'">♡${r.board_like}</span>
				</c:if>
			
				<%-- <button class="heart" name="like"
					onclick="location.href='likeC?num=${r.board_number}'">♥</button> <span
				class="like">좋아요 ${r.board_like}</span> --%>
				
				
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




	<c:if test="${comment != null}">
		<table class="create_B" border="">

			<c:forEach var="c" items="${comment}">
				<div class="list_C">
					<label class="c_id"><span>${c.c_id}</span></label> 
					<label class="c_com"><span>${c.c_contents}</span></label> 
					<label class="c_date"><span>${c.c_date}</span></label>
					<button class="btn_toggle">수정</button>
					<button	class="btn_del" onclick="location.href='DeleteCommentController?commentnum=${c.c_no}&num=${r.board_number}'">
					삭제</button>

					<div style="display: none;">
						<form action="UpdateCommentControlle">
							<input name="commentnum" value="${c.c_no}" type="hidden">
							<input name="num" value="${r.board_number}" type="hidden">
							<br> <span class="update_comment"> 
							<input class ="re_contents" name="contents" placeholder="수정할 댓글 내용을 입력하세요."> </span> 
							<button class="btn_Update">수정완료</button>
						</form>
					</div>
				</div>



			</c:forEach>
		</table>

		<form action="CommentUploadController">
			<table class="create_C">
				<tr>
					<td><span class="comment">댓글</span></td>
				</tr>
				<tr>
					<td><input name="num" value="${r.board_number}" type="hidden">
						<input class="contents" name="contents"	placeholder="댓글을 남겨보세요 :)">
						<button class="contents_btn">작성</button></td>
				</tr>
			</table>
		</form>
	</c:if>




</body>
</html>