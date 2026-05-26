<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="./inc/header.jsp"%>
<%
	String nickname = "";
	String email = "";
	String mobile = "";
	String udate = "";
	String bip = "";
	int uno = Integer.parseInt(request.getParameter("uno"));

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	String url = "jdbc:mysql://localhost:3306/mbasic";
	String isql = "select * from users where uno=?";
	
	conn = DriverManager.getConnection(url,"root","1234");
	pstmt = conn.prepareStatement(isql);
	
	pstmt.setInt(1, uno);
	
	rset = pstmt.executeQuery();
	while(rset.next()){
		nickname = rset.getString("nickname");
		email = rset.getString("email");
		mobile = rset.getString("mobile");
		udate = rset.getString("udate");
		bip = rset.getString("bip");
	}
	
	if(rset != null){rset.close();}
	if(pstmt != null){pstmt.close();}
	if(conn != null){conn.close();}
} catch (Exception e) {e.printStackTrace();}
	
%>
<section class="container my-5">
	<h3>마이페이지</h3>
	<table class="table table-striped table-bordered">
		<caption>내 정보</caption>
		<tbody>
			<tr><th scope="row">닉네임</th> <td><%=nickname %></td></tr>
			<tr><th scope="row">이메일</th> <td><%=email %></td></tr>
			<tr><th scope="row">휴대폰</th> <td><%=mobile %></td></tr>
			<tr><th scope="row">가입일</th> <td><%=udate %></td></tr>
			<tr><th scope="row">가입IP</th> <td><%=bip %></td></tr>
		</tbody>
	</table>
</section>
<%@include file="./inc/footer.jsp"%>