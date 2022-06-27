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

	<form name="board" action="BoardController" method="post"
		enctype="multipart/form-data" onsubmit="return callCheck()">
		<table class = "create_B">
			<tr>
				<td><input class = "create_Binput" name="title"
				placeholder="제목을 입력해 주세요."></td>
			</tr>
			<tr>
				<td><textarea class = "create_Btxt" name="txt"
				placeholder="내용을 입력해 주세요."></textarea>
				<input type="hidden" name="category" value="${param.category}"></td>
			</tr>
			<tr class="filebox">
    			<td>
    				<input class="upload-name" name="file" placeholder="첨부할 사진을 선택해 주세요.">
   			 		<label for="file">찾기</label> 
   			 		<input type="file" id="file" name="file">
   			 		<button class = "create_upload">업로드</button>
   			 	</td>
			</tr>
			</table>
	</form>

</body>
</html>