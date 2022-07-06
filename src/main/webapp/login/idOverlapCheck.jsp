<%@page import="org.json.simple.JSONObject"%>
<%@page import="com.team2.main.DBManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = (String)request.getParameter("id");

Connection con = null;

PreparedStatement pstmt = null;

ResultSet rs = null;

try {

	con = DBManager.connect();
	String sql ="select a_id from account_table where a_id=?";
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, id);
	
	rs=pstmt.executeQuery();
	
	JSONObject jo = new JSONObject();
	
	if (rs.next()) {
		jo.put("r", "1");
	}else {
		jo.put("r", "0");
	}
	
	response.setContentType("application/json");
	out.print(jo.toJSONString());
	
} catch (Exception e) {
	e.printStackTrace();
}finally {
	DBManager.close(con, pstmt, rs);
}


%>