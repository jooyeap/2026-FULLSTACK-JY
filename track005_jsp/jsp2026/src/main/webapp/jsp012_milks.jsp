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
    <div class="container card my-5 pb-5 ps-0 pe-0 shadow">
      <h2 class="card-header bg-primary mb-4 p-3 text-light">Milk Menu</h2>
      <div class="ms-4 me-4">
	      <table class="table table-bordered table-success table-striped">
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
		      	if(rset != null) {rset.close();}
		      	if(pstmt != null){pstmt.close();}
		      	if(conn != null){ conn.close();}
		      } catch(Exception e){e.printStackTrace();}
		      %>
		      </tbody>
	      </table>
      </div>
    </div>
    <!-- 메뉴판 테이블 -->
    
    <!-- 주문현황표 -->
   <div class="container card my-5 pb-4 ps-0 pe-0 shadow">
   	<h2 class="card-header bg-primary mb-4 p-3 text-light">MILK ORDER</h2>
   	<div class="ms-4 me-4">
   	<table class="table table-bordered table-striped table-success">
   	<caption>주문현황표</caption>
   		<thead>
   			<tr>
   				<th>NO</th>
   				<th>NAME</th>
   				<th>NUM</th>
   				<th>주문날짜</th>
   			</tr>
   		</thead>
   		<tbody>
   		<%
   		try{
   			Class.forName("com.mysql.cj.jdbc.Driver");
   			Connection conn = null;
   			PreparedStatement pstmt = null;
   			ResultSet rset = null;
   			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic"
   					,"root","1234");
   			
   			pstmt = conn.prepareStatement("select * from milk_order order by ono desc");
   			rset = pstmt.executeQuery(); // 표 query(select) / update(insert,update,delete)
   			while(rset.next()){ // 줄
   				out.println("<tr><td>"+rset.getInt("ono")
   				+"</td><td>"+rset.getString("oname")
   				+"</td><td>"+rset.getInt("onum")
   				+"</td><td>"+rset.getString("odate")+"</td></tr>");
   			}
   			if(rset != null){rset.close();}
   			if(pstmt != null){pstmt.close();}
   			if(conn != null){conn.close();}
   		}catch(Exception e){e.printStackTrace();}
   		%>
   		</tbody>
   	</table>
   	</div>
   </div>
   <!-- 주문현황표 -->
   
   <!-- 주문삽입, 수정, 삭제 -->
   <div class="container card my-5 pb-4 ps-0 pe-0 shadow" id="accordion">
     <h3 class="card-header bg-primary mb-4 p-3 text-light">MILK 주문, 수정, 삭제</h3>
     <div class="ms-3 me-3">
   	
	   	<div class="card mb-3">
	    <div class="card-header bg-primary">
	      <a class="btn fw-bold text-light" data-bs-toggle="collapse" href="#collapseOne">
	        주문하기
	      </a>
	    </div>
	    
	    <div id="collapseOne" class="collapse show" data-bs-parent="#accordion">
	      <div class="card-body">
	        <form action="jsp012_insert.jsp" method="post" onsubmit="return order()">
	        
	        	<div class="mb-3 mt-3">
	        		<label for="oname" class="form-label">주문할 우유이름</label>
	        		<input type="text" class="form-control" placeholder="주문할 우유이름을 적어주세요"
	        		id="oname" name="oname">
	        	</div>
	        	
	        	<div class="mb-3 mt-3">
	        		<label for="onum" class="form-label">주문할 우유갯수</label>
	        		<input type="text" class="form-control" placeholder="우유갯수를 적어주세요"
	        		id="onum" name="onum">
	        	</div>
	        	
	        	<button type="submit" class="btn btn-primary">주문하기</button>
	        </form>
	        
	        <script>
	        function order(){
	        	let oname = document.querySelector("#oname");
	        	let onum = document.querySelector("#onum");
	        	if(oname.value.trim() == ""){
	        		alert("주문할 우유 이름 입력");
	        		oname.focus();
	        		return false;
	        	}
	        	if(onum.value.trim() == ""){
	        		alter("주문할 우유 개수 입력");
	        		onum.focus();
	        		return false;
	        	}
	        	return true;
	        }
	        </script>
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
	        <form action="jsp012_update.jsp" method="post" onsubmit="return update()">
	        
	        	<div class="mb-3 mt-3">
	        		<label for="uno" class="form-label">수정할 주문번호</label>
	        		<input type="text" class="form-control" placeholder="수정하실 번호 입력"
	        		id="uno" name="ono">
	        	</div>
	        	
	        	<div class="mb-3 mt-3">
	        		<label for="uname" class="form-label">수정할 우유이름</label>
	        		<input type="text" class="form-control" placeholder="우유갯수를 적어주세요"
	        		id="uname" name="oname">
	        	</div>
	        	
	        	<div class="mb-3 mt-3">
	        		<label for="unum" class="form-label">수정할 우유갯수</label>
	        		<input type="text" class="form-control" placeholder="우유갯수를 적어주세요"
	        		id="unum" name="onum">
	        	</div>
	        	
	        	<button type="submit" class="btn btn-primary">수정하기</button>
	        </form>
	        
	        <script>
	        function update(){
	        	let ono = document.querySelector("#uno"); 
	        	let oname = document.querySelector("#uname");
	        	let onum = document.querySelector("#unum");
	        	if(ono.value.trim() == ""){
	        		alert("수정할 번호 입력");
	        		ono.focus();
	        		return false;
	        	}
	        	if(oname.value.trim() == ""){
	        		alert("수정할 우유 이름 입력");
	        		oname.focus();
	        		return false;
	        	}
	        	if(onum.value.trim() == ""){
	        		alert("수정할 우유 개수 입력");
	        		onum.focus();
	        		return false;
	        	}
	        	return true;
	        }
	        </script>
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
	       <form action="jsp012_delete.jsp" method="get" onsubmit="return delete()">
	        
	        	<div class="mb-3 mt-3">
	        		<label for="dno" class="form-label">수정할 주문번호</label>
	        		<input type="text" class="form-control" placeholder="삭제하실 번호 입력"
	        		id="dno" name="ono">
	        	</div>
	        	
	        	<button type="submit" class="btn btn-primary">삭제하기</button>
	        </form>
	        
	        <script>
	        function delete(){
	        	let ono = document.querySelector("#dno"); 
	        	if(ono.value.trim() == ""){
	        		alert("삭제하실 번호(no) 입력");
	        		ono.focus();
	        		return false;
	        	}
	        	return true;
	        }
	        </script>
	      </div>
	    </div>
	  </div>
  </div>
  </div>
   <!-- 주문삽입, 수정, 삭제 -->
</body>
</html>