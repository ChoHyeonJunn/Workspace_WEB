package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.biz.MVCBiz;
import com.mvc.biz.MVCBizImpl;
import com.mvc.dto.MVCDto;

@WebServlet("/MVCController")
public class MVCController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String view;
	private PrintWriter out;

	MVCBiz mvcbiz = new MVCBizImpl();

	public MVCController() {
	}

	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.request = request;
		this.response = response;

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		out = response.getWriter();

		String command = request.getParameter("command");

		if (command == null)
			command = "list";

		switch (command) {
		case "list":
			list();
			break;
		case "detail":
			detail();
			break;
		case "writeform":
			writeform();
			break;
		case "writeres":
			writeres();
			return;
		case "updateform":
			updateform();
			break;
		case "updateres":
			updateres();
			return;
		case "delete":
			delete();
			return;
		case "muldel":
			muldel();
			return;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void muldel() {
		String[] seqList = request.getParameterValues("chk");

		if (seqList == null || seqList.length == 0) {
			out.print("<script>alert('삭제할 글을 1개 이상 선택해 주세요!'); location.href='mvc.do?command=list';</script>");
		} else {
			boolean mulbool = mvcbiz.multiDelete(seqList);

			if (mulbool) {
				out.print("<script>alert('muldel 성공!'); location.href='mvc.do?command=list';</script>");
			} else {
				out.print("<script>alert('muldel 실패!'); location.href='mvc.do?command=list';</script>");
			}
		}
	}

	private void delete() {
		int SEQ = Integer.parseInt(request.getParameter("SEQ"));
		int res = mvcbiz.delete(SEQ);

		if (res > 0) {
			out.print("<script>alert('글 삭제 완료!!'); location.href='mvc.do?command=list';</script>");
		} else {
			out.print("<script>alert('글 삭제 실패ㅜㅜ'); location.href='mvc.do?command=detail&SEQ=" + SEQ + "';</script>");
		}
	}

	private void updateres() {
		int SEQ = Integer.parseInt(request.getParameter("SEQ"));
		String WRITER = request.getParameter("WRITER");
		String TITLE = request.getParameter("TITLE");
		String CONTENT = request.getParameter("CONTENT");

		MVCDto dto = new MVCDto();
		dto.setSEQ(SEQ);
		dto.setWRITER(WRITER);
		dto.setTITLE(TITLE);
		dto.setCONTENT(CONTENT);

		int res = mvcbiz.update(dto);
		if (res > 0) {
			out.print("<script>alert('글 수정 완료!!'); location.href='mvc.do?command=detail&SEQ=" + SEQ + "';</script>");
		} else {
			out.print(
					"<script>alert('글 수정 실패ㅜㅜ'); location.href='mvc.do?command=updateform&SEQ=" + SEQ + "';</script>");
		}
	}

	private void updateform() {
		int SEQ = Integer.parseInt(request.getParameter("SEQ"));
		MVCDto dto = mvcbiz.selectOne(SEQ);

		request.setAttribute("dto", dto);
		view = "update.jsp";
	}

	private void writeres() {
		String WRITER = request.getParameter("WRITER");
		String TITLE = request.getParameter("TITLE");
		String CONTENT = request.getParameter("CONTENT");

		MVCDto dto = new MVCDto();
		dto.setWRITER(WRITER);
		dto.setTITLE(TITLE);
		dto.setCONTENT(CONTENT);

		int res = mvcbiz.insert(dto);

		if (res > 0) {
			out.print("<script>alert('새로운 글 등록 완료!!'); location.href='mvc.do?command=list';</script>");
		} else {
			out.print("<script>alert('새로운 글 등록 실패ㅜㅜ'); location.href='mvc.do?command=writeform';</script>");

		}
	}

	private void writeform() {
		view = "boardwrite.jsp";
	}

	private void detail() {
		int SEQ = Integer.parseInt(request.getParameter("SEQ"));
		MVCDto dto = mvcbiz.selectOne(SEQ);
		request.setAttribute("dto", dto);
		view = "detail.jsp";
	}

	private void list() {
		List<MVCDto> list = mvcbiz.selectList();
		request.setAttribute("list", list);
		view = "boardlist.jsp";
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
