function callCheck() {
	let title = document.board.title;
	let txt = document.board.txt;
	let file = document.board.txt;


	if (isEmpty(title) || isEmpty(txt) || isEmpty(file) ) {
		alert("내용을 입력하세요!")
		this.focus;
		return false;
	}
	
	
	if (maxlength(title, 30)) {
		alert('제목이 너무 길어요!');
		this.focus();
		this.value = "";
		return false;
	}




}

function checkComment() {
	let comment = document.commentForm.contents;


	if (isEmpty(comment)) {
		alert("내용을 입력하세요!")
		this.focus;
		return false;
	}
	
	
	if (maxlength(title, 250)) {
		alert('내용이 너무 길어요!');
		this.focus();
		this.value = "";
		return false;
	}


}

function checkUpdateComment() {
	let comment = document.updateComment.contents;


	if (isEmpty(comment)) {
		alert("내용을 입력하세요!")
		this.focus;
		return false;
	}
	
	
	if (maxlength(title, 250)) {
		alert('내용이 너무 길어요!');
		this.focus();
		this.value = "";
		return false;
	}


}

function checkdelete() {
 return confirm("정말 삭제하시겠습니까?");
}

