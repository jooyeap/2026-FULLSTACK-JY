<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="">
	<!-- header -->
	<div class="p-5 bg-primary text-white pt-4 pb-4">
		<h1>Milk Order Project</h1>
      	<p>MVC1 - PreparedStatement EX</p>
	</div>
	<!-- header -->
	
	<!-- 메뉴판 테이블 -->
    <div class="container card my-5 pb-5 ps-0 pe-0">
      <h2 class="card-header bg-primary mb-4 p-3 text-light">Milk Menu</h2>
      <div class="ms-4 me-4">
	      <table class="table table-bordered table-info table-striped">
	      	  <caption>우유메뉴</caption>
		      <thead>
		      	<tr>
		      		<th scope="col">NO</th>
		      		<th scope="col">NAME</th>
		      		<th scope="col">PRICE</th>
		      	</tr>
		      </thead>
		      <tbody>
		      <%
		      try{
		      	// 1. 드라이버 연동
		      	Class.forName("com.mysql.cj.jdbc.Driver");
		      	PreparedStatement pstmt = null;
		      	ResultSet rset = null;
		      	Connection conn = null;
		      	// 2. JDBC 연동
		      	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic",
		      			"root","1234");
		      	// 3. PreparedStatement pstmt 이용해서 milk 테이블의 데이터 가져오기
				
		      	/* pstmt = conn.prepareStatement("insert into milk (mno,mname,mprice) values(?,?,?)");
		      	pstmt.setInt(1, 1);
		      	pstmt.setString(2,"coffee");
		      	pstmt.setInt(3,1600);
		      	
		      	int result = pstmt.executeUpdate();
		      	pstmt = null; */
		      	
		      	// 가격이 낮은순으로
		      	pstmt = conn.prepareStatement("select * from milk order by mprice asc");
		      	rset = pstmt.executeQuery(); // 표
		      	while(rset.next()){ // 줄
		      		out.println("<tr><td>"+rset.getInt("mno")
		      		+"</td><td>"+rset.getString("mname")
		      		+"</td><td>"+rset.getInt("mprice")+"</td></tr>");
		      	}
		      	// 4. JDBC 연동 해제
		      	if(rset != null){rset.close();}
		      	if(pstmt != null){pstmt.close();}
		      	if(conn != null){conn.close();}
		      } catch(Exception e){e.printStackTrace();}
		      %>
		      </tbody>
	      </table>
      </div>
    </div>
    <!-- 메뉴판 테이블 -->
    
    <!-- 주문현황표 -->
   <div class="container card my-5 pb-4 ps-0 pe-0">
   	<h2 class="card-header bg-primary mb-4 p-3 text-light">MILK ORDER</h2>
   	<div class="ms-4 me-4">
   	<table class="table table-bordered table-striped table-info">
   		<thead>
   			<tr>
   				<th>NO</th>
   				<th>NAME</th>
   				<th>NUM</th>
   				<th>주문날짜</th>
   			</tr>
   		</thead>
   		<tbody>
   		</tbody>
   	</table>
   	</div>
   </div>
   <!-- 주문현황표 -->
   
   <!-- 주문삽입, 수정, 삭제 -->
   <div class="container card my-5 pb-4 ps-0 pe-0" id="accordion">
   	<h3 class="card-header bg-primary mb-4 p-3 text-light">MILK 주문하러가기</h3>
   	<div class="card mb-3">
    <div class="card-header bg-primary">
      <a class="btn fw-bold text-light" data-bs-toggle="collapse" href="#collapseOne">
        주문하기
      </a>
    </div>
    <div id="collapseOne" class="collapse show" data-bs-parent="#accordion">
      <div class="card-body">
        <form>
        	<div class="mb-3 mt-3">
        		<label for="mname" class="form-label">주문할 우유이름</label>
        		<input type="text" class="form-control" placeholder="주문할 우유이름을 적어주세요"
        		id="mname">
        	</div>
        	<div class="mb-3 mt-3">
        		<label for="mnum" class="form-label">주문할 우유갯수</label>
        		<input type="text" class="form-control" placeholder="우유갯수를 적어주세요"
        		id="mnum">
        	</div>
        	<button type="submit" class="btn btn-primary">주문하기</button>
        </form>
      </div>
    </div>
  </div>

  <div class="card mb-3">
    <div class="card-header bg-primary">
      <a class="collapsed btn fw-bold text-light" data-bs-toggle="collapse" href="#collapseTwo">
        주문수정
      </a>
    </div>
    <div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
      <div class="card-body">
        <form>
        	<div>
        		<label for="" class="form-label">123</label>
        		<input type="" class="form-control" placeholder="">
        	</div>
        </form>
      </div>
    </div>
  </div>

  <div class="card mb-3">
    <div class="card-header bg-primary">
      <a class="collapsed btn fw-bold text-light" data-bs-toggle="collapse" href="#collapseThree">
        주문삭제
      </a>
    </div>
    <div id="collapseThree" class="collapse" data-bs-parent="#accordion">
      <div class="card-body">
        <form>
        	<div>
        		<label for="" class="form-label">123</label>
        		<input type="" class="form-control" placeholder="">
        	</div>
        </form>
      </div>
    </div>
  </div>
   </div>
   <!-- 주문삽입, 수정, 삭제 -->
</body>
</html>