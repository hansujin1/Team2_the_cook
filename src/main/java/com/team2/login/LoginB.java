package com.team2.login;

public class LoginB {
	private String name;
	private String id;
	private String pw;
	private String mail;

	public LoginB() {
		// TODO Auto-generated constructor stub
	}

	public LoginB(String name, String id, String pw, String mail) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
