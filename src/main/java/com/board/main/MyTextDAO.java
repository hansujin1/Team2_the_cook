package com.board.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team2.login.LoginB;
import com.team2.main.DBManager;

public class MyTextDAO {

	public static void MyText(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
	try	{
		
		String sql = "select * from board_table where board_id = ?";
		con = DBManager.connect();
		pstmt = con.prepareStatement(sql);
		
		String id = request.getParameter("id");
		pstmt.setString(1, id);
		
		String path = request.getSession().getServletContext().getRealPath("fileFolder");
		System.out.println(path);
		MultipartRequest mr;
		mr = new MultipartRequest(request, path, 20*1024*1024, "utf-8", new DefaultFileRenamePolicy());
	
		rs = pstmt.executeQuery();
	
		
		if (rs.next()){
			PostB a = new PostB();
			a.setBoard_category(rs.getString("board_category"));
			a.setBoard_count(rs.getString("board_count"));
			a.setBoard_date(rs.getString("board_date"));
			a.setBoard_file(rs.getString("board_file"));
			a.setBoard_id(rs.getString("board_id"));
			a.setBoard_like(rs.getString("board_like"));
			a.setBoard_number(rs.getString("board_number"));
			a.setBoard_title(rs.getString("board_title"));
			a.setBoard_txt(rs.getString("board_txt"));
		}
		
		} catch (Exception e) {
		}
	 finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}
}