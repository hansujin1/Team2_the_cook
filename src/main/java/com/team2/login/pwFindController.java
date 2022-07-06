package com.team2.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pwFindController")
public class pwFindController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//비밀번호 찾기 페이지로 이동
		
		LoginDAO.loginCheck(request);
		request.setAttribute("contentPage", "login/pwFind.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//비밀번호 찾기 기능
		
		if (LoginDAO.findPw(request)) {
			LoginDAO.loginCheck(request);
			request.setAttribute("contentPage", "login/tellFindPw.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			LoginDAO.loginCheck(request);
			request.setAttribute("r", "다시 확인해주세요");
			request.setAttribute("contentPage", "login/pwFind.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
	}

}
