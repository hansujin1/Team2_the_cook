package com.team2.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.team2.main.DBManager;

public class LoginDAO {

	public static void login(HttpServletRequest request) {
		
		String userId = request.getParameter("id");
		String userPw = request.getParameter("pw");
		
		Connection con =null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rs =null;
		
		
		try {
			con=DBManager.connect();
			String sql ="select * from account_table where a_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				
				if (userPw.equals(rs.getString("a_pw"))) {
					
					
					LoginB a= new LoginB();
					a.setId(rs.getString("a_id"));
					a.setName(rs.getString("a_name"));
					a.setPw(rs.getString("a_pw"));
					a.setMail(rs.getString("a_mail"));
					
					HttpSession hs=request.getSession();
					hs.setAttribute("loginInfo", a);
					hs.setMaxInactiveInterval(5*60);
				}else {
					System.out.println("패스워드오류");
				}
			}else {
				System.out.println("존재 안함");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public static void loginCheck(HttpServletRequest request) {
		//loin 확인하는 부분
		HttpSession hs = request.getSession();
		LoginB a = (LoginB) hs.getAttribute("loginInfo");
		
		if (a==null) {
			request.setAttribute("loginPage", "login/loginBefore.jsp");
		}else {
			request.setAttribute("loginPage", "login/loginAfter.jsp");
		}
		
	}

	public static void logOut(HttpServletRequest request) {
		// logOut
		
		HttpSession hs = request.getSession();
		hs.setAttribute("loginInfo", null);
		
	}

}
