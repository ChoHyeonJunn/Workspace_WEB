package com.scope.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ScopeController")
public class ScopeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ScopeController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		System.out.println("Controller 도착!");

		String requestId = (String) request.getAttribute("requestId");
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("sessionId");
		ServletContext application = getServletContext();
		String applicationId = (String) application.getAttribute("applicationId");

		System.out.println("request : " + requestId);
		System.out.println("sessionId : " + sessionId);
		System.out.println("applicationId : " + applicationId);

		String parameter = request.getParameter("req");
		System.out.println("request parameter : " + parameter);

//		PrintWriter out = response.getWriter();
//		out.print("<h1>응답</h1>");
//		out.print("<table border='1'>");
//		out.print("<tr>");
//		out.print("<th>scope</th>");
//		out.print("<th>값</th>");
//		out.print("</tr>");
//		out.print("<tr>");
//		out.print("<th>page</th>");
//		out.print("<td>null</td>");
//		out.print("</tr>");
//		out.print("<tr>");
//		out.print("<th>request</th>");
//		out.print("<td>" + requestId + "</td>");
//		out.print("</tr>");
//		out.print("<tr>");
//		out.print("<th>session</th>");
//		out.print("<td>" + sessionId + "</td>");
//		out.print("</tr>");
//		out.print("<tr>");
//		out.print("<th>application</th>");
//		out.print("<td>" + applicationId + "</td>");
//		out.print("</tr>");
//		out.print("</table>");
		
		RequestDispatcher dispatch = request.getRequestDispatcher("result.jsp");
		request.setAttribute("requestId", "servlet에서 보내준 request");
		dispatch.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		doGet(request, response); // doGet으로 전달!!
	}

}
