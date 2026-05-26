<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
	int uno = -1;
	request.setCharacterEncoding("UTF-8");
	
	String email = request.getParameter("email");
	String bpass = request.getParameter("bpass");
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String sql = "select * from users where email=? and bpass=?";
		
		conn = DriverManager.getConnection(url,"root","1234");
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, email);
		pstmt.setString(2, bpass);
		
		rset = pstmt.executeQuery();
		
		if(rset == null){
			out.print("<script> alert('로그인 실패'); location.href='login.jsp'; </script>");
		}
		while(rset.next()){
			uno = rset.getInt("uno");
		}
		out.print("<script> alert('로그인 성공'); location.href='mypage.jsp?uno="+uno+"' </script>");
		
		if(rset != null){rset.close();}
		if(pstmt != null){pstmt.close();}
		if(conn != null){conn.close();}
	}catch(Exception e){e.printStackTrace();}
%>