<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<div>
			<c:if test="${empty post}">
					<div class="no_recipe_wrapper">
						<span class="no_recipe">Sorry!
						We Can't Find Recipe!</span>
						<h3>새로운 레시피를 공유해주세요<h3>
					</div>
					
			</c:if>
		</div>


</body>
</html>