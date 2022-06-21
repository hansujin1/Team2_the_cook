package com.scrap.sj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.board.main.PostB;
import com.team2.login.LoginB;
import com.team2.main.DBManager;

public class scrapDAO {

	public static void addScrap(HttpServletRequest request) {
		// ��ũ���ϱ�
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();
			
			String num =  request.getParameter("num");
			HttpSession hs = request.getSession();
			LoginB a = (LoginB) hs.getAttribute("loginInfo");
			String id = a.getId();
			System.out.println(num);
			System.out.println(id);
			
			String sql ="insert into scrap_table values (scrap_table_seq.nextval,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.setString(2, id);
			
			if(pstmt.executeUpdate()==1) {
				System.out.println("��ũ���� �����߽��ϴ� ����...��");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

	public static boolean scrapCheck(HttpServletRequest request) {
		
		// ��ũ�� üũ�ϱ�
		
		HttpSession hs = request.getSession();
		LoginB a = (LoginB) hs.getAttribute("loginInfo");
		
		if (a != null) {
			
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		boolean isCheck = false;
		try {
			con = DBManager.connect();
			String sql = "select * from scrap_table where scrap_boardNum = ? and scrap_id=?";
			
			//���ޱ�
			String num =  request.getParameter("num");
			
			String id = a.getId();
			
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.setString(2, id);
			
			rs=pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("��ũ�� �Ǿ�����");
				request.setAttribute("scrap", 1);
			}else {
				System.out.println("��ũ�� �ȵǾ� ����");
				request.setAttribute("scrap", 0);
				isCheck = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		return isCheck;
	}else {
		request.setAttribute("scrap", 0);
		return true;
	}
	}

	public static void deleteScrap(HttpServletRequest request) {
		// ��ũ�� ����ϱ�
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();
			String sql ="delete scrap_table where scrap_boardNum = ? and scrap_id=?";
	
			//���ޱ�
			String num =  request.getParameter("num");
			HttpSession hs = request.getSession();
			LoginB a = (LoginB) hs.getAttribute("loginInfo");
			String id = a.getId();

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, num);
			pstmt.setString(2, id);
			
			if (pstmt.executeUpdate()==1) {
				System.out.println("��������� �ȴٱ�!!!!!����!!! �Ǿ��!!���� ����");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, null);
		}
		
		
	}

	public static void allScrap(HttpServletRequest request) {
		// ��ũ�������ֱ�
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.connect();
			
			//���ޱ�
			HttpSession hs = request.getSession();
	        LoginB a = (LoginB) hs.getAttribute("loginInfo");
	        
	        String sql="select * from board_table where board_number in (select scrap_boardNum from scrap_table where scrap_id=?)";
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
