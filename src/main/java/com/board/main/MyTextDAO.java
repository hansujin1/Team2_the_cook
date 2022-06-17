package com.board.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
		HttpSession hs = request.getSession();
        LoginB a = (LoginB) hs.getAttribute("loginInfo");
        
		String sql = "select * from board_table where board_id = ?";
		
		con = DBManager.connect();
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, a.getId());
		
		rs = pstmt.executeQuery();
		
		ArrayList<PostB> post = new ArrayList<PostB>();
	
			while (rs.next()) {
		
			PostB p = new PostB();
			
			p.setBoard_category(rs.getString("board_category"));
			p.setBoard_count(rs.getString("board_count"));
			p.setBoard_date(rs.getDate("board_date"));
			p.setBoard_file(rs.getString("board_file"));
			p.setBoard_id(rs.getString("board_id"));
			p.setBoard_like(rs.getString("board_like"));
			p.setBoard_number(rs.getString("board_number"));
			p.setBoard_title(rs.getString("board_title"));
			p.setBoard_txt(rs.getString("board_txt"));
			post.add(p);
			
		}
			
		request.setAttribute("post", post);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	 finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}
}