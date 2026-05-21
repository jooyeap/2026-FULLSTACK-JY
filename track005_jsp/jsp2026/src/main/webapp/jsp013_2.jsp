<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
	String username = request.getParameter("username");
	out.println(username);
	String[] options = request.getParameterValues("option1");
	out.println(Arrays.toString(options));
%>