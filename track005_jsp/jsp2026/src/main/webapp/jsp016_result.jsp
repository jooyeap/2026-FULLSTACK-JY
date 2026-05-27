<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
	request.setCharacterEncoding("UTF-8");
	String email = request.getParameter("email");
	String pass = request.getParameter("pass");
	
	session.setAttribute("email", email);
	session.setAttribute("pass", pass);
	
	response.sendRedirect("jsp016_login.jsp");
%>