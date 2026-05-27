<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	session.setMaxInactiveInterval(60*10); // 초 단위 10분
	session.setAttribute("username", "aaa"); // 이름, 값
	session.setAttribute("userage", "10");
	response.sendRedirect("jsp015_1_session.jsp");
%>