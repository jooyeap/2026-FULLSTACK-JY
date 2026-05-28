<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
	int uno = -1;
	request.setCharacterEncoding("UTF-8");
	
	String email = request.getParameter("email");
	String bpass = request.getParameter("bpass");
	
	String snickname = "";
	String semail = "";
	String smobile = "";
	String sudate = "";
	String sbip = "";
	int suno = -1;
	
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
		
		if(rset.next()){
			uno = rset.getInt("uno");
			// 헤더에서 마이페이지 넘어갈때 데이터 넘겨줘야함
			session.setAttribute("snickname", rset.getString("nickname"));
			session.setAttribute("semail", rset.getString("email"));
			session.setAttribute("smobile", rset.getString("mobile"));
			session.setAttribute("sudate", rset.getString("udate"));
			session.setAttribute("sbip", rset.getString("bip"));
			session.setAttribute("suno", rset.getInt("uno"));
			
			out.print("<script> alert('로그인 성공'); location.href='mypage.jsp?uno="+uno+"' </script>");
		}
		else{
			out.print("<script> alert('로그인 실패'); location.href='login.jsp'; </script>");
		}
		
		if(rset != null){rset.close();}
		if(pstmt != null){pstmt.close();}
		if(conn != null){conn.close();}
	}catch(Exception e){e.printStackTrace();}
	
	
	
%>