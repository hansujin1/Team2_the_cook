package com.scrap.sj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.team2.login.LoginB;
import com.team2.main.DBManager;

public class scrapDAO {

	public static void addScrap(HttpServletRequest request) {
		// 스크랩하기
		
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
				System.out.println("스크랩이 성공했습니다 제발...ㅎ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

	public static boolean scrapCheck(HttpServletRequest request) {
		// 스크랩 체크하기
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		boolean isCheck = false;
		try {
			con = DBManager.connect();
			String sql = "select * from scrap_table where scrap_boardNum = ? and scrap_id=?";
			
			//값받기
			String num =  request.getParameter("num");
			HttpSession hs = request.getSession();
			LoginB a = (LoginB) hs.getAttribute("loginInfo");
			String id = a.getId();
			
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.setString(2, id);
			
			rs=pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("스크랩 되어있음");
				request.setAttribute("scrap", 1);
			}else {
				System.out.println("스크랩 안되어 있음");
				request.setAttribute("scrap", 0);
				isCheck = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		return isCheck;
	}

	public static void deleteScrap(HttpServletRequest request) {
		// 스크랩 취소하기
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();
			String sql ="delete scrap_table where scrap_boardNum = ? and scrap_id=?";
	
			//값받기
			String num =  request.getParameter("num");
			HttpSession hs = request.getSession();
			LoginB a = (LoginB) hs.getAttribute("loginInfo");
			String id = a.getId();

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, num);
			pstmt.setString(2, id);
			
			if (pstmt.executeUpdate()==1) {
				System.out.println("삭제기능이 된다구!!!!!제발!!! 되어라!!나를 위해");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, null);
		}
		
		
	}

}
