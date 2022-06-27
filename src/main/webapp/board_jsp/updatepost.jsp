<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

$(function() {
	
	$("#file").on('change',function() {
 	 var fileName = $("#file").val();
  	$(".upload-name").val(fileName);
	});
	
});

</script>
</head>
<body>
	<form name="board" action="UpdatePostController" method="post"
		enctype="multipart/form-data" onsubmit="return callCheck()">

		<table class = "update_B">
			<tr>
				<td><input class="update_title" name="title" value="${r.board_title}"
				placeholder="수정할 제목을 입력하세요."></td>
			</tr>
			<tr>
				<td><img class = "imgs3" src="fileFolder/${r.board_file}"></td>
			</tr>
			<tr>
				<td><input class="update_txt" name="txt" value="${r.board_txt}"></td>
			</tr>

			<tr class="filebox">
				<td>
					<input class="upload-name" name="file" placeholder="첨부할 사진을 선택해 주세요.">
   			 		<label for="file">찾기</label> 
   			 		<input type="file" id="file" name="file">
   			 		<button class = "create_upload">업로드</button>
					<input name="num" value="${r.board_number}" type="hidden">
					<input name="oldfile" value="${r.board_file}" type="hidden">
				</td>
			</tr> 
		</table>
	</form>




</body>
</html>