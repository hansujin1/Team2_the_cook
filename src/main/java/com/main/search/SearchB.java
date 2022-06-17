package com.main.search;

import java.util.Date;

public class SearchB {

	String board_number;
	String board_id;
	Date board_date;
	String board_title; 
	String board_txt;
	String board_file;
	String board_like;
	String board_count;
	String board_category;
	String keyword;
	
	public SearchB() {
		// TODO Auto-generated constructor stub
	}
	
	public String getBoard_number() {
		return board_number;
	}

	public void setBoard_number(String board_number) {
		this.board_number = board_number;
	}

	public String getBoard_id() {
		return board_id;
	}

	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}

	public Date getBoard_date() {
		return board_date;
	}

	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_txt() {
		return board_txt;
	}

	public void setBoard_txt(String board_txt) {
		this.board_txt = board_txt;
	}

	public String getBoard_file() {
		return board_file;
	}

	public void setBoard_file(String board_file) {
		this.board_file = board_file;
	}

	public String getBoard_like() {
		return board_like;
	}

	public void setBoard_like(String board_like) {
		this.board_like = board_like;
	}

	public String getBoard_count() {
		return board_count;
	}

	public void setBoard_count(String board_count) {
		this.board_count = board_count;
	}

	public String getBoard_category() {
		return board_category;
	}

	public void setBoard_category(String board_category) {
		this.board_category = board_category;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public SearchB(String board_number, String board_id, Date board_date, String board_title, String board_txt,
			String board_file, String board_like, String board_count, String board_category, String keyword) {
		super();
		this.board_number = board_number;
		this.board_id = board_id;
		this.board_date = board_date;
		this.board_title = board_title;
		this.board_txt = board_txt;
		this.board_file = board_file;
		this.board_like = board_like;
		this.board_count = board_count;
		this.board_category = board_category;
		this.keyword = keyword;
	}

	
	
}
