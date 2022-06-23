package com.team2.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

//DB관련 작업을 할때 매번 연결코드를 쓴 이후 작업 해둠

//그거 AOP 하자
public class DBManager {

	//db작업시엔 어쨋든 연결 해야됨
	public static Connection connect() throws SQLException {
		
		
//		  jdbc:oracle:thin:@DB20220512144545_medium?TNS_ADMIN=C:/Users/gks36/jin/Wallet_DB20220512144545
//		 * Connection con= DriverManager.getConnection(url,"ADMIN","Qwertyuiop135");
		

		String url ="jdbc:oracle:thin:@localhost:1521:xe";
<<<<<<< HEAD
		return DriverManager.getConnection(url,"leeyoky","leeyoky");
=======


		return DriverManager.getConnection(url,"c##sj","sj");
>>>>>>> 0cab66e9ab1e78833f1015e89ed8a6d99d4dc7ca





	}
	
	//닫을게 많은데 한번에 닫기
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			if (rs != null) {				
				rs.close();
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
