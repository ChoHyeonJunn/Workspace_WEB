package com.cal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cal.dao.CalDao;
import com.cal.dao.Util;
import com.cal.dto.CALBOARD;

@WebServlet("/calendar.do")
public class CalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CalDao dao = new CalDao();

	public CalController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String command = request.getParameter("command");

		if (command.equals("calendar")) {
			
			response.sendRedirect("calendar.jsp");

		} else if (command.equals("insertcal")) {

			String year = Util.isTwo(request.getParameter("year"));
			String month = Util.isTwo(request.getParameter("month"));
			String date = Util.isTwo(request.getParameter("date"));
			String hour = Util.isTwo(request.getParameter("hour"));
			String min = Util.isTwo(request.getParameter("min"));
			String mDate = year + month + date + hour + min;

			String id = request.getParameter("id");
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			CALBOARD calboard = new CALBOARD();
			calboard.setMDATE(mDate);
			calboard.setID(id);
			calboard.setTITLE(title);
			calboard.setCONTENT(content);

			int res = dao.insertCalBoard(calboard);

			if (res > 0) {
				jsResponse("일정 등록 성공!", "calendar.do?command=calendar", response);
			} else {
				request.setAttribute("msg", "일정 등록 실패!");
				dispatch("error.jsp", request, response);
			}

		} else if (command.equals("list")) {

			String yyyy = request.getParameter("year");
			String MM = Util.isTwo(request.getParameter("month"));
			String dd = Util.isTwo(request.getParameter("date"));
			String yyyyMMdd = yyyy + MM + dd;
			String id = "kh";
			
			List<CALBOARD> list = dao.selectCalList(id, yyyyMMdd);
			
			request.setAttribute("list", list);
			dispatch("calendarlist.jsp", request, response);
			
		}
		else {
			request.setAttribute("msg", "잘못된 접근입니다...");
			dispatch("error.jsp", request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		doGet(request, response);
	}

	// forward 해주는 메서드
	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}

	// 페이지에 특정 메세지 전달 메서드
	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		System.out.println(msg);
		out.println("<script type='text/javascript'>");
		out.println("alert('" + msg + "')");
		out.println("location.href='" + url + "'");
		out.println("</script>");
	}
}
