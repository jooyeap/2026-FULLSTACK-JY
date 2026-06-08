<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="../inc/header.jsp" %>
<div class="container my-3">
	<form action="${pageContext.request.contextPath}/upload"
		  method="post"
		  enctype="multipart/form-data">
		<div class="my-3">
			<label for="name" class="form-label">작성자</label>
			<input type="text" id="name" name="name" class="form-control"/>
		</div>
		
		<div class="my-3">
			<label for="file" class="form-label">파일업로드</label>
			<input type="file" id="file" name="file" class="form-control">
		</div>
		
		<div class="my-3">
			<input type="submit" class="btn btn-danger" value="업로드">
		</div>
	</form>
</div>
<%@include file="../inc/footer.jsp" %>
