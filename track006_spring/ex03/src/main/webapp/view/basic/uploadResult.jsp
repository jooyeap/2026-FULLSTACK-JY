<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="../inc/header.jsp" %>
<div class="container my-3">
	<h3>업로드 결과</h3>
	<div class="my-3">
		<label for="name" class="form-label">작성자</label>
		<input type="text" id="name" name="name"
			   value="name" class="form-control" readonly>
	</div>
	
	<div class="my-3">
		<label for="file" class="form-label">파일</label>
		<img class="img-fluid" src="${pageContext.request.contextPath}/upload/${file}" alt="">
	</div>
	
</div>
<%@include file="../inc/footer.jsp" %>
