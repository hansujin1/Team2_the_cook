package com.board.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.login.LoginDAO;
@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(LoginDAO.onlyLoginCan(request)) {
			LoginDAO.loginCheck(request);
			request.setAttribute("contentPage", "board_jsp/createpost.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			LoginDAO.loginCheck(request);
			request.setAttribute("contentPage", "login/login.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDAO.loginCheck(request);
		BoardDAO.createPost(request);
		BoardDAO.showPostList_category(request);
		request.setAttribute("contentPage", "board_jsp/board_list.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
