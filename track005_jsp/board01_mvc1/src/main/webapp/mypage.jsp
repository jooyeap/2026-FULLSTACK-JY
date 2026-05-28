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
		int uno = -1;
		
if(session.getAttribute("suno") == null){
		uno = Integer.parseInt(request.getParameter("uno"));
	
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
}
else{
	nickname = (String)session.getAttribute("snickname");
	email = (String)session.getAttribute("semail");
	mobile = (String)session.getAttribute("smobile");
	udate = (String)session.getAttribute("sudate");
	bip = (String)session.getAttribute("sbip");
	uno = (int)session.getAttribute("suno");
}
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
	<form id="mypageForm" method="post" onsubmit="">
		<div class="my-3 text-end">
			<button type="button" onclick="mypage_btn('update')" class="btn btn-outline-primary">수정하기</button>
			<button type="button" onclick="mypage_btn('delete')" class="btn btn-danger">회원탈퇴</button>
		</div>
	</form>
	<script>
	function mypage_btn(mode){
		let mf = document.getElementById("mypageForm")
		let uno = <%=uno %>
		
		if(mode == 'update'){
			mf.action = "/board01_mvc1/edit_user_action.jsp?uno=" + uno;
		}
		else if(mode == 'delete'){
			if(confirm("삭제?")){
				mf.action = "/board01_mvc1/leave_action.jsp?uno=" + uno;
			}
			else{return false;}
		}
		
		mf.submit();
	}

	</script>
</section>
<%@include file="./inc/footer.jsp"%>