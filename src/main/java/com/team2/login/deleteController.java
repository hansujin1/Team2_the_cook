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
		
		// Ż�� ������ ��й�ȣ Ȯ�� �������� �ѱ��
		LoginDAO.loginCheck(request);
		request.setAttribute("contentPage", "login/deleteMyInformation.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Ż�� ���Ǽ�
		
		LoginDAO.loginCheck(request);
		request.setAttribute("contentPage", "login/deleteOk.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
