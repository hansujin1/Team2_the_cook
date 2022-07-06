<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function() {
	  let toggle = false;
	
	$("#boxx").click(function() {
		if(toggle){
          $(this).css("transform","matrix(1, 0, 0, 1, 0, 0)");
          $("#txt").toggle();
      } else {
          $(this).css("transform","rotate(45deg)");
          $("#txt").toggle();
		}
	
	     toggle = !toggle;
	
	       
	});
	
});
</script>
</head>
<body>

<div>
<div id="boxx">+</div>



</div>



</body>
</html>