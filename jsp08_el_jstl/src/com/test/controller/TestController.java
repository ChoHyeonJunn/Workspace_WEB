package com.test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dto.Score;

@WebServlet("/controller.do")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String command = request.getParameter("command");
		System.out.println("[" + command + "]");

		if (command.equals("el")) {

			response.sendRedirect("basic-arithmetic.jsp");

		} else if (command.equals("eltest")) {

			Score score = new Score("홍길동", 100, 100, 98);

			request.setAttribute("hong", score);
			RequestDispatcher dispatch = request.getRequestDispatcher("eltest.jsp");
			dispatch.forward(request, response);

		} else if (command.equals("jstltest")) {
			List<Score> list = new ArrayList<Score>();

			for (int i = 10; i < 50; i += 10) {
				Score sc = new Score("이름" + i, 50 + i, 50 + i, 50 + i);
				list.add(sc);
			}
			
			request.setAttribute("list", list);
			RequestDispatcher dispatch = request.getRequestDispatcher("jstltest.jsp");
			dispatch.forward(request, response);
		} else if(command.equals("usebean")) {
			
			response.sendRedirect("usebeantest.jsp");
			
		}

	}

}
