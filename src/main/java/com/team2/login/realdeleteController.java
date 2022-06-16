package com.team2.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/realdeleteController")
public class realdeleteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Å»ÅðÇÏ±â ±â´É
		
		LoginDAO.deleteAccount(request);
		LoginDAO.logOut(request);
		LoginDAO.loginCheck(request);
		request.setAttribute("contentPage", "login/deleteCheck.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
