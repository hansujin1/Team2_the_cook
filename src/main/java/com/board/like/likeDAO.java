package com.board.like;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.board.main.PostB;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team2.login.LoginB;
import com.team2.main.DBManager;

public class likeDAO {

	public static void getHeart(HttpServletRequest request) {

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
				System.out.println("좋아요");
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
		
		
	}

	public static void updateHeart(HttpServletRequest request) {
		
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
				System.out.println("좋아요한 글");
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
		
		
	}

		
		
	}


