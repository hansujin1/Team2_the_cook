package com.comment.model;

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

public class CommentDAO {

	public static void commentUp(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into comment_table values(comment_table_seq.nextval, ?, ?, ?, sysdate)";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			HttpSession hs = request.getSession();
			
			String boardnumber = request.getParameter("num");
			String contents = request.getParameter("contents");
			LoginB a = (LoginB) hs.getAttribute("loginInfo");
			String id = a.getId();		
			
			pstmt.setString(1, boardnumber);
			pstmt.setString(2, id);
			pstmt.setString(3, contents);
			
			if (pstmt.executeUpdate() == 1){
				System.out.println("등록성공");
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	 finally {
			DBManager.close(con, pstmt, null);
		}
	
	}

	public static void showComment(HttpServletRequest request) {
       
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 
		 String board_num = request.getParameter("num");
		 String sql = "select * from comment_table where c_boardnumber = ?";
		 try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board_num);
			
			rs = pstmt.executeQuery();
			
			ArrayList<CommentBean> comment = new ArrayList<CommentBean>();
			
		    while (rs.next()) {
		    	CommentBean c = new CommentBean();
		    	c.setC_boardnumber(rs.getInt("c_boardnumber"));
				c.setC_contents(rs.getString("c_contents"));
				c.setC_date(rs.getDate("c_date"));
				c.setC_id(rs.getString("c_id"));
				c.setC_no(rs.getInt("c_no"));
				comment.add(c);
		    }
			 
		    request.setAttribute("comment", comment);
			
			
			
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		 finally {
				DBManager.close(con, pstmt, rs);
			}
		
	}

	
	public static void deleteComment(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete comment_table where c_no =?";
		try {
		con = DBManager.connect();
		pstmt = con.prepareStatement(sql);
		
		String c_no= request.getParameter("commentnum");
		
		pstmt.setString(1, c_no);
		
		
		if (pstmt.executeUpdate() == 1){
			System.out.println("삭제성공");
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	 finally {
			DBManager.close(con, pstmt, null);
		}
	
	
	
	}
	
	public static void updatePost(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
    try {
		String sql = "update comment_table set c_contents = ? where c_no = ?";
    	String commentnum = request.getParameter("commentnum");
    	String contents = request.getParameter("contents");
		
    	con = DBManager.connect();
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, contents);
		pstmt.setString(2, commentnum);
		
			
			
    	if (pstmt.executeUpdate()==1) {
		 System.out.println("변경완료");
    	}
         
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, null);
		}
	
}
	
	
	
	public static void showComment_detail(HttpServletRequest request) {
	       
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 
		 String c_no = request.getParameter("commentnum");
		 String sql = "select * from comment_table where c_no = ?";
		 try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, c_no);
			
			rs = pstmt.executeQuery();
			
			ArrayList<CommentBean> comment = new ArrayList<CommentBean>();
			
		    while (rs.next()) {
		    	CommentBean c = new CommentBean();
		    	c.setC_boardnumber(rs.getInt("c_boardnumber"));
				c.setC_contents(rs.getString("c_contents"));
				c.setC_date(rs.getDate("c_date"));
				c.setC_id(rs.getString("c_id"));
				c.setC_no(rs.getInt("c_no"));
				comment.add(c);
		    }
			 
		    request.setAttribute("comment", comment);
			
			
			
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		 finally {
				DBManager.close(con, pstmt, rs);
			}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
