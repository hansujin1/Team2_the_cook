package com.mypage.like;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.heart.likeDAO;
import com.board.main.MyTextDAO;
import com.scrap.sj.scrapDAO;
import com.team2.login.LoginDAO;

@WebServlet("/MyLikeC")
public class MyLikeC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (LoginDAO.onlyLoginCan(request)) {

			if (MyLikeDao.likeCheck(request)) {
				LoginDAO.loginCheck(request);
				likeDAO.hitHeart(request);
				likeDAO.updateHeart(request);
				System.out.println("true");
			} else {
				LoginDAO.loginCheck(request);
				MyLikeDao.deleteLike(request);
				MyLikeDao.downHeart(request);
				System.out.println("false");
			}

			request.getRequestDispatcher("ShowPostDetailController").forward(request, response);
		} else {
			LoginDAO.loginCheck(request);
			request.setAttribute("contentPage", "login/login.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
