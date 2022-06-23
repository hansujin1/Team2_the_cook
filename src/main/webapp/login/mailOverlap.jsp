<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="login_js/jQuery.js"></script>
<script type="text/javascript">
function valuecheck(){
	document.getElementById("mail").value=opener.document.regForm.email.value;
}

function use() {
	
	
	let inputMail = $("#mail").val();
	
	$.ajax({
	    type : 'post', // 타입 (get, post, put 등등)
	    url : 'login/emailOverlapCheck.jsp', // 요청할 서버url
	 //  async : true, 비동기화 여부 (default : true)
	    dataType : 'json', // 데이터 타입 (html, xml, json, text 등등)
	    data : { // 보낼 데이터 (Object , String, Array)
	      "mail" : inputMail //사용자가 입력한 인풋 값
	    },
	    success : function(result) { // 결과 성공 콜백함수
	        console.log(result.r); // 1 -> 있음 0 -> 없음
	         if(result.r ==1){
	        	 $('#showResult').text("이메일 중복입니다").css("color",'red');
	        	 userId.focus();
	        	 userId.value="";
	         }else {
	        	 $('#showResult').text("사용가능 이메일입니다").css("color","blue");	
	        	 document.getElementById("useId").style.visibility = "visible";
			}
	    },
	    error : function(request, status, error) { // 결과 에러 콜백함수
	        console.log(error)
	    }
    });
		
}
function pass() {
	$("#email", opener.document).val($("#mail").val());
	window.close();
	
}
</script>
</head>
<body onload="valuecheck()">

<input type="text" name="mailinput" id="mail">
<button onclick="use()">중복</button>

<br>
<span id="showResult"></span>
<br>
<input onclick="pass()" id="useId" type="button" value="사용하기"  style="visibility:hidden;">
<input type="button" value="창닫기" onclick="window.close()">

</body>
</html>