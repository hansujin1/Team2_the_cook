package com.board.heart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.board.main.PostB;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team2.login.LoginB;
import com.team2.main.DBManager;

public class likeDAO {

	public static void hitHeart(HttpServletRequest request) {
		// 좋아요 하기
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into heart_table values (like_no_seq.nextval,?,?)";
		
		String board_number =  request.getParameter("num");
		HttpSession hs = request.getSession();
		
		LoginB a = (LoginB) hs.getAttribute("loginInfo");
		String id = a.getId();
		
		System.out.println(id);
		System.out.println(board_number);
		
		try {
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, board_number);
			pstmt.setString(2, a.getId());
			
			
			if (pstmt.executeUpdate() == 1){
				System.out.println("좋아요OK");
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

	public static void updateHeart(HttpServletRequest request) {
		// 좋아요수 증가
		Connection con = null;
		PreparedStatement pstmt = null;
		String board_number = request.getParameter("num");
		String sql = "update board_table set board_like = board_like + 1 where board_number = ?";
				
		
		try {
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, board_number);
			System.out.println(board_number);
			
			
			if (pstmt.executeUpdate() == 1){
				System.out.println("좋아요 수 증가");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
		
		
	}

	public static void allHeart(HttpServletRequest request) {
		// 좋아요 보여주기
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			con = DBManager.connect();
			
			HttpSession hs = request.getSession();
	        LoginB a = (LoginB) hs.getAttribute("loginInfo");
	        
	        String sql="select * from board_table where board_number in (select like_bno from heart_table where id = ?)ORDER BY board_date DESC";
			
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
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
		
		
		
		
		
	}

		
		
	}


