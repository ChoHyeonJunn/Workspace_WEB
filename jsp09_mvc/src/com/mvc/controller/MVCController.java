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

@WebServlet("/con.do")
public class MVCController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MVCController() {
	}

	// forward 해주는 메서드
	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}

	// 페이지에 특정 메세지 전달 메서드
	private void jspResponse(String msg, String url, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		System.out.println(msg);
		out.println("<script type='text/javascript'>");
		out.println("alert('" + msg + "')");
		out.println("location.href='" + url + "'");
		out.println("</script>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String command = request.getParameter("command");
		System.out.println(command);

		MVCBiz mvcbiz = new MVCBizImpl();

		if (command.equals("list")) {

			List<MVCDto> list = mvcbiz.selectList();
			request.setAttribute("list", list);

			dispatch("boardlist.jsp", request, response);
		} else if (command.equals("detail")) {

			int SEQ = Integer.parseInt(request.getParameter("SEQ"));
			MVCDto dto = mvcbiz.selectOne(SEQ);
			request.setAttribute("dto", dto);
			dispatch("detail.jsp", request, response);

		} else if (command.equals("writeform")) {

			dispatch("boardwrite.jsp", request, response);

		} else if (command.equals("writeres")) {

			String WRITER = request.getParameter("WRITER");
			String TITLE = request.getParameter("TITLE");
			String CONTENT = request.getParameter("CONTENT");

			MVCDto dto = new MVCDto();
			dto.setWRITER(WRITER);
			dto.setTITLE(TITLE);
			dto.setCONTENT(CONTENT);

			int res = mvcbiz.insert(dto);

			if (res > 0)
				jspResponse("새로운 글 등록 완료!!", "mvc.do?command=list", response);
			else
				jspResponse("새로운 글 등록 실패ㅜㅜ", "mvc.do?command=writeform", response);

		} else if (command.equals("updateform")) {

			int SEQ = Integer.parseInt(request.getParameter("SEQ"));
			MVCDto dto = mvcbiz.selectOne(SEQ);

			request.setAttribute("dto", dto);
			dispatch("update.jsp", request, response);

		} else if (command.equals("updateres")) {

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
			if (res > 0)
				jspResponse("글 수정 완료!!", "mvc.do?command=detail&SEQ=" + SEQ, response);
			else
				jspResponse("글 수정 실패ㅜㅜ", "mvc.do?command=updateform&SEQ=" + SEQ, response);

		} else if (command.equals("delete")) {

			int SEQ = Integer.parseInt(request.getParameter("SEQ"));
			int res = mvcbiz.delete(SEQ);

			if (res > 0)
				jspResponse("글 삭제 완료!!", "mvc.do?command=list", response);
			else
				jspResponse("'글 삭제 실패ㅜㅜ", "mvc.do?command=detail&SEQ=" + SEQ, response);

		} else if (command.equals("muldel")) {

			String[] seqList = request.getParameterValues("chk");

			if (seqList == null || seqList.length == 0) {
				jspResponse("삭제할 글을 1개 이상 선택해 주세요!", "mvc.do?command=list", response);
			} else {
				boolean mulbool = mvcbiz.multiDelete(seqList);

				if (mulbool)
					jspResponse("muldel 성공!", "mvc.do?command=list", response);
				else
					jspResponse("muldel 실패!", "mvc.do?command=list", response);
			}

		}

		response.getWriter().append("<h1><a href='con.do?command=list'>잘못왔다.</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		doGet(request, response);
	}

}
