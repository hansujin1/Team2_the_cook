package com.mypage.like;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.board.main.PostB;
import com.team2.main.DBManager;

public class MyLikeDao {

	public static void MyLike(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String like = request.getParameter("like");
		
		try	{
	        
			String sql = "select * from board_table where board_like = ?";
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, like);
			System.out.println(like);
			
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
