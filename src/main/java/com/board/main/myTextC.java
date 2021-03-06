package com.board.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.login.LoginDAO;
@WebServlet("/myTextC")
public class myTextC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		LoginDAO.loginCheck(request);
		MyTextDAO.MyText(request);
		request.setAttribute("contentPage", "myPage/myTxt.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("contentPage", "myPage/myTxt_list.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
