<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="./inc/header.jsp" %>
     <section class="container  my-5">
        <h3> Q N A 상세보기 </h3>
        <%
        request.setCharacterEncoding("UTF-8");
	    
	    String bname = "";
	    String btitle = "";
	    String bcontent = "";
	    int bhit = 0;
	    int bno = Integer.parseInt(request.getParameter("bno"));
	    
	    try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection conn = null;
	    	PreparedStatement pstmt = null;
	    	ResultSet rset = null;
	    	
	    	String url = "jdbc:mysql://localhost:3306/mbasic";
	    	String sql = "select * from mvcboard1 where bno=?";
	    	
	    	conn = DriverManager.getConnection(url,"root","1234");
	    	
	    	// 조회수 처리
	    	pstmt = conn.prepareStatement("update mvcboard1 set bhit=bhit+1 where bno=?");
	    	pstmt.setInt(1,bno);
	    	pstmt.executeUpdate();
	    	pstmt.close();
	    	
	    	pstmt = conn.prepareStatement(sql);
	    	pstmt.setInt(1,bno);
	    	
	    	rset = pstmt.executeQuery();
	    	while(rset.next()){
	    		bhit = rset.getInt("bhit");
	    		bname = rset.getString("bname");
	    		btitle = rset.getString("btitle");
	    		bcontent = rset.getString("bcontent");
	    	}
	    	
	    	if(rset != null){rset.close();}
	    	if(pstmt != null){pstmt.close();}
	    	if(conn != null){conn.close();}
	    }catch(Exception e){ e.printStackTrace();}
        %>
        <form action="#" method="post" onsubmit="return writeContent()">
	        <div class="my-3">
	        	<label for="bhit" class="form-label">조회수</label>
	        	<input type="text" class="form-control" placeholder=""
	        		id="bhit" name="bhit" value="<%=bhit %>" readonly>
	        </div>
	        <div class="my-3">
	        	<label for="bname" class="form-label">이름</label>
	        	<input type="text" class="form-control" placeholder=""
	        		id="bname" name="bname" value="<%=bname%>" readonly>
     		</div>
	        <div class="my-3">
	        	<label for="btitle" class="form-label">제목</label>
	        	<input type="text" class="form-control" placeholder=""
	        		id="btitle" name="btitle" value="<%=btitle%>" readonly>
	        </div>
	        <div class="my-3">
	        	<label for="bcontent" class="form-label">내용</label>
	        	<textarea class="form-control" id="bcontent" name="bcontent"
	        	readonly><%=bcontent%></textarea>
	       	</div>
        	<div class="my-3 text-end">
	        	<a href="/board01_mvc1/edit.jsp?bno=<%=bno %>" class="btn btn-dark" title="글수정">수정</a>
	        	<a href="/board01_mvc1/delete.jsp?bno=<%=bno %>" class="btn btn-dark" title="글삭제">삭제</a>
	        	<a href="/board01_mvc1/list.jsp" class="btn btn-dark" title="글목록">목록보기</a>
        	</div>
        
        </form>
        <script>

        </script>
        
    </section>
<%@include file="./inc/footer.jsp" %>