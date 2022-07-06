package com.board.heart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.main.BoardDAO;
import com.team2.login.LoginDAO;

@WebServlet("/likeC")
public class likeC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		LoginDAO.loginCheck(request);
		likeDAO.hitHeart(request);
		likeDAO.updateHeart(request);
		likeDAO.allHeart(request);
		
		request.getRequestDispatcher("ShowPostDetailController").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
