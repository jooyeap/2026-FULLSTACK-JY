<%@page import="com.mysql.cj.x.protobuf.MysqlxPrepare.Execute"%>
<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="./inc/header.jsp" %>

     <section class="container  my-5">
        <h3> Q N A 등록 </h3>
        <form action="write_action.jsp" method="post" onsubmit="return checkForm()">
	        <div class="my-3">
	        	<label for="bname" class="form-label">이름</label>
	        	<input type="text" class="form-control" placeholder=""
	        		id="bname" name="bname">
	        </div>
	        <div class="my-3">
	        	<label for="bpass" class="form-label">비밀번호</label>
	        	<input type="password" class="form-control" placeholder=""
	        		id="bpass" name="bpass">
	        </div>
	        <div class="my-3">
	        	<label for="btitle" class="form-label">제목</label>
	        	<input type="text" class="form-control" placeholder=""
	        		id="btitle" name="btitle">
	        </div>
	        <div class="my-3">
	        	<label for="bcontent" class="form-label">내용</label>
	        	<textarea class="form-control" id="bcontent" name="bcontent"></textarea>
	       	</div>
        	<div class="my-3 text-end">
	        	<button type="submit" class="btn btn-dark" title="글등록">글쓰기</button>
	        	<button type="reset" class="btn btn-dark" title="글취소">취소</button>
	        	<a href="/board01_mvc1/list.jsp" class="btn btn-dark" title="글목록">목록보기</a>
        	</div>
        
        </form>
        <script>
        function checkForm() {
        	let name = document.getElementById("bname");
        	let pass = document.getElementById("bpass");
        	let title = document.getElementById("btitle");
        	let content = document.getElementById("bcontent");
        	if(name.value.trim() == ""){
        		alert("이름 빈칸 확인");
        		name.focus();
        		return false;
        	}
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
