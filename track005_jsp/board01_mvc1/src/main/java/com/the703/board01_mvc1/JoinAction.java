package com.the703.board01_mvc1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinAction")
public class JoinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JoinAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("join.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String nickname = request.getParameter("nickname");
		String bpass = request.getParameter("bpass");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			PreparedStatement pstmt = null; 
			String url = "jdbc:mysql://localhost:3306/mbasic";
			String sql = "insert into users (nickname, bpass, email, mobile, udate, bip) values(?,?,?,?,now(),?)";
			
			conn = DriverManager.getConnection(url,"root","1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			pstmt.setString(2, bpass);
			pstmt.setString(3, email);
			pstmt.setString(4, mobile);
			pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				out.println("<script> alert('회원가입 성공'); location.href='LoginAction'; </script>");
			} else {
				out.println("<script> alert('회원가입 실패'); location.href='index.jsp'; </script>");
			}
			
			out.close();
			if(pstmt != null) {pstmt.close();}
			if(conn != null) {conn.close();}
		}catch(Exception e) {e.printStackTrace();}
		
		response.sendRedirect("LoginAction");
//		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
