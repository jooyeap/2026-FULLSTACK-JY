package com.the703.board01_mvc1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Users")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Users() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		ArrayList<UserDto> userDto = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String url = "jdbc:mysql://localhost:3306/mbasic";
			String sql = "select * from users";
			
			conn = DriverManager.getConnection(url,"root","1234");
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UserDto ud = new UserDto();
				ud.setNickname(rset.getString("nickname"));
				ud.setBpass(rset.getString("bpass"));
				ud.setEmail(rset.getString("email"));
				ud.setMobile(rset.getString("mobile"));
				ud.setUdate(rset.getString("udate"));
				ud.setBip(rset.getString("bip"));
				
				userDto.add(ud);
			}
			request.setAttribute("userDto",userDto);
			
			if(rset != null) {rset.close();}
			if(pstmt != null) {pstmt.close();}
			if(conn != null) {conn.close();}
		}catch(Exception e) {e.printStackTrace();}
		
		request.getRequestDispatcher("users.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
