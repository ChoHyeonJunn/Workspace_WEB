package com.answer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.answer.biz.AnswerBiz;
import com.answer.biz.AnswerBizImpl;
import com.answer.dto.AnswerDTO;

@WebServlet(urlPatterns = { "/mylist", "/mydetail", "/writeform", "/mywriteres", "/myupdateform", "/myupdateres",
		"/mydelete", "/mymuldel", "/mysubwrite", "/mysubwriteres" })
public class AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AnswerBiz biz;

	public AnswerServlet() {
	}

	private void getRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		biz = new AnswerBizImpl();

		String command = request.getRequestURI();
		System.out.printf("[%s]\n", command);

		if (command.endsWith("/mylist")) {
			doMyList(request, response);
		} else if (command.endsWith("/mydetail")) {
			doMyDetail(request, response);
		} else if (command.endsWith("/writeform")) {
			doMyWriteForm(request, response);
		} else if (command.endsWith("/mywriteres")) {
			doMyWriteRes(request, response);
		} else if (command.endsWith("/myupdateform")) {
			doMyUpdateForm(request, response);
		} else if (command.endsWith("myupdateres")) {
			doMyUpdateRes(request, response);
		} else if (command.endsWith("mydelete")) {
			doMyDelete(request, response);
		} else if (command.endsWith("mymuldel")) {
			doMyMulDel(request, response);
		} else if (command.endsWith("mysubwrite")) {
			doMySubWriteForm(request, response);
		} else if (command.endsWith("mysubwriteres")) {
			doMySubWriteRes(request, response);
		}

	}

	private void doMySubWriteRes(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int BOARDNO = Integer.parseInt(request.getParameter("BOARDNO"));
		String WRITER = request.getParameter("WRITER");
		String TITLE = request.getParameter("TITLE");
		String CONTENT = request.getParameter("CONTENT");

		AnswerDTO dto = new AnswerDTO();
		dto.setWRITER(WRITER);
		dto.setTITLE(TITLE);
		dto.setCONTENT(CONTENT);

		int res = biz.insertSub(dto, BOARDNO);
		if (res > 0) {
			jsResponse("답글 작성 완료!!", "mylist", response);
		} else {
			jsResponse("답글 작성 실패ㅜㅜ", "mydetail?BOARDNO=" + BOARDNO, response);
		}
	}

	private void doMySubWriteForm(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setAttribute("BOARDNO", request.getParameter("BOARDNO"));
		request.setAttribute("TITLE", request.getParameter("TITLE"));

		dispatch("mysubwrite.jsp", request, response);
	}

	private void doMyMulDel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String[] seqList = request.getParameterValues("chk");

		if (seqList == null || seqList.length == 0) {
			jsResponse("삭제할 글을 1개 이상 선택해 주세요!", "mylist", response);
		} else {
			boolean mulbool = biz.multiDelete(seqList);

			if (mulbool)
				jsResponse("muldel 성공!", "mylist", response);
			else
				jsResponse("muldel 실패!", "mylist", response);
		}
	}

	private void doMyDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int BOARDNO = Integer.parseInt(request.getParameter("BOARDNO"));
		int TITLETAB = Integer.parseInt(request.getParameter("TITLETAB"));
		int GROUPNO = Integer.parseInt(request.getParameter("GROUPNO"));
		int GROUPSEQ = Integer.parseInt(request.getParameter("GROUPSEQ"));
		
		int res = biz.delete(BOARDNO, TITLETAB, GROUPNO, GROUPSEQ);

		if (res > 0)
			jsResponse("글 삭제 완료!!", "mylist", response);
		else if (res == -1)
			jsResponse("답글이 존재해 삭제할 수 없습니다.", "mydetail?BOARDNO=" + BOARDNO, response);
		else
			jsResponse("글 삭제 실패ㅜㅜ", "mydetail?BOARDNO=" + BOARDNO, response);
	}

	private void doMyUpdateRes(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int BOARDNO = Integer.parseInt(request.getParameter("BOARDNO"));
		String WRITER = request.getParameter("WRITER");
		String TITLE = request.getParameter("TITLE");
		String CONTENT = request.getParameter("CONTENT");

		AnswerDTO dto = new AnswerDTO();
		dto.setBOARDNO(BOARDNO);
		dto.setWRITER(WRITER);
		dto.setTITLE(TITLE);
		dto.setCONTENT(CONTENT);

		int res = biz.update(dto);
		if (res > 0)
			jsResponse("글 수정 완료!!", "mydetail?BOARDNO=" + BOARDNO, response);
		else
			jsResponse("글 수정 실패ㅜㅜ", "myupdateform?BOARDNO=" + BOARDNO, response);
	}

	private void doMyUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int BOARDNO = Integer.parseInt(request.getParameter("BOARDNO"));
		AnswerDTO dto = biz.selectOne(BOARDNO);

		request.setAttribute("dto", dto);
		dispatch("myupdate.jsp", request, response);
	}

	private void doMyWriteRes(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String WRITER = request.getParameter("WRITER");
		String TITLE = request.getParameter("TITLE");
		String CONTENT = request.getParameter("CONTENT");

		AnswerDTO dto = new AnswerDTO();
		dto.setWRITER(WRITER);
		dto.setTITLE(TITLE);
		dto.setCONTENT(CONTENT);

		int res = biz.insert(dto);

		if (res > 0)
			jsResponse("새로운 글 등록 완료!!", "mylist", response);
		else
			jsResponse("새로운 글 등록 실패ㅜㅜ", "mylist", response);
	}

	private void doMyWriteForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("mywrite.jsp");
	}

	private void doMyDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int BOARDNO = Integer.parseInt(request.getParameter("BOARDNO"));
		AnswerDTO dto = biz.selectOne(BOARDNO);
		request.setAttribute("dto", dto);
		dispatch("mydetail.jsp", request, response);
	}

	private void doMyList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<AnswerDTO> list = biz.selectList();
		request.setAttribute("list", list);
		dispatch("mylist.jsp", request, response);
	}

	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}

	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('" + msg + "')");
		out.println("location.href='" + url + "'");
		out.println("</script>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		getRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		getRequest(request, response);
	}

}
