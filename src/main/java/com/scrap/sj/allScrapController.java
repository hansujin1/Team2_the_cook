package com.scrap.sj;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.login.LoginDAO;

@WebServlet("/allScrapController")
public class allScrapController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//스크랩 게시글 전체 보기
		
		
		LoginDAO.loginCheck(request);
		scrapDAO.allScrap(request);
		request.setAttribute("title", "스크랩");
		request.setAttribute("contentPage", "scrap/scrap_list.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
