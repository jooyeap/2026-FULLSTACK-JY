<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="./inc/header.jsp" %>

     <section class="container  my-5">
        <h3> MultiBoard </h3>
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
                <!-- <tr>
                    <td>1</td>
                    <td>첫번째 글쓰기</td>
                    <td>FIRST</td>
                    <td>2026.05</td>
                    <td><span class="badge rounded-pill bg-dark">1</span></td>
                </tr> -->
                <%
                try{
                	Class.forName("com.mysql.cj.jdbc.Driver");
                	Connection conn = null;
                	PreparedStatement pstmt = null;
                	ResultSet rset = null;
                	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
                	pstmt = conn.prepareStatement("select * from mvcboard1 order by bno desc");
                	rset = pstmt.executeQuery();
                	// bno btitle bname bdate bbhit
                	while(rset.next()){
                		out.println("<tr>"
                			+"<td>"+rset.getInt("bno")
                			+"</td><td><a href='detail.jsp?bno="+rset.getInt("bno")+"'>" +rset.getString("btitle")
                			+"</a></td><td>"+rset.getString("bname")
                			+"</td><td>"+rset.getString("bdate")
                			+"</td><td>"+rset.getInt("bhit")+"</td></tr>");
                	}
                	if(rset != null){rset.close();}
                	if(pstmt != null){pstmt.close();}
                	if(conn != null){conn.close();}
                } catch(Exception e) {e.printStackTrace();}
                %>
            </tbody>
        </table>

        <div  class="text-end">
           <a href="write.jsp"  title="글쓰기 폼"  class="btn btn-primary" >글쓰기</a>
        </div>

    </section>
<%@include file="./inc/footer.jsp" %>