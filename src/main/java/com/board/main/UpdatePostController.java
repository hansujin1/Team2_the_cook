package com.board.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.login.LoginDAO;
@WebServlet("/UpdatePostController")
public class UpdatePostController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginDAO.loginCheck(request);
		BoardDAO.showPost(request);
		request.setAttribute("contentPage", "board_jsp/updatepost.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDAO.loginCheck(request);
		BoardDAO.updatePost(request);
		BoardDAO.showPost(request);
		request.setAttribute("contentPage", "board_jsp/post_details.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
