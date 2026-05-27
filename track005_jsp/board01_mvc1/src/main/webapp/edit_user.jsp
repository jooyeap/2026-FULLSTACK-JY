<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="./inc/header.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	String nickname = "", bpass = "", email = "", mobile = "";
	int uno = Integer.parseInt(request.getParameter("uno"));
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String sql = "select * from users where uno=?";
		
		conn = DriverManager.getConnection(url,"root","1234");
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, uno);
		
		rset = pstmt.executeQuery();
		while(rset.next()){
			nickname = rset.getString("nickname");
			bpass = rset.getString("bpass");
			email = rset.getString("email");
			mobile = rset.getString("mobile");
		}
		
		if(rset != null){rset.close();}
		if(pstmt != null){pstmt.close();}
		if(conn != null){conn.close();}
	}catch(Exception e){e.printStackTrace();}
%>
<section class="container my-5">
	<h3>회원 정보 수정</h3>
	<form action="/board01_mvc1/edit_user_action.jsp?uno=<%=uno %>" method="post" onsubmit="return check()">
		<div class="my-3">
			<label for="nickname" class="form-label">닉네임</label>
			<input type="text" class="form-control" placeholder=""
				id="nickname" name="nickname" value="<%=nickname%>">
		</div>
		<div class="my-3">
			<label for="bpass" class="form-label">비밀번호</label>
			<input type="password" class="form-control" placeholder=""
				id="bpass" name="bpass" value="<%=bpass%>">
		</div>
		<div class="my-3">
			<label for="bpass" class="form-label">이메일</label>
			<input type="text" class="form-control" placeholder=""
				id="email" name="email" value="<%=email%>">
		</div>
		<div class="my-3">
			<label for="mobile" class="form-label">휴대폰</label>
			<input type="text" class="form-control" placeholder=""
				id="mobile" name="mobile" value="<%=mobile%>">
		</div>
		<div class="my-3 text-end">
			<button type="reset" class="btn btn-outline-primary">취소</button>
			<button type="submit" class="btn btn-primary">수정하기</button>
		</div>
	</form>
	<script>
		function check(){
			let nickname = document.getElementById("nickname");
			let bpass = document.getElementById("bpass");
			let email = document.getElementById("email");
			let mobile = document.getElementById("mobile");
			if(nickname.value.trim() == ""){
				alert("닉네임 빈칸 확인");
				nickname.focus();
				return false;
			}
			if(bpass.value.trim() == ""){
				alert("닉네임 빈칸 확인");
				bpass.focus();
				return false;
			}
			if(email.value.trim() == ""){
				alert("닉네임 빈칸 확인");
				email.focus();
				return false;
			}
			if(mobile.value.trim() == ""){
				alert("닉네임 빈칸 확인");
				mobile.focus();
				return false;
			}
			return true;
		}
	</script>
</section>


<%@include file="./inc/footer.jsp" %> 