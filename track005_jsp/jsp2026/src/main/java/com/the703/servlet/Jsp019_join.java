package com.the703.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinAction")
public class Jsp019_join extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Jsp019_join() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String nickname = request.getParameter("nickname");
		String bpass = request.getParameter("bpass");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		System.out.println(nickname +"/"+ bpass +"/"+ email +"/" + mobile);
		
		
		request.setAttribute("nickname", nickname);
		request.setAttribute("bpass", bpass);
		request.setAttribute("email", email);
		request.setAttribute("mobile", mobile);
		
		request.getRequestDispatcher("jsp019_result.jsp").forward(request, response);
	}

}
