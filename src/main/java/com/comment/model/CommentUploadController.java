package com.comment.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.main.BoardDAO;
import com.team2.login.LoginDAO;
@WebServlet("/CommentUploadController")
public class CommentUploadController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	LoginDAO.loginCheck(request);
	CommentDAO.commentUp(request);
	BoardDAO.updateCount(request);
	BoardDAO.showPost(request);
	CommentDAO.showComment(request);
	request.setAttribute("contentPage", "board_jsp/post_details.jsp");
    request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}