<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
request.setCharacterEncoding("UTF-8");
String bpass = request.getParameter("bpass");
int bno = Integer.parseInt(request.getParameter("bno"));

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null;
	PreparedStatement pstmt = null;
	String url = "jdbc:mysql://localhost:3306/mbasic";
	String sql = "delete from mvcboard1 where bno=? and bpass=?";
	
	conn = DriverManager.getConnection(url,"root","1234");
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, bno);
	pstmt.setString(2, bpass);
	
	int result = pstmt.executeUpdate();
if(result > 0){
	out.println("<script> alert('삭제완료'); location.href='list.jsp'; </script>");
	pstmt.close();
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1,bno);
	pstmt.setString(2, bpass);
	pstmt.executeUpdate();
}
else{
	out.println("<script> alert('삭제실패'); location.href='delete.jsp?bno=" +bno+ "'; </script>");
}
out.println("<script> location.href='list.jsp';</script>");
if(pstmt != null){pstmt.close();}
if(conn != null){conn.close();}
}catch(Exception e){e.printStackTrace();}
%>