package com.comment.model;

import java.sql.Date;

public class CommentBean

{
	private int c_no;
	private int c_boardnumber;
	private String c_id;
	private Date c_date;
	private String c_contents;
	public CommentBean() {
		// TODO Auto-generated constructor stub
	}
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public int getC_boardnumber() {
		return c_boardnumber;
	}
	public void setC_boardnumber(int c_boardnumber) {
		this.c_boardnumber = c_boardnumber;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public Date getC_date() {
		return c_date;
	}
	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}
	public String getC_contents() {
		return c_contents;
	}
	public void setC_contents(String c_contents) {
		this.c_contents = c_contents;
	}
	public CommentBean(int c_no, int c_boardnumber, String c_id, Date c_date, String c_contents) {
		super();
		this.c_no = c_no;
		this.c_boardnumber = c_boardnumber;
		this.c_id = c_id;
		this.c_date = c_date;
		this.c_contents = c_contents;
	}
	

}
