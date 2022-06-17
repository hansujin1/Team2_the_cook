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
	
		//�� ������ �����ϱ����� �� ��� Ȯ��
		LoginDAO.loginCheck(request);
		request.setAttribute("contentPage", "login/mypageBefor_Check.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//���������� �����ϱ����� ��й�ȣȮ�α��
		if(LoginDAO.pwCheck(request)) {
			LoginDAO.loginCheck(request);
			request.setAttribute("contentPage", "login/mypageChange.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			LoginDAO.loginCheck(request);
			request.setAttribute("r", "�ٽ� Ȯ�����ּ���");
			request.setAttribute("contentPage", "login/mypageBefor_Check.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	
	}

}
