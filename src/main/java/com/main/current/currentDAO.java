package com.main.current;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.board.main.PostB;
import com.team2.main.DBManager;

public class currentDAO {

	public static void latestList(HttpServletRequest request) {
		// 최신글 리스트

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from ( select rownum as rn, board_number, board_id, board_date, board_title, board_txt, board_file, board_like, board_count, board_category from ( select * from board_table order by board_date desc )) where rn between 1 and 6";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
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
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public static void popularList(HttpServletRequest request) {
		// 인기글 리스트

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from ( select rownum as rn, board_number, board_id, board_date, board_title, board_txt, board_file, board_like, board_count, board_category from ( select * from board_table order by board_like desc )) where rn between 1 and 6";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
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

			request.setAttribute("post1", post);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

}
	
	


