<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
	request.setCharacterEncoding("UTF-8");

	String nickname = request.getParameter("nickname");
	String bpass = request.getParameter("bpass");
	String email = request.getParameter("email");
	String mobile = request.getParameter("mobile");
	int uno = Integer.parseInt(request.getParameter("uno"));
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String sql = "update users set nickname=?, bpass=?, email=?, mobile=? where uno=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = DriverManager.getConnection(url,"root","1234");
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nickname);
		pstmt.setString(2, bpass);
		pstmt.setString(3, email);
		pstmt.setString(4, mobile);
		pstmt.setInt(5, uno);
		
		int result = pstmt.executeUpdate();
		
		if(result > 0){
			out.println("<script> alert('수정 성공'); location.href='mypage.jsp?uno="+uno+"' </script>");		
		}
		else{
			out.println("<script> alert('수정 실패'); location.href='mypage.jsp?uno="+uno+"' </script>");
		}
		if(pstmt != null){pstmt.close();}
		if(conn != null){conn.close();}
	}catch(Exception e){e.printStackTrace();}
%>