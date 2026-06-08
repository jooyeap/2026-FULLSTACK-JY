<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%@include file="../inc/header.jsp"  %>
<!-- 	header		 -->
<!-- 	header		 -->
<script>
	window.addEventListener("load",function(){
		// BoardController.java 에서 addFlashAttribute 에서 처리한 result
		let result = '${result}' // el 표현
		console.log(result);
		if(result == "글쓰기 실패"){
			alert(result);
			history.go(-1); // 뒤로 돌아가기
		}
		else if(result == "글 수정 실패"){
			alert(result);
		}
		else if(result == "글 삭제 성공"){
			alert(result);
		}
	})
	
</script>

    <!--  content -->
    <section class="container  my-5">
        <h3> MultiBoard </h3>
        <pre>
페이징 : ${paging}
전체 리스트 : ${list}
        </pre>
        <table  class="table  table-striped  table-bordered table-hover">
            <caption> BOARD 목록 </caption>
            <thead>
                <tr>
                    <th scope="col">NO</th>
                    <th scope="col">TITLE</th>
                    <th scope="col">WRITER</th>
                    <th scope="col">DATE</th>
                    <th scope="col">HIT</th>
                </tr>
            </thead>
            <tbody>
				<c:forEach var="dto" items="${list}" varStatus="status">
					<tr>
						<!-- 전체 갯수 - 상태 갯수 -->
						<td>${list.size() - status.index}</td>
						<td>
							<a href="${pageContext.request.contextPath}/board/detail.do?bno=${dto.bno}">
								${dto.btitle}
							</a>
						</td>
						<td>${dto.bname}</td>
						<td>${dto.bdate}</td>
						<td>${dto.bhit}</td>
					</tr>
				</c:forEach>
            </tbody>
            <tfoot><tr><td colspan="5">
            	<ul class="pagination  justify-content-center"> 
				<!-- 이전 -->
				<li class="page-item
					<c:if test="${paging.start <= 1}"> disabled </c:if>
				">
					<a class="page-link"
					href="${pageContext.request.contextPath}/board/list.do?pstartno=${paging.start -1}">
					이전
					</a>
				</li>
				<!-- 1,2,3~~ -->
				<c:forEach var="i" begin="${paging.start}" end="${paging.end}">
					<li class="page-item
						<c:if test="${i == paging.current}">
						 	active
						</c:if>
					">
						<a href="${pageContext.request.contextPath}/board/list.do?pstartno=${i}"
						   class="page-link">${i}</a>
					</li>
				</c:forEach>
				<!-- 다음 -->
				<li class="page-item
					<c:if test="${paging.end >= paging.pagetotal}">
						disabled
					</c:if> 
				">
					<a class="page-link"
					href="${pageContext.request.contextPath}/board/list.do?pstartno=${paging.end +1}">
					다음
					</a>
				</li>
				</ul></td></tr>
            </tfoot>
        </table>

        <div  class="text-end">
           <a href="${pageContext.request.contextPath}/board/write.do"  title="글쓰기 폼"  class="btn btn-primary" >글쓰기</a>
        </div>

    </section>

 
<!-- 	footer		 -->
<!-- 	footer		 -->
<%@include file="../inc/footer.jsp"  %>


<!--                 
http://localhost:8080/spring003_mvc/
	<tr>
                 <td>1</td>
                 <td>첫번째 글쓰기</td>
                 <td>FIRST</td>
                 <td>2026.05</td>
                 <td><span class="badge rounded-pill bg-dark">1</span></td>
             </tr> 
         -->