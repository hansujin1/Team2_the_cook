package com.team2.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.main.BoardDAO;
import com.main.current.currentDAO;
import com.mypage.like.MyLikeDao;
import com.scrap.sj.scrapDAO;
import com.team2.login.LoginDAO;


@WebServlet("/HC")
public class HC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginDAO.loginCheck(request);
		/* BoardDAO.updateCount(request); */
		MyLikeDao.likeCheck(request);
		scrapDAO.scrapCheck(request);
		currentDAO.latestList(request);
		currentDAO.popularList(request);
		request.setAttribute("contentPage", "home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
