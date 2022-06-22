package com.scrap.sj;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.login.LoginDAO;

@WebServlet("/doScrapController")
public class doScrapController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ũ���ϱ�
		if (LoginDAO.onlyLoginCan(request)) {
			
			if (scrapDAO.scrapCheck(request)) {
				LoginDAO.loginCheck(request);
				scrapDAO.addScrap(request);	
				System.out.println("��ũ���� ���⶧���� �� �ߵ�!!!");
			}else {
				LoginDAO.loginCheck(request);
				scrapDAO.deleteScrap(request);
				System.out.println("��ũ���� �ֱ⶧���� �����ߵ�!!!");
			}
			
			request.getRequestDispatcher("ShowPostDetailController").forward(request, response);
		}else {
			LoginDAO.loginCheck(request);
			request.setAttribute("contentPage", "login/login.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
			
		}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
