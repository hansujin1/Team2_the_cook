package com.team2.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteController")
public class deleteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 탈퇴 누르면 비밀번호 확인 페이지로 넘기기
		LoginDAO.loginCheck(request);
		request.setAttribute("contentPage", "login/deleteMyInformation.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//탈퇴 동의서
		
		LoginDAO.loginCheck(request);
		request.setAttribute("contentPage", "login/deleteOk.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
