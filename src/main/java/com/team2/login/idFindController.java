package com.team2.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/idFindController")
public class idFindController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//아이디 찾기 페이지로 이동
		
		LoginDAO.loginCheck(request);
		request.setAttribute("contentPage", "login/idFind.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//아이디 찾아주는 기능
		LoginDAO.findId(request);
	
		LoginDAO.loginCheck(request);
		request.setAttribute("contentPage", "login/tellFindId.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
