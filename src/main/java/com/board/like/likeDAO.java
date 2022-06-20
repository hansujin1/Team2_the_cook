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
		String b_no =  request.getParameter("b_no");
		
		try {
			
			HttpSession hs = request.getSession();
			LoginB a = (LoginB) hs.getAttribute("loginInfo");
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, a.getId());
			pstmt.setString(2, b_no);
			
			System.out.println(b_no);
			
			if (pstmt.executeUpdate() == 1){
				System.out.println("좋아요 완료");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
		
		
	}

}
