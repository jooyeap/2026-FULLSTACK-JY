<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="./inc/header.jsp" %>
<%
	int bno = Integer.parseInt(request.getParameter("bno"));
%>
     <section class="container  my-5">
        <h3> Q N A 삭제 </h3>
        <form action="delete_action.jsp?bno=<%=bno %>" method="post" onsubmit="return checkForm()">
	        <div class="my-3">
	        	<label for="bpass" class="form-label">비밀번호</label>
	        	<input type="text" class="form-control" placeholder=""
	        		id="bpass" name="bpass">
	        	<p>(*) 수정 삭제시 필수입니다.</p>
     		</div>
        	<div class="my-3 text-end">
	        	<button type="submit" class="btn btn-dark" title="삭제확인">확인</button>
	        	<button type="reset" class="btn btn-dark" title="삭제취소">취소</button>
	        	<a href="/board01_mvc1/list.jsp" class="btn btn-dark" title="글목록">목록보기</a>
        	</div>
        
        </form>
        <script>
        function checkForm() {
        	let pass = document.getElementById("bpass");
        	if(pass.value.trim() == ""){
        		alert("비밀번호 빈칸 확인");
        		pass.focus();
        		return false;
        	}
        	return true;
        } 
        </script>
        
    </section>
<%@include file="./inc/footer.jsp" %>