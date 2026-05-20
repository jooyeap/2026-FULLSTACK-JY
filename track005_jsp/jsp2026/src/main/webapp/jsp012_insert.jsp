<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
// jsp012_insert.jsp

	// 1. utf-8 설정
	request.setCharacterEncoding("UTF-8");
	// 2. request.getParameter() 이용해서 데이터 받기
	String oname = request.getParameter("oname");
	int onum = Integer.parseInt(request.getParameter("onum"));
	
	/* out.println(oname + " / " + onum); */
	// 3. insert 구문처리
	// 3-1. 드라이버 로딩
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// 3-2. jdbc 연동
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
		
		// 3-3. insert executeUpdate
		pstmt = conn.prepareStatement("insert into milk_order (oname,onum,oip) value(?,?,?)");
		pstmt.setString(1,oname);
		pstmt.setInt(2,onum);
		pstmt.setString(3, InetAddress.getLocalHost().getHostAddress()); // Ip 주소가져오기
		
		// executeUpdate는 insert, updatem delete 실행한 줄수를 뱉음
		int result = pstmt.executeUpdate();
		if(result > 0 ){
			out.println("<script> alert('우유주문 성공'); location.href='jsp012_milks.jsp';</script>");
		}
		else{
			out.println("<script> alert('관리자에게 문의'); location.href='jsp012_milks.jsp';</script>");
		}
		// 3-4 close
		if(pstmt != null){pstmt.close();}
		if(conn != null){conn.close();}
		// 4. jsp012_milks.jsp 로 돌아가기
	} catch (Exception e) {e.printStackTrace();}
	/* String previousPage = request.getHeader("referer");
	response.sendRedirect(previousPage); */
%>