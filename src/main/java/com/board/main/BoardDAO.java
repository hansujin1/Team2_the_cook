package com.board.main;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.apache.catalina.connector.Response;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team2.login.LoginB;
import com.team2.main.DBManager;

public class BoardDAO {
     
	//글쓰기--------------------------------------------------------
	public static void createPost(HttpServletRequest request) {
		
		
		HttpSession Http = request.getSession();
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board_table values (board_table_seq.nextval,?,sysdate,?,?,?,0,0,?)";
		try {
		con = DBManager.connect();
		pstmt = con.prepareStatement(sql);
		String path = request.getSession().getServletContext().getRealPath("fileFolder");
		System.out.println(path);
		MultipartRequest mr;
		mr = new MultipartRequest(request, path, 20*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		
		
		LoginB a = (LoginB) Http.getAttribute("loginInfo");
		
		String sessioncategory = (String) Http.getAttribute("categorySession");
		
		String id = a.getId();
		String title = mr.getParameter("title");
		String txt = mr.getParameter("txt");
		String file = mr.getFilesystemName("file");
        String category = mr.getParameter("category");
        if(category.length() != 0) {
        	Http.setAttribute("categorySession", category);
        }
       
       
		
		pstmt.setString(1, id);
        pstmt.setString(2, title);
		pstmt.setString(3, txt);
		pstmt.setString(4, file);
		if (category.length() != 0) {
			pstmt.setString(5, category);
		} else {
			System.out.println(sessioncategory);
			pstmt.setString(5, sessioncategory);
		}
		
		
		
		
		
		
		
		if (pstmt.executeUpdate() == 1){
			System.out.println("등록성공");
			
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	 finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

	
	
	
	
	public static void showPost(HttpServletRequest request) {
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 String sql = "select * from board_table where board_number =?";
		 String board_number = request.getParameter("num");	
		 String num = (String)request.getAttribute("num");
		 
		 try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			if(num != null) {
				pstmt.setString(1, num);
			}else {
				pstmt.setString(1, board_number);
			}
			
			
			rs = pstmt.executeQuery();
			
			
			
			if(rs.next()) {
				PostB p = new PostB();
				p.setBoard_category(rs.getString("board_category"));
				p.setBoard_count(rs.getString("board_count"));
				p.setBoard_date(rs.getDate("board_date"));
				p.setBoard_file(rs.getString("board_file"));
				p.setBoard_id(rs.getString("board_id"));
				p.setBoard_like(rs.getString("board_like"));
				p.setBoard_number(rs.getString("board_number"));
				p.setBoard_title(rs.getString("board_title"));
				p.setBoard_txt(rs.getString("board_txt"));
				request.setAttribute("r", p);
			}
			
			String category = request.getParameter("category");
			request.setAttribute("category", category);
		
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		 finally {
				DBManager.close(con, pstmt, rs);
			}
	}

	
	
	// 전체 게시판 list 보여주기 ---------------------------------------------------
	public static void showPostList(HttpServletRequest request) {
		
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 
		 String sql = "select * from board_table";
			try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			ArrayList<PostB> post = new ArrayList<PostB>();
			
			while (rs.next()) {
				PostB p = new PostB();
				
				p.setBoard_category(rs.getString("board_category"));
				p.setBoard_count(rs.getString("board_count"));
				p.setBoard_date(rs.getDate("board_date"));
				p.setBoard_file(rs.getString("board_file"));
				p.setBoard_id(rs.getString("board_id"));
				p.setBoard_like(rs.getString("board_like"));
				p.setBoard_number(rs.getString("board_number"));
				p.setBoard_title(rs.getString("board_title"));
				p.setBoard_txt(rs.getString("board_txt"));
				post.add(p);
			}
			
			request.setAttribute("post", post);
			
			
			
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		 finally {
				DBManager.close(con, pstmt, rs);
			}
	}

	// 카테고리별 게시판 리스트
	public static void showPostList_category(HttpServletRequest request) {
		
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 String category1 = (String) request.getAttribute("category");
		 
		 
		 String sql = "select * from ( select rownum as rn, board_number, board_id, board_date, board_title, board_txt, board_file, board_like, board_count, board_category from ( select * from board_table where board_category = ? order by board_date desc )) where rn between 1 and 10";
		 String category = request.getParameter("category");
		 HttpSession HttpSession = request.getSession();
		 String sessionecategory = (String) HttpSession.getAttribute("categorySession");
		 
		 
		 try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
	        if (category1!=null) {
			    pstmt.setString(1, category1);
			
			} else if(category!=null) {
				pstmt.setString(1, category);
		    } else {
				pstmt.setString(1, sessionecategory);
			}
			
			
			rs = pstmt.executeQuery();
			

			
			ArrayList<PostB> post = new ArrayList<PostB>();
			
			while (rs.next()) {
				PostB p = new PostB();
				
				p.setBoard_category(rs.getString("board_category"));
				p.setBoard_count(rs.getString("board_count"));
				p.setBoard_date(rs.getDate("board_date"));
				p.setBoard_file(rs.getString("board_file"));
				p.setBoard_id(rs.getString("board_id"));
				p.setBoard_like(rs.getString("board_like"));
				p.setBoard_number(rs.getString("board_number"));
				p.setBoard_title(rs.getString("board_title"));
				p.setBoard_txt(rs.getString("board_txt"));
				post.add(p);
			}
			
			request.setAttribute("post", post);
			
			
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		 finally {
				DBManager.close(con, pstmt, rs);
			}
		
	}


	public static void deletePost(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete board_table where board_number=?";
		try {
		con = DBManager.connect();
		pstmt = con.prepareStatement(sql);
		String path = request.getSession().getServletContext().getRealPath("fileFolder");
		System.out.println(path);
		String num= request.getParameter("num");
		String file = request.getParameter("file");
		
		pstmt.setString(1, num);
		
		
		if (pstmt.executeUpdate() == 1){
			System.out.println("삭제성공");
			String delFile = path + "/" + file; 
			File f = new File(delFile);
			f.delete();
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	 finally {
			DBManager.close(con, pstmt, null);
		}
	
	
	
	}

	public static void updatePost(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
    try {
    	int pstmtNum = 3;
    	MultipartRequest mr;
    	String path = request.getSession().getServletContext().getRealPath("fileFolder");
    	mr = new MultipartRequest(request, path, 20*1024*1024, "utf-8", new DefaultFileRenamePolicy());
    	String title = mr.getParameter("title");
		String txt = mr.getParameter("txt");
		String number = mr.getParameter("num");
		
		String newfile = mr.getFilesystemName("file");
		String oldfile = mr.getParameter("oldfile");
		
		String sql = "update board_table set board_title=?,board_txt=?,board_file=? where board_number=?";
		
		if(newfile == null) {
			sql="update board_table set board_title=?,board_txt=? where board_number=?";
		}
		
		
		
    	con = DBManager.connect();
		pstmt = con.prepareStatement(sql);
		
		
		
        pstmt.setString(1, title);
        pstmt.setString(2, txt);
        if(newfile != null) {
        	pstmtNum = 4;
        	pstmt.setString(3, newfile);
        	String delFile = path + "/" + oldfile;  
 			File f = new File(delFile);
 			f.delete();
        } 
        
        
        pstmt.setString(pstmtNum, number);
			
        
        
        
			
    	if (pstmt.executeUpdate()==1) {
		 System.out.println("변경완료");
		 request.setAttribute("num", number);
    	}
         
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, null);
		}
	
}

	public static void lastpage(HttpServletRequest request) {
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 String category1 = (String) request.getAttribute("category");
		 
		 String sql = "select count(*) from board_table where board_category = ?";
		 String category = request.getParameter("category");
		 try {
			
	     HttpSession HttpSession1 = request.getSession();
	     String sessioncategory = (String) HttpSession1.getAttribute("categorySession");
			 
			 
			 
			 con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			 if (category1 != null) {
				    pstmt.setString(1, category1);
				
				} else if(category != null) {
					pstmt.setString(1, category);
			    } else {
			    	pstmt.setString(1, sessioncategory);
			    }
			
			
			
			
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
			
				int total = rs.getInt("COUNT(*)");
			    int lastpage = (int) Math.ceil((double)total/10);
			    request.setAttribute("lastpage", lastpage);
			}
			  
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		 finally {
				DBManager.close(con, pstmt, rs);
			}
		
	}
    
	
	public static void showpage(HttpServletRequest request) {
	  
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String category1 = (String) request.getAttribute("category");
		//System.out.println("카테고리1:"+category1);
		String category = request.getParameter("category");
		//System.out.println("카테고리:"+category);
		String vpage = request.getParameter("vpage");
		String count = request.getParameter("count");
         

	   if( vpage == null) {
		   vpage = "1";
	   }
		
	  int page = Integer.parseInt(vpage);
	  int rnStart = 1;
	  int rnEnd = 10;
	  
	  if(page != 1) {
		 rnStart = page*10-9;
		 rnEnd = rnStart+9;
	  } 

	  
	  
	   
	  String sql ="select * from ( select rownum as rn, board_number, board_id, board_date, board_title, board_txt, board_file, board_like, board_count, board_category from ( select * from board_table where board_category = ? order by board_date desc )) where rn between ? and ?";
	  
	
	  
	  if(count != null) {
		  
		  if(count.length()>0) {
		  
		  sql="select * from ( select rownum as rn, board_number, board_id, board_date, board_title, board_txt, board_file, board_like, board_count, board_category from ( select * from board_table where board_category = ? order by board_count desc )) where rn between ? and ?";
	      request.setAttribute("count", count);
		  }
	  }
	 
	  
	  
	  try {
		   con = DBManager.connect();
		   pstmt = con.prepareStatement(sql);
		   
		   
		   
		   HttpSession hs = request.getSession();
		   String sessionecategory = (String) hs.getAttribute("categorySession");
		  // System.out.println("세션"+Sessionecategory);
           
		 
		   
		   
	        if (category1!=null) {
			    pstmt.setString(1, category1);
			
			} else if(category!=null) {
				pstmt.setString(1, category);
		    } else {
				pstmt.setString(1, sessionecategory);
			}
			
			pstmt.setInt(2, rnStart);
			pstmt.setInt(3, rnEnd);
			
			
			rs = pstmt.executeQuery();
			

			
			ArrayList<PostB> post = new ArrayList<PostB>();
			
			while (rs.next()) {
				PostB p = new PostB();
				
				p.setBoard_category(rs.getString("board_category"));
				p.setBoard_count(rs.getString("board_count"));
				p.setBoard_date(rs.getDate("board_date"));
				p.setBoard_file(rs.getString("board_file"));
				p.setBoard_id(rs.getString("board_id"));
				p.setBoard_like(rs.getString("board_like"));
				p.setBoard_number(rs.getString("board_number"));
				p.setBoard_title(rs.getString("board_title"));
				p.setBoard_txt(rs.getString("board_txt"));
				post.add(p);
			}
			
			request.setAttribute("post", post);
			
			if (category1!=null) {
				request.setAttribute("category",category1);
				
			} else {
				request.setAttribute("category",category);
			}
			
			
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		 finally {
				DBManager.close(con, pstmt, rs);
			}
		
	}

	
	// 조회수 증가
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void updateCount(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Cookie[] cookies = request.getCookies();
		
		
		
		String board_number = request.getParameter("num");
		String sql = "update board_table set board_count = board_count + 1 where board_number = ?";
		
		String value = null;
		
		if(cookies != null) {
			for (Cookie c : cookies) {
				value = c.getValue();
				if (!value.equals(board_number)) {
					Cookie cookie = new Cookie(board_number, board_number);
					cookie.setMaxAge(60);
					cookie.setPath("/");
					response.addCookie(cookie);
				}
			}
		}
		

	
    
		try {
    	con = DBManager.connect();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, board_number);
		
		
		
			
		if (pstmt.executeUpdate()==1) {
			System.out.println("조회수 증가");
		}
         
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, null);
		}
	}





	public static int countCheck(HttpServletRequest request) {
		String board_number = request.getParameter("num");	
		String num = (String)request.getAttribute("num");
		Cookie[] cookies = request.getCookies();
		
		String value = null;
		
		
		if(cookies != null) {
			 for (Cookie c : cookies) {
				 value = c.getValue();
			
				 if(value.equals(board_number) || value.equals(num)) {
						return 1;
						
					} 
			 }
		
		
		} 
		
		
		return 0;
		
		
		
		
		
	}

	
	

	
	
	
	
	
	
}