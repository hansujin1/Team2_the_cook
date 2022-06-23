package com.team2.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.current.currentDAO;

@WebServlet("/regController")
public class regController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ȸ������ �������� �̵�
		LoginDAO.loginCheck(request);
		request.setAttribute("contentPage", "login/reg.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ȸ�������ϱ�
		
				LoginDAO.regAccount(request);
				currentDAO.popularList(request);
				LoginDAO.loginCheck(request);
				request.setAttribute("contentPage", "home.jsp");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			
	}

}
