package com.team2.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myPageChangeController")
public class myPageChangeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//내 페이지 수정하기했을 때 비번 확인
		LoginDAO.loginCheck(request);
		request.setAttribute("contentPage", "login/mypageBefor_Check.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//마이페이지 수정하기전에 비밀번호확인기능
		if(LoginDAO.pwCheck(request)) {
			LoginDAO.loginCheck(request);
			request.setAttribute("contentPage", "login/mypageChange.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			LoginDAO.loginCheck(request);
			request.setAttribute("r", "다시 확인해주세요");
			request.setAttribute("contentPage", "login/mypageBefor_Check.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	
	}

}
