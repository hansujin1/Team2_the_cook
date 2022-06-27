function call(){
	
	let name = document.regForm.name;
	let id = document.regForm.id;
	let pw = document.getElementById('pw1');
	let pw1 = document.getElementById('pw2');
	let mail = document.regForm.e_mail;
	
	if(isEmpty(name)){
		alert("이름을 입력하세요");
		name.focus();
		name.value="";
		
		return false;
	}
	if(isEmpty(id)){
		alert("id 입력하세요");
		id.focus();
		id.value="";
		
		return false;
	}
	if(isEmpty(pw)){
		alert("pw 입력하세요");
		pw.focus();
		pw.value="";
		
		return false;
	}
	if(isEmpty(pw1)){
		alert("재 확인pw 입력하세요");
		pw1.focus();
		pw1.value="";
		
		return false;
	}
	if(isEmpty(mail)){
		alert("이메일 입력하세요");
		mail.focus();
		mail.value="";
		
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
	
	if(regForm.overlapIDCheck.value !='idcheck'){
		alert("아이디 중복체크를 해주세요");
		
		return false;
	}
	if(regForm.overlapmailCheck.value !='mailcheck'){
		alert("메일 중복체크를 해주세요");
		
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

function pwFind_call(){
	let id = document.pwFindForm.find_id;
	let name = document.pwFindForm.find_name;
	let mail = document.pwFindForm.find_mail;
	
	if(isEmpty(id)){
		alert("아이디를 입력하세요");
		id.focus();
		id.value="";
		
		return false;
	}
	
	if(isEmpty(name)){
		alert("이름을 입력하세요");
		name.focus();
		name.value="";
		
		return false;
	}
	
	if(isEmpty(mail)){
		alert("이메일을 입력하세요");
		mail.focus();
		mail.value="";
		
		return false;
	}
	
}

function idFind_call(){
	let name = document.idFindForm.find_name;
	let mail = document.idFindForm.find_mail;
	
	
	if(isEmpty(name)){
		alert("이름을 입력하세요");
		name.focus();
		name.value="";
		
		return false;
	}
	
	if(isEmpty(mail)){
		alert("이메일을 입력하세요");
		mail.focus();
		mail.value="";
		
		return false;
	}
	
}

function pw_call(){
	let pw = document.pwForm.check_pw2;
	
	if(isEmpty(pw)){
		alert("비밀번호를 입력해주세요");
		pw.focus();
		
		return false;
	}
}

function changePw_call(){
	let pw =document.getElementById('pw1');
	let pw1 =document.getElementById('pw2');
	
	
	if(isEmpty(pw)){
		alert("변경하실 비밀번호를 입력해주세요");
		pw.focus();
		
		return false;
	}
	
	if(isEmpty(pw1)){
		alert("재확인 비밀번호를 입력해주세요");
		pw1.focus();
		
		return false;
	}
	if(lessThan(pw,3)|| notContain(pw,"qwertyuiopasdfghjklzxcvbnm")||notContain(pw,"1234567890") ||notContain(pw,"QWERTYUIOPASDFGHJKLZXCVBNM")){
		alert("조건에 맞게 pw를 작성해주세요");
		pw.focus();
		pw.value="";
		
		return false;
	}
	
	
}

