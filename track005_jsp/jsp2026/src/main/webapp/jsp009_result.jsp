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
      <h3 class="card-header">009 score</h3>
       <% 
       	int kor = Integer.parseInt(request.getParameter("kor")); 
        int eng = Integer.parseInt(request.getParameter("eng")); 
        int math = Integer.parseInt(request.getParameter("math"));
       	double result = (kor+eng+math)/3.0;
        String avg = String.format("%.2f",result);  
       %>
       <table class="table table-striped table-bordered">
	       <thead>
	       	<tr>
	       		<th>KOR</th>
	       		<th>ENG</th>
	       		<th>MATH</th>
	       		<th>TOTAL</th>
	       		<th>AVG</th>
	       	</tr>
	       </thead>
	       <tbody>
	       	<tr>
	       		<td><%=kor %></td>
	       		<td><%=eng %></td>
	       		<td><%=math %></td>
	       		<td><%=(kor+eng+math) %></td>
	       		<td><%=avg %></td>
	       	</tr>
	       </tbody>
       </table>
       <p><a href="javascript:history.go(-1)" class="btn btn-danger">BACK</a></p>
   </div>
</body>
</html>