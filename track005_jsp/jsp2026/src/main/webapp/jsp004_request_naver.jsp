<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REQUEST</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
   <div class="container card my-5">
      <h3 class="card-header">REQUEST - 요청</h3>
      <p  class="alert alert-warning my-2">
         https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=apple  <br/>
         1. 처리컨테이너(action) :  https://search.naver.com/search.naver  <br/>
         2. 처리방식   (method) :  get <br/>
         3. 보관용기   (name)   :  query <br/>
      </p>
      <form action="https://search.naver.com/search.naver" method="get" onsubmit="return check()">
      	<div class="my-2">
      		<label for="query">검색어</label>
      		<input type="text" class="form-control" placeholder="네이버에게 물어보쇼"
      			   id="query" name="query"/>
      		<button type="submit" class="btn btn-success mt-3 d-block">검색</button>
      	</div>
      </form>
      <script>
      	function check(){
      		//1. 아이디값 이용해서 query 대상 찾아오기
      		let query = document.getElementById("query");
      		console.log(q);
      		if(query.value.trim() == ""){ // query.value > 문자열 찾아와서 | trim() > 앞뒤 공백 빼고
	      		//2. 칸이 빈칸이라면 - 검색어를 입력하고 커서가게
	      		alert("검색어를 입력해주세요."); // 커서
	      		query.focus();
	      		//3. 전송여부
	      		return false;
      		}
      		return true;
      	}
      </script>
   </div>
</body>
</html>