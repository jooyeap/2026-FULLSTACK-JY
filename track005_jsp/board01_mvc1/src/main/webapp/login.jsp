<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="./inc/header.jsp"%>
<section class="container my-5">
	<h3>로그인</h3>
	<form action="login_action.jsp" method="post" onsubmit="return check()">
		<div class="my-3">
			<label for="email" class="form-label">이메일</label>
			<input type="text" class="form-control" placeholder="이메일 입력"
				id="email" name="email">
		</div>
		
		<div class="my-3">
			<label for="bpass" class="form-label">비밀번호</label>
			<input type="password" class="form-control" placeholder="비밀번호 입력"
				id="bpass" name="bpass">
		</div>
		<div class="my-3 text-end">
			<button type="reset" class="btn btn-outline-primary">취소</button>
			<button type="submit" class="btn btn-primary">로그인</button>
		</div>
	</form>
	<script>
		function check(){
			let email = document.getElementById("email");
			let bpass = document.getElementById("bpass");
			if(email.value.trim() == ""){
				alert("이메일 빈칸 확인");
				email.focus();
				return false;
			}
			if(bpass.value.trim() == ""){
				alert("비밀번호 빈칸 확인");
				bpass.focus();
				return false;
			}
			return true;
		}
	</script>
</section>
<%@include file="./inc/footer.jsp"%>