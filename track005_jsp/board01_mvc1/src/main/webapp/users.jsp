<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="./inc/header.jsp" %>
   <section class="container my-5">
      <h3 class="card-header"></h3>
      <table class="table table-bordered table-striped">
	      <caption>User 목록</caption>
	      <thead>
	      	<tr>
	      		<th>NICKNAME</th>
	      		<th>EMAIL</th>
	      		<th>MOBILE</th>
	      	</tr>
	      </thead>
	      <tbody>
	      	<c:forEach var="u" items="${userDto }">
	      		<tr>
	      			<td>${u.nickname}</td>
	      			<td>${u.email}</td>
	      			<td>${u.mobile}</td>
	      		</tr>
	      	</c:forEach>
	      </tbody>
      </table>
   </section>
<%@include file="./inc/footer.jsp" %>