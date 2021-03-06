package com.board.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comment.model.CommentDAO;
import com.mypage.like.MyLikeDao;
import com.scrap.sj.scrapDAO;
import com.team2.login.LoginDAO;
@WebServlet("/UpdatePostController")
public class UpdatePostController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginDAO.loginCheck(request);
		MyLikeDao.likeCheck(request);
		scrapDAO.scrapCheck(request);
		BoardDAO.showPost(request);
		request.setAttribute("contentPage", "board_jsp/updatepost.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO.updatePost(request);
		LoginDAO.loginCheck(request);
		
		if( BoardDAO.countCheck(request) == 0) {
			BoardDAO.updateCount(request, response);
		}
       
		MyLikeDao.likeCheck(request);
		scrapDAO.scrapCheck(request);
		BoardDAO.showPost(request);
		CommentDAO.showComment(request);
		request.setAttribute("contentPage", "board_jsp/post_details.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
