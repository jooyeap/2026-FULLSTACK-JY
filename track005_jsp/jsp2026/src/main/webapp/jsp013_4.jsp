<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
	request.setCharacterEncoding("UTF-8");
	int age = Integer.parseInt(request.getParameter("userage"));
	if(age > 18){
		request.getRequestDispatcher("jsp013_adult.jsp").forward(request,response);
	}
	else{
		// 쿼리스트링 주소?name1=value1&name2=value2
		response.sendRedirect("jsp013_child.jsp?userage=" + age);
	}
%>
