package com.team2.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team2.main.DBManager;

public class LoginDAO {

	public static boolean login(HttpServletRequest request) {

		String userId = request.getParameter("id");
		String userPw = request.getParameter("pw");

		Connection con = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		boolean isLogin = false;
		try {
			con = DBManager.connect();
			String sql = "select * from account_table where a_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();
			if (rs.next()) {

				if (userPw.equals(rs.getString("a_pw"))) {

					LoginB a = new LoginB();
					a.setId(rs.getString("a_id"));
					a.setName(rs.getString("a_name"));
					a.setPw(rs.getString("a_pw"));
					a.setMail(rs.getString("a_mail"));

					HttpSession hs = request.getSession();
					hs.setAttribute("loginInfo", a);
					hs.setMaxInactiveInterval(5 * 60);
					
					isLogin = true;
				} else {
					System.out.println("패스워드오류");
					
					
				}
			} else {
				System.out.println("존재 안함");
			}
			return isLogin; // try구문에

		} catch (Exception e) {
			e.printStackTrace();
			return isLogin; // 실패시 false 성공 true
		} finally {
			DBManager.close(con, pstmt, rs);
			
		}

	}

	public static void loginCheck(HttpServletRequest request) {
		// loin 확인하는 부분
		HttpSession hs = request.getSession();
		LoginB a = (LoginB) hs.getAttribute("loginInfo");

		if (a == null) {
			request.setAttribute("loginPage", "login/loginBefore.jsp");
		} else {
			request.setAttribute("loginPage", "login/loginAfter.jsp");
		}

	}

	public static void logOut(HttpServletRequest request) {
		// logOut

		HttpSession hs = request.getSession();
		hs.setAttribute("loginInfo", null);

	}

	public static void regAccount(HttpServletRequest request) {
		// 회원가입 부분
		Connection con = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {

			con = DBManager.connect();
			String sql = "insert into account_table values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			String name = request.getParameter("name");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String mail = request.getParameter("e_mail");
			System.out.println(name);

			
			  pstmt.setString(1, name); 
			  pstmt.setString(2, id); 
			  pstmt.setString(3, pw);
			  pstmt.setString(4, mail);
			 

			if (pstmt.executeUpdate() == 1) {
				System.out.println("가입성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public static void findPw(HttpServletRequest request) {
		// 비밀번호 찾기 기능
		
		String id = request.getParameter("find_id");
		String name = request.getParameter("find_name");
		String mail = request.getParameter("find_mail");
		
		Connection con = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;
		
		try {
			con = DBManager.connect();
			String sql = "select a_pw from account_table where a_name=? and a_id=? and a_mail=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, mail);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String pw = rs.getString("a_pw");
				request.setAttribute("findPw", pw);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public static void findId(HttpServletRequest request) {
		// find ID
		
		String name = request.getParameter("find_name");
		String mail = request.getParameter("find_mail");
		
		Connection con = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;
		
		try {
			con = DBManager.connect();
			String sql = "select a_id from account_table where a_name=? and a_mail=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, mail);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String id = rs.getString("a_id");
				request.setAttribute("findId", id);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
		
	}

	
	
}
