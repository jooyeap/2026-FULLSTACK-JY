<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="../view/inc/header.jsp"%>

<div class="container my-3 p-3">
	<h3>security</h3>
	<a href="${pageContext.request.contextPath}/security/all"
	   class="btn btn-info">ALL    - 모든사람들 접근가능</a>
    <a href="${pageContext.request.contextPath}/security/member"
       class="btn btn-success">MEMBER - 멤버만 접근가능</a> 
</div>

<%@include file="../view/inc/footer.jsp"%>