function call(){
	
	let name = document.regForm.name;
	let id = document.regForm.id;
	let pw = document.regForm.pw;
	let pw1 = document.regForm.pw1;
	
	if(isEmpty(name)){
		alert("이름을 입력하세요");
		name.focus();
		name.value="";
		
		return false;
	}
	
	if(lessThan(id,5) || containKR(id)){
		alert("조건에 맞게 ID를 작성해주세요");
		id.focus();
		id.value="";
		
		return false;
	}
	
	if(lessThan(pw,3)|| notContain(pw,"qwertyuiopasdfghjklzxcvbnm")||notContain(pw,"1234567890") ||notContain(pw,"QWERTYUIOPASDFGHJKLZXCVBNM")){
		alert("조건에 맞게 pw를 작성해주세요");
		pw.focus();
		pw.value="";
		
		return false;
	}
	
	if(match(pw,pw1)){
		alert("pw가 일치하지 않습니다");
		pw1.focus();
		pw1.value="";
		
		return false;
	}

}

function login_call(){
	let id = document.loginForm.id;
	let pw = document.loginForm.pw;
	
	if(isEmpty(id)){
		alert("아이디를 입력하세요");
		id.focus();
		id.value="";
		
		return false;
	}
	
	if(isEmpty(pw)){
		alert("비밀번호를 입력하세요");
		pw.focus();
		pw.value="";
		
		return false;
	}
}