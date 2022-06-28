package com.main.search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.board.main.PostB;
import com.team2.login.LoginB;
import com.team2.main.DBManager;

public class SearchDAO {

	public static void search(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from board_table where board_title like ?";
			
			// 특정 리스트 받아서 반환
			String board_title = request.getParameter("board_title");
			String a = "%"+ board_title +"%";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, a);
			
			
			System.out.println(board_title);
			
			rs = pstmt.executeQuery();


			ArrayList<SearchB> post = new ArrayList<SearchB>();
			
			if(rs.next()) {
				
				while (rs.next()) {

					SearchB s = new SearchB();

					s.setBoard_category(rs.getString("board_category"));
					s.setBoard_count(rs.getString("board_count"));
					s.setBoard_date(rs.getDate("board_date"));
					s.setBoard_file(rs.getString("board_file"));
					s.setBoard_id(rs.getString("board_id"));
					s.setBoard_like(rs.getString("board_like"));
					s.setBoard_number(rs.getString("board_number"));
					s.setBoard_title(rs.getString("board_title"));
					s.setBoard_txt(rs.getString("board_txt"));
					post.add(s);

				}	
				
				request.setAttribute("post", post);
				request.setAttribute("contentPage", "scrap/searchPage.jsp");
				
			} else {
				
				request.setAttribute("contentPage", "myPage/NoSearch.jsp");
			}
			


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

}
