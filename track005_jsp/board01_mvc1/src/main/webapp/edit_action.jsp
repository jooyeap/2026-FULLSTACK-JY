<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
	request.setCharacterEncoding("UTF-8");
	String bpass = request.getParameter("bpass");
	String btitle = request.getParameter("btitle");
	String bcontent = request.getParameter("bcontent");
	int bno = Integer.parseInt(request.getParameter("bno"));

	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		PreparedStatement pstmt = null;
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String sql = "update mvcboard1 set btitle=? , bcontent=? where bno=? and bpass=?";
		
		conn = DriverManager.getConnection(url,"root","1234");
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, btitle);
		pstmt.setString(2, bcontent);
		pstmt.setInt(3, bno);
		pstmt.setString(4, bpass);
		
		int result = pstmt.executeUpdate();
		
		if(result > 0){
			out.println("<script> location.href='list.jsp';</script>");
		}
		if(pstmt != null){pstmt.close();}
		if(conn != null){conn.close();}
	}catch(Exception e){e.printStackTrace();}
%>