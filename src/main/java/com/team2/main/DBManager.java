package com.team2.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

//DB���� �۾��� �Ҷ� �Ź� �����ڵ带 �� ���� �۾� �ص�

//�װ� AOP ����
public class DBManager {

	//db�۾��ÿ� ��¶�� ���� �ؾߵ�
	public static Connection connect() throws SQLException {
<<<<<<< HEAD
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		return DriverManager.getConnection(url, "leeyoky", "leeyoky");
	}
	


// ������ ������ �ѹ��� �ݱ�
=======
		
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		return DriverManager.getConnection(url,"c##sj","sj");
	}
	
	//������ ������ �ѹ��� �ݱ�
>>>>>>> 6d246f22815e52f9c4e793f617e582d4460ad092
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
