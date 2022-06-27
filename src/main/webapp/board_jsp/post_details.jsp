<%@page import="com.team2.login.LoginB"%>
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

	

			
	
	
		
		$(".contents").click(function() {
			let a = $(".contents2").val();
			if (a == "") {
				alert("로그인 해주세요");
			}
				
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
		
			<td class="view_c">
				<span class="view_cnt">
				<fmt:formatDate value="${r.board_date}"	
					type="both" dateStyle="short" timeStyle="short" /> 
				 조회 ${r.board_count} </span>
					
				<c:if test="${likeCk == 1 }">
					<span onclick="location.href='MyLikeC?num=${r.board_number}'"
						style="color: red;" >♥</span>
						<span class="like"> 좋아요</span>
				</c:if> 
				<c:if test="${likeCk == 0 }">
					<span onclick="location.href='MyLikeC?num=${r.board_number}'"
						style="" id="test_contents">♡</span>
						<span class="like"> 좋아요</span>
				
				</c:if> 
					<span class="like">${r.board_like}</span>
				<c:if test="${scrap == 1 }">
					<span onclick="location.href='doScrapController?num=${r.board_number}'"
						style="color: black; font-weight: 800; cursor: pointer;">스크랩 한 게시물입니다.</span>
				</c:if> 
				<c:if test="${scrap == 0 }">
					<span onclick="location.href='doScrapController?num=${r.board_number}'"
						style="color: gray;" id="test_contents">스크랩</span>
				</c:if></td>
				
		</tr>
		
		<tr>
			<td class="txt_c"><img class="imgs2"
				src="fileFolder/${r.board_file}"> 
				<div style="white-space: pre;"><c:out value="${r.board_txt}"/></div>
			</td>
		</tr>
		
		<tr>
			<c:if test="${r.board_id == sessionScope.loginInfo.id}">
			<td>
				<button type="button" class="update_P"
					onclick="location.href='UpdatePostController?num=${r.board_number}'">수정</button>
				<button type="button" class="del_P"
					onclick="location.href='DeletePostController?num=${r.board_number}&category=${r.board_category}&file=${r.board_file}'">삭제</button>
			</td>
			</c:if>	
		</tr>
		
	</table>




	<c:if test="${comment != null}">
<!-- 		<table class="create_B" border="">
 -->
			<c:forEach var="c" items="${comment}">
				<div class="list_C">
					<label class="c_id"><span>${c.c_id}</span></label> 
					<label class="c_com"><span>${c.c_contents}</span></label> 
					<label class="c_date"><span>${c.c_date}</span></label>
					
					
					<c:if test="${c.c_id == sessionScope.loginInfo.id}">
					<button class="btn_toggle">수정</button>
					<button	class="btn_del" onclick="location.href='DeleteCommentController?commentnum=${c.c_no}&num=${r.board_number}'">
					삭제</button>
                    </c:if>
                    
					<div class="div_toggle" style="display: none;">
						<form name="updateComment" action="UpdateCommentControlle" onsubmit="return checkUpdateComment()">
							<input name="commentnum" value="${c.c_no}" type="hidden">
							<input name="num" value="${r.board_number}" type="hidden">
							<br> <span class="update_comment"> 
							<input class ="re_contents" name="contents" placeholder="수정할 댓글 내용을 입력하세요."> </span> 
							<button class="btn_Update">수정완료</button>
						</form>
					</div>
				</div>



			</c:forEach>
<!-- 		</table>
 -->
		<form name="commentForm" action="CommentUploadController" onsubmit="return checkComment()">
			<table class="create_C">
				<tr>
					<td><span class="comment">댓글</span></td>
				</tr>
				<tr>
					<td><input name="num" value="${r.board_number}" type="hidden">
						<input class="contents" name="contents"	placeholder="댓글을 남겨보세요 :)">
						<button class="contents_btn">작성</button></td>
						<input class="contents2" value="${sessionScope.loginInfo }" type="hidden">
				</tr>
			</table>
		</form>
	</c:if>
	
</body>
</html>