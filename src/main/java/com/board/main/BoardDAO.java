package com.board.main;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team2.main.DBManager;

public class BoardDAO {
     
	//글쓰기--------------------------------------------------------
	public static void createPost(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board_table values (board_table_seq.nextval,'mz',sysdate,?,?,?,1,1,'1')";
		try {
		con = DBManager.connect();
		pstmt = con.prepareStatement(sql);
		String path = request.getSession().getServletContext().getRealPath("fileFolder");
		System.out.println(path);
		MultipartRequest mr;
		mr = new MultipartRequest(request, path, 20*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		
		String title = mr.getParameter("title");
		String txt = mr.getParameter("txt");
		String file = mr.getFilesystemName("file");
		
		pstmt.setString(1, title);
		pstmt.setString(2, txt);
		pstmt.setString(3, file);
		
		
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

	public static void showPost(HttpServletRequest request) {
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 String sql = "select * from board_table where board_number =?";
		 String board_number = request.getParameter("num");	
		 
		 try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board_number);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				PostB p = new PostB();
				p.setBoard_category(rs.getString("board_category"));
				p.setBoard_count(rs.getString("board_count"));
				p.setBoard_date(rs.getString("board_date"));
				p.setBoard_file(rs.getString("board_file"));
				p.setBoard_id(rs.getString("board_id"));
				p.setBoard_like(rs.getString("board_like"));
				p.setBoard_number(rs.getString("board_number"));
				p.setBoard_title(rs.getString("board_title"));
				p.setBoard_txt(rs.getString("board_txt"));
				request.setAttribute("r", p);
			}
			
			
			
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		 finally {
				DBManager.close(con, pstmt, rs);
			}
	}

	
	
	// 게시판 list 보여주기 ---------------------------------------------------
	public static void showPostList(HttpServletRequest request) {
		
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 String sql = "select * from board_table";
			try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			ArrayList<PostB> post = new ArrayList<PostB>();
			
			while (rs.next()) {
				PostB p = new PostB();
				
				p.setBoard_category(rs.getString("board_category"));
				p.setBoard_count(rs.getString("board_count"));
				p.setBoard_date(rs.getString("board_date"));
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
