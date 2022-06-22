package com.mypage.like;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.board.main.PostB;
import com.team2.login.LoginB;
import com.team2.main.DBManager;

public class MyLikeDao {
	// ���� ���ƿ��� ��
	public static void MyLike(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try	{
			HttpSession hs = request.getSession();
	        LoginB a = (LoginB) hs.getAttribute("loginInfo");
			String sql = "select * from board_table where board_number in (select like_bno from heart_table where id = ?)";
			// sql �����ϱ�
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
	
public static boolean likeCheck(HttpServletRequest request) {
		
		// ���ƿ� üũ�ϱ�
		
		HttpSession hs = request.getSession();
		LoginB a = (LoginB) hs.getAttribute("loginInfo");
		
		if (a != null) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean isLikeCheck = false;
		try {
			con = DBManager.connect();
			String sql = "select * from heart_table where like_bno = ? and id=?";
			
			//���ޱ�
			String num =  request.getParameter("num");
			
			String id = a.getId();
			
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.setString(2, id);
			
			rs=pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("�̹� ���ƿ� �� ���Դϴ�.");
				request.setAttribute("likeCk", 1);
			}else {
				System.out.println("���ƿ並 ����մϴ�.");
				request.setAttribute("likeCk", 0);
				isLikeCheck = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		return isLikeCheck;
	}else {
		request.setAttribute("likeCk", 0);
		return true;
	}
	}

public static void deleteLike(HttpServletRequest request) {
	// ���ƿ� ����ϱ�
	
	Connection con = null;
	PreparedStatement pstmt = null;
	try {
		con = DBManager.connect();
		String sql ="delete heart_table where like_bno = ? and id=?";

		//���ޱ�
		String num =  request.getParameter("num");
		HttpSession hs = request.getSession();
		LoginB a = (LoginB) hs.getAttribute("loginInfo");
		String id = a.getId();

		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, num);
		pstmt.setString(2, id);
		
		if (pstmt.executeUpdate()==1) {
			System.out.println("���ƿ� ����");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		DBManager.close(con, pstmt, null);
	}
	
	
}

}
