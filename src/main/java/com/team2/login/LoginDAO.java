package com.team2.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team2.main.DBManager;

public class LoginDAO {

	public static boolean login(HttpServletRequest request) {

		String userId = request.getParameter("id");
		String userPw = request.getParameter("pw");
		
		String n_id =(String) request.getAttribute("n_id");
		String n_pw =(String) request.getAttribute("n_pw");
		
		if (n_id != null) {
			userId = n_id;
			userPw = n_pw;
		}

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
					hs.setMaxInactiveInterval(60 *10 *5);
					
					isLogin = true;
				} else {
					
					System.out.println("�н��������");
					
					
				}
			} else {
				
				System.out.println("���� ����");
			}
			return isLogin; // try������
			

		} catch (Exception e) {
			e.printStackTrace();
			return isLogin; // ���н� false ���� true
		} finally {
			DBManager.close(con, pstmt, rs);
			
		}

	}

	public static void loginCheck(HttpServletRequest request) {
		// loin Ȯ���ϴ� �κ�
		HttpSession hs = request.getSession();
		LoginB a = (LoginB) hs.getAttribute("loginInfo");

		if (a == null) {
			request.setAttribute("loginPage", "login/loginBefore.jsp");
		} else {
			request.setAttribute("loginPage", "login/loginAfter.jsp");
		}

	}
	
	public static boolean onlyLoginCan(HttpServletRequest request) {
		// loin Ȯ���� ���¿����� ��ɰ�����
		HttpSession hs = request.getSession();
		LoginB a = (LoginB) hs.getAttribute("loginInfo");
		
		boolean isLoginOk = false;

		if (a != null) {
			isLoginOk = true;
		} 
		return isLoginOk;
	}

	public static void logOut(HttpServletRequest request) {
		// logOut

		HttpSession hs = request.getSession();
		hs.setAttribute("loginInfo", null);

	}

	public static void regAccount(HttpServletRequest request) {
		// ȸ������ �κ�
		Connection con = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {
			request.setCharacterEncoding("utf-8");
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
				System.out.println("���Լ���");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public static boolean findPw(HttpServletRequest request) {
		// ��й�ȣ ã�� ���
		
		
		
		Connection con = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;
		
		boolean isFindPw = false;
		
		try {
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("find_id");
			String name = request.getParameter("find_name");
			String mail = request.getParameter("find_mail");
			System.out.println(name);
			System.out.println(mail);
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
				
				isFindPw = true;
			}
			
			return isFindPw;
		} catch (Exception e) {
			e.printStackTrace();
			
			return isFindPw;
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public static boolean findId(HttpServletRequest request) {
		// find ID
		
		
		
		Connection con = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;
		
		boolean isFindId = false;
		
		try {
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("find_name");
			String mail = request.getParameter("find_mail");
			con = DBManager.connect();
			String sql = "select a_id from account_table where a_name=? and a_mail=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, mail);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String id = rs.getString("a_id");
				request.setAttribute("findId", id);
				
				isFindId = true;
			}
			
			return isFindId;
		} catch (Exception e) {
			e.printStackTrace();
			return isFindId;
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
		
	}

	public static boolean pwCheck(HttpServletRequest request) {
		// ���� �����ϱ� �� ��й�ȣ üũ�ϱ�
		
		HttpSession hs = request.getSession();
		LoginB a = (LoginB) hs.getAttribute("loginInfo");
		String check = request.getParameter("check_pw2");
		
		boolean isPwCheck =false;
		
		if (check.equals(a.getPw())) {
			
			isPwCheck = true;
		}
		
		return isPwCheck;
	}

	public static void changePw(HttpServletRequest request) {
		
		//��й�ȣ ����
		
		String pw = request.getParameter("pw");
		HttpSession hs = request.getSession();
		LoginB a = (LoginB) hs.getAttribute("loginInfo");
		
		Connection con = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;
		
		try {
			
			con = DBManager.connect();
			String sql ="update account_table set a_pw =? where a_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, a.getId());
			
			request.setAttribute("n_id", a.getId());
			request.setAttribute("n_pw", pw);
			
			if (pstmt.executeUpdate() ==1) {
				System.out.println("����");
			}else {
				System.out.println("����");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
	}

	public static void deleteAccount(HttpServletRequest request) {
		//Ż�� ���
		
		Connection con = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;
		
		HttpSession hs = request.getSession();
		LoginB a = (LoginB) hs.getAttribute("loginInfo");
		
		try {
			con = DBManager.connect();
			String sql="delete account_table where a_id=? ";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, a.getId());
			
			if (pstmt.executeUpdate() ==1) {
				System.out.println("����");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public static void overlapID(HttpServletRequest request) {
		// ID overlap
		
		Connection con = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;
		
		try {
			String inputId = request.getParameter("idinput");
			
			
			con = DBManager.connect();
			String sql ="select a_id from account_table where a_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inputId);
			
			rs=pstmt.executeQuery();
			if (rs.next()) {
				request.setAttribute("mse", "����� �� ���� ���̵��Դϴ�.");
				request.setAttribute("id", inputId);
			}else {
				request.setAttribute("mse", "����� �� �ִ� ���̵��Դϴ�");
				request.setAttribute("id", inputId);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
	}

	public static void mailOverlap(HttpServletRequest request) {
		//�̸��� �ߺ� üũ
		
		Connection con = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;
		
		try {
			String mail = request.getParameter("mailinput");
			
			
			con = DBManager.connect();
			String sql ="select a_mail from account_table where a_mail=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mail);
			
			rs=pstmt.executeQuery();
			if (rs.next()) {
				request.setAttribute("mse", "����� �� ���� �̸����Դϴ�.");
				request.setAttribute("mail", mail);
			}else {
				request.setAttribute("mse", "����� �� �ִ� �̸����Դϴ�");
				request.setAttribute("mail", mail);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	



	
	
}
