package com.the703.board01_mvc1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String bpass = request.getParameter("bpass");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String url = "jdbc:mysql://localhost:3306/mbasic";
			String sql = "select * from users where email=? and bpass=?";
			
			conn = DriverManager.getConnection(url,"root","1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,email);
			pstmt.setString(2,bpass);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) { 
				session.setAttribute("email", rset.getString("email"));
				out.println("<script> alert('로그인 성공'); location.href='MyAction';</script>");
			} else {
				out.println("<script> alert('로그인 실패'); history.go(-1); </script>");
			}
			out.close();
			if(rset != null) {rset.close();}
			if(pstmt != null) {pstmt.close();}
			if(conn != null) {conn.close();}
		}catch(Exception e) {e.printStackTrace();}
//		response.sendRedirect("MyAction");
	}

}
