<%@page import="java.sql.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<!-- 							header  					 	-->
<!--  							header 							-->	
<!-- bg-primary(파랑), bg-success(녹색), .bg-info(하늘색), .bg-warning(노랑), .bg-danger(빨강)							 				-->
<!-- https://www.w3schools.com/bootstrap5/bootstrap_jumbotron.php -->
		<div class="mt-4 p-5 bg-primary text-white rounded">
		  <h1>Milk Order Project</h1>
		  <p>pstmt_stmt</p>
		</div>

<!--                            메뉴판 테이블 						-->
<!-- 							메뉴판 테이블 						-->
<!--https://www.w3schools.com/bootstrap5/bootstrap_tables.php  -->		
   <div class="container card my-5 bg-info text-white">
      <h3 class="card-header">Milk Menu</h3>
      
      <table class= "table table-bordered table-striped table-hover">
          <caption> 우유메뉴</caption>
          <thead>
              <tr>
                 <th scope = "col">NO</th>
                 <th scope = "col">NAME</th>
                 <th scope = "col">PRICE</th>
              </tr>
          </thead>
          <tbody>
          <% 
          try{
            // 1. 드라이버 연동
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
            // 2. JDBC 연동
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
            
            // 3. PreparaedStatement pstmt 이용해서 milk 테이블의 데이터 가져오기
            pstmt = conn.prepareStatement("select * from milk order by mprice asc");
            
            rset = pstmt.executeQuery(); //표
            while(rset.next()) { //줄
            	out.println("<tr><td>" + rset.getInt("mno")+"</td><td>"
            			               + rset.getString("mname") + "</td><td>"
            			               + rset.getInt("mprice") + "</td></tr>");
            }
            // 가격이 낮은순으로            
            // 4. JDBC 끊기
            if(rset != null) {rset.close();}
            if(pstmt != null) {pstmt.close();}
            if(conn != null) {conn.close();}
          } catch (Exception e) { e.printStackTrace(); }
             /* mysql> select * from milk;
				+-----+--------+--------+------+--------+
				| mno | mname  | mprice | mnum | mtotal |
				+-----+--------+--------+------+--------+
				|   1 | white  |   1500 | NULL |   NULL |
				|   2 | choco  |   1800 | NULL |   NULL |
				|   3 | banana |   1800 | NULL |   NULL |
				+-----+--------+--------+------+--------+
				3 rows in set (0.00 sec)
		             alter table milk modify mnum int null;
		             alter table milk modify mtotal int null;
		             
		             insert into milk (mno, mname, mprice) values(1, 'white', 1500);
		             insert into milk (mno, mname, mprice) values(2, 'choco', 1800);
		             insert into milk (mno, mname, mprice) values(3, 'banana', 1800);
             
             	   1  white   1500
            	   2  choco   1800
            	   3  banana  1800  */
          %>
          </tbody>
      </table>
   </div>
   <!-- 							밀크 오더						-->
   <!-- 							밀크 오더						-->
   <div class="container card my-5 bg-info text-white">
      <h3 class="card-header">Milk Order</h3>

      <table class= "table table-bordered table-striped table-hover">
         <caption> 주문 오더</caption>
          <thead>
              <tr>
                 <th scope = "col">NO</th>
                 <th scope = "col">NAME</th>
                 <th scope = "col">NUM</th>
                 <th scope = "col">ORDER DATE</th>
              </tr>
          </thead>
          <% 
          try{
            // 1. 드라이버 연동   Class.forName
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
            String url = "jdbc:mysql://localhost:3306/mbasic";
            String sql = "select * from milk_order    order by ono desc";
            // 2. JDBC 연동   DriverManager.getConnection
            conn = DriverManager.getConnection(url,"root","1234");
            
            // 3. pstmt 사용 sql 처리    pstmt.executeQuery()
            pstmt = conn.prepareStatement(sql);
            
            rset = pstmt.executeQuery(); //표 executeQuery(select)
          								 //표 executeUpdate(insert, update, delete)
            while(rset.next()) { //줄
            	out.println("<tr><td>" + rset.getInt("ono") //칸
            			               + "</td><td>" + rset.getString("oname") 
            			               + "</td><td>" + rset.getInt("onum") 
            			               + "</td><td>" + rset.getString("odate") + "</td></tr>");
            }
            // 4. JDBC close(끊기)
            if(rset != null) {rset.close();}
            if(pstmt != null) {pstmt.close();}
            if(conn != null) {conn.close();}
          } catch (Exception e) { e.printStackTrace(); }
          %>
          </tbody>
      </table>
   </div>
   <!--       주문 삽입, 수정, 삭제            -->
   <!--       주문 삽입, 수정, 삭제            -->
      <div class="container card  bg-secondary my-5 p-3">
      <h3 class="card-header text-white my-3"> Milk 주문, 수정, 삭제 </h3>
      
		   <div id="accordion">
			
			  <div class="card">
			    <div class="card-header bg-info">
			      <a class="btn" data-bs-toggle="collapse" href="#collapseOne">
			        Milk 주문하기
			      </a>
			    </div>
			    <div id="collapseOne" class="collapse show" data-bs-parent="#accordion">
			      <div class="card-body">
			          <form action ="jsp012_insert.jsp" method="post" onsubmit = "return order()">
			          	 <div class = "my-3">
			               <label for ="ono" class="form-label"> 주문할 우유 번호 </label>
			               <input type="text" class="form-control" id="ono" name="ono" />
			             </div>
			             <div class = "my-3">
			               <label for ="oname" class="form-label"> 주문할 우유 이름 </label>
			               <input type="text" class="form-control" id="oname" name="oname" />
			             </div>
			             <div class="my-3">
	                       <label for="onum"  class="form-label"> 주문할 우유 갯수 </label>
	                       <input type="text" class="form-control"  id="onum"   name="onum" />
	                    </div>
	                    <div class="my-3"> 
	                       <button  type="submit"  class="btn btn-warning" > 주문하기 </button>
	                    </div>
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
			
			  <div class="card">
			    <div class="card-header bg-info">
			      <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseTwo">
			        Milk 주문 수정하기
			      </a>
			    </div>
			    <div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
			      <div class="card-body">
			        <form action ="jsp012_update.jsp" method="post" onsubmit = "return update()">
			        	 <div class = "my-3">
			               <label for ="ono1" class="form-label"> 수정 할 우유 번호 </label>
			               <input type="text" class="form-control" id="ono1" name="ono" />
			             </div>
			             <div class = "my-3">
			               <label for ="oname1" class="form-label"> 수정 할 우유 이름 </label>
			               <input type="text" class="form-control" id="oname1" name="oname" />
			             </div>
			             <div class="my-3">
	                       <label for="onum1"  class="form-label"> 수정 할 우유 갯수 </label>
	                       <input type="text" class="form-control"  id="onum1"   name="onum" />
	                    </div>
	                    <div class="my-3"> 
	                       <button  type="submit"  class="btn btn-warning" > 주문 수정하기 </button>
	                    </div>
			          </form>
			           <script>
			           function update(){
			              let ono = document.querySelector("#ono1"); 
			              let oname = document.querySelector("#oname1");
			              let onum = document.querySelector("#onum1");
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
			
			  <div class="card">
			    <div class="card-header bg-info">
			      <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseThree">
			        Milk 주문 삭제하기
			      </a>
			    </div>
			    <div id="collapseThree" class="collapse" data-bs-parent="#accordion">
			      <div class="card-body">
			        <form action ="jsp012_delete.jsp" method="post" onsubmit = "return delete()">
			        	 <div class = "my-3">
			               <label for ="ono2" class="form-label"> 취소 주문 번호 </label>
			               <input type="text" class="form-control" id="ono2" name="ono" />
			             </div>
			             <!-- <input type="number" class="form-control" id="ono_delete" 
                         placeholder="취소할 주문번호를 적어주세요!" name="ono">
		                 </div>
		                 <button type="submit" class="btn btn-danger">주문하기</button> 
			             <div class = "my-3">
			               <label for ="oname2" class="form-label"> 삭제할 우유 이름 </label>
			               <input type="text" class="form-control" id="oname2" name="oname" />
			             </div>
			             <div class="my-3">
	                       <label for="onum2"  class="form-label"> 삭제할 우유 갯수 </label>
	                       <input type="text" class="form-control"  id="onum2"   name="onum" />
	                    </div> -->
	                    <div class="my-3"> 
	                       <button  type="submit"  class="btn btn-warning" > 주문 삭제하기 </button>
	                    </div> 
			          </form>
			           <script>
			           function delete(){ //Q1. 빈칸검사
			              let ono = document.querySelector("#ono2"); 
			              console.log(ono);
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

<!--       주문 삽입, 수정, 삭제          -->
<!--       주문 삽입, 수정, 삭제            -->
<!-- 	= MODEL
	★ 다음과 같이 테이블을 준비해주세요!
	mysql> desc milk_order;
	+-------+--------------+------+-----+-------------------+-------------------+
	| Field | Type         | Null | Key | Default           | Extra             |
	+-------+--------------+------+-----+-------------------+-------------------+
	| ono   | int          | NO   | PRI | NULL              | auto_increment    |
	| oname | varchar(20)  | NO   |     | NULL              |                   |
	| onum  | int          | NO   |     | NULL              |                   |
	| odate | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
	| oip   | varchar(100) | NO   |     | NULL              |                   |
	+-------+--------------+------+-----+-------------------+-------------------+
	5 rows in set (0.00 sec)
	
	create table milk_order(
	ono       int        not null auto_increment PRIMARY Key,  -- 필드명, 자료형, 옵션
	oname   varchar(20)  not null,
	onum      int        not null,
	odate   datetime     default  CURRENT_TIMESTAMP,
	oip     varchar(50)  not null
	);
	
	==> ERROR 1064 (42000): You have an error in your SQL syntax; 
	    check the manual that corresponds to your MySQL server version for the right syntax 
	    to use near 'oip     varchar(50) not null )' at line 6
	    
	-- Q1.  milk_order 값삽입.  insert 구문 완성    
	   insert into milk_order (oname, onum, oip) values ('banana', 1, '198.160.0.1');
	   insert into milk_order (oname, onum, oip) values ('white', 2, '198.160.0.2');
	   insert into milk_order (oname, onum, oip) values ('choco', 3, '198.160.0.3');
	-- Q2.  milk_order ono가 1인데이터 조회 
	select * from milk_order where ono=1;
	
	-- Q3.  milk_order 전체데이터조회
	select * from milk_order;
	
	-- Q4.  milk_order 해당번호의 이름과 갯수 수정
	update milk_order set oname='choco', onum =3 where ono =1;
	
	-- Q5.  milk_order 해당번호의 데이터 삭제
	delete from milk_order where ono=1;

		mysql> desc milk_order;
		+-------+-------------+------+-----+-------------------+-------------------+
		| Field | Type        | Null | Key | Default           | Extra             |
		+-------+-------------+------+-----+-------------------+-------------------+
		| ono   | int         | NO   | PRI | NULL              | auto_increment    |
		| oname | varchar(20) | NO   |     | NULL              |                   |
		| onum  | int         | NO   |     | NULL              |                   |
		| odate | datetime    | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
		| oip   | varchar(50) | NO   |     | NULL              |                   |
		+-------+-------------+------+-----+-------------------+-------------------+
		5 rows in set (0.00 sec)
		
		mysql> select * from milk_order;
		+-----+--------+------+---------------------+-------------+
		| ono | oname  | onum | odate               | oip         |
		+-----+--------+------+---------------------+-------------+
		|   2 | banana |    1 | 2026-05-20 14:59:31 | 198.160.0.1 |
		|   3 | white  |    2 | 2026-05-20 15:03:05 | 198.160.0.2 |
		|   4 | choco  |    3 | 2026-05-20 15:03:11 | 198.160.0.3 |
		+-----+--------+------+---------------------+-------------+
		3 rows in set (0.00 sec)

 -->
   
</body>
</html>