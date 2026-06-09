<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%@include file="../inc/header.jsp"  %>
<!-- 	header		 -->
<!-- 	header		 -->
<script>
	window.addEventListener("load",function(){
		let result ='${result}'
		if(result == "글 수정 성공"){
			alert(result);
		}
		else if(result == "비밀번호 확인"){
			alert(result);
		}
	})
</script>
   <div class="container my-5">
      <h3>글 상세보기</h3>
      <form  action ="${pageContext.request.contextPath}/board/edit.do?bno=${dto.bno}"  method="post" onsubmit="return">
      	<div  class="my-3">
      		<label for="bname"   class="form-label">이름</label>
      		<input type="text"   class="form-control"    id="bname"  name="bname" value="${dto.bname }"  readonly />
      	</div>  
      	<div  class="my-3">
      		<label for="bpass"   class="form-label">비밀번호</label>
      		<input type="password"   class="form-control"    id="bpass"  name="bpass" value="${dto.bpass}" readonly/>
      	</div> 
      	<div  class="my-3">
      		<label for="btitle"  class="form-label">제목</label>
      		<input type="text"   class="form-control"    id="btitle"  name="btitle" value="${dto.btitle }"  readonly />
      	</div>
      	<div  class="my-3">
      		<label for="bcontent"  class="form-label">내용</label>
      		<textarea  class="form-control" id="bcontent" 
      		name="bcontent" readonly>${dto.bcontent}</textarea>
      	</div>
      	<%-- <c:if test="${not empty dto.bimg}">
      		<div  class="my-3">
	      		<label for="file"  class="form-label">이미지</label>
	      		<img class="img-fluid" src="${pageContext.request.contextPath}/upload/${dto.bimg}">
      		</div>
      	</c:if> --%>
      	
      	<div class="my-3">
      		<label for="file"  class="form-label">이미지</label>
      		<img class="img-fluid" src="${pageContext.request.contextPath}/upload/${dto.bimg}">
   		</div>
   		
      	<div  class="my-3  text-end"> 
      		<a href="${pageContext.request.contextPath}/board/edit.do?bno=${dto.bno}"
      		   class="btn btn-outline-primary"  title="글수정">수정</a>
      		<!-- <button type="submit" class="btn btn-outline-primary"
      			    title="글수정">수정</button> -->
      		<a href="${pageContext.request.contextPath}/board/delete.do?bno=${dto.bno}"
      		   class="btn btn-outline-success"  title="글삭제">삭제</a>
      		<a href="${pageContext.request.contextPath}/board/list.do"
      		   class="btn btn-primary"          title="목록보러가기">목록</a>
      	</div>
      </form> 
		 
   </div>
<!-- 	footer		 -->
<!-- 	footer		 -->
<%@include file="../inc/footer.jsp"  %>
