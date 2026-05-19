<%-- <%@page import="java.sql.Connection"%> --%>
<%-- <%@page import="java.sql.DriverManager"%> --%>
<%@page import="java.sql.*"%> <!-- 모든 sql 임포트 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
   <div class="container card my-5">
      <h3 class="card-header">JDBC</h3>
      <pre class="alert alert-info">
1. jdbc - Java Database Connectivity
- java 와 db를 연결해 sql 실행해주는 표준 api
      	
2. mysql, oracle,,, 다양한 dbms와 연결
      	
3. 사용방법
https://dev.mysql.com/downloads/
[src] - [main] - [webadd] - [WEB_INF] - [lib] - mysql-connector-j-8.4.0.jar
      	
4. JDBC 사용방법
1) Class.forName() 드라이버 로딩
2) DriverManager Connection 활성화
3) Connection DB연동
4) Statement, PreparedStatement sql 구문 실행
5) jdbc 연동끊기
      </pre>
       
       <%
       try{
	       // 1. 드라이버 로딩
	       Class.forName("com.mysql.cj.jdbc.Driver");
	       // 2. jdbc 연동
	       Connection conn =  DriverManager.getConnection(
	    		   "jdbc:mysql://localhost:3306/mbasic", // url/db명
	    		   "root", // id
	    		   "1234"); // password
	   	   if(conn != null){
	   		   out.println("db 연결 성공");
	   		// 3. jdbc 연동끊기
	   		   conn.close(); 
	   	   }
       }catch(Exception e){e.printStackTrace();}
       %>
   </div>
</body>
</html>