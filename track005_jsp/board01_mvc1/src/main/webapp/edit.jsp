<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="./inc/header.jsp" %>

	<%
		String bname = "";
		String btitle = "";
		String bcontent = "";
		int bno = Integer.parseInt(request.getParameter("bno"));
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String sql = "select * from mvcboard1 where bno=?";
		
		conn = DriverManager.getConnection(url,"root","1234");
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		rset = pstmt.executeQuery();
		
		if(rset.next()){
			bname = rset.getString("bname");
			btitle = rset.getString("btitle");
			bcontent = rset.getString("bcontent");
		}
		
		if(rset != null){rset.close();}
		if(pstmt != null){pstmt.close();}
		if(conn != null){conn.close();}
	}catch (Exception e) { e.printStackTrace();}
	%>
     <section class="container  my-5">
        <h3> Q N A 상세보기 </h3>
        <form action="edit_action.jsp?bno=<%=bno %>" method="post" onsubmit="return checkForm()">
	        <div class="my-3">
	        	<label for="bname" class="form-label">이름</label>
	        	<input type="text" class="form-control" placeholder=""
	        		id="bname" name="bname" value="<%=bname %>" readonly>
	        </div>
	        <div class="my-3">
	        	<label for="bpass" class="form-label">비밀번호</label>
	        	<input type="text" class="form-control" placeholder=""
	        		id="bpass" name="bpass">
     		</div>
	        <div class="my-3">
	        	<label for="btitle" class="form-label">제목</label>
	        	<input type="text" class="form-control" placeholder=""
	        		id="btitle" name="btitle" value="<%=btitle %>">
	        </div>
        	<label for="bcontent" class="form-label">내용</label>
        	<textarea class="form-control" id="bcontent" name="bcontent"><%=bcontent %></textarea>
        	<div class="my-3 text-end">
	        	<button type="submit" class="btn btn-dark" title="글수정">수정</button>
	        	<button type="reset" class="btn btn-dark" title="글취소">취소</button>
	        	<a href="/board01_mvc1/list.jsp" class="btn btn-dark" title="글목록">목록보기</a>
        	</div>
       
        </form>
        <script>
        function checkForm() {
        	let pass = document.getElementById("bpass");
        	let title = document.getElementById("btitle");
        	let content = document.getElementById("bcontent");

        	if(pass.value.trim() == ""){
        		alert("비밀번호 빈칸 확인");
        		pass.focus();
        		return false;
        	}
        	if(title.value.trim() == ""){
        		alert("제목 빈칸 확인");
        		title.focus();
        		return false;
        	}
        	if(content.value.trim() == ""){
        		alert("내용 빈칸 확인");
        		content.focus();
        		return false;
        	}
        	return true;
        }
        </script>
        
    </section>
<%@include file="./inc/footer.jsp" %>
</body>
</html>