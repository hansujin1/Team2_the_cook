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
		
		//��й�ȣ ã�� �������� �̵�
		
		LoginDAO.loginCheck(request);
		request.setAttribute("contentPage", "login/pwFind.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��й�ȣ ã�� ���
		
		if (LoginDAO.findPw(request)) {
			LoginDAO.loginCheck(request);
			request.setAttribute("contentPage", "login/tellFindPw.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			LoginDAO.loginCheck(request);
			request.setAttribute("r", "�ٽ� Ȯ�����ּ���");
			request.setAttribute("contentPage", "login/pwFind.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
	}

}
