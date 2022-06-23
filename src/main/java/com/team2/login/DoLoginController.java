package com.team2.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.current.currentDAO;


@WebServlet("/DoLoginController")
public class DoLoginController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//로그 아웃하는 일
		LoginDAO.logOut(request);
		LoginDAO.loginCheck(request);
		currentDAO.latestList(request);
		currentDAO.popularList(request);
		request.setAttribute("contentPage", "home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//로그인 하는 일
		if (LoginDAO.login(request)) {
			 LoginDAO.loginCheck(request);
			 currentDAO.latestList(request);
			 currentDAO.popularList(request);
				request.setAttribute("contentPage", "home.jsp");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else {
			LoginDAO.loginCheck(request);
			request.setAttribute("r", "다시 확인해주세요");
			request.setAttribute("contentPage", "login/login.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		 //로그인 체크하기
		
	}

}
