package com.the703.board01_mvc1;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MyAction")
public class MyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 로그인한 정보확인
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		
		// 2. sql - 내정보 가져오기
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String url = "jdbc:mysql://localhost:3306/mbasic";
			String sql = "select * from users where email=?";
			
			conn = DriverManager.getConnection(url,"root","1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String)session.getAttribute("email"));
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				request.setAttribute("email",rset.getString("email"));
			}
			
			if(rset != null) {rset.close();}
			if(pstmt != null) {pstmt.close();}
			if(conn != null) {conn.close();}
		}catch(Exception e) {e.printStackTrace();}
		// 3. mypage.jsp 로 경로 넘기기
		request.getRequestDispatcher("mypage.jsp").forward(request, response);
//		response.sendRedirect("mypage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
