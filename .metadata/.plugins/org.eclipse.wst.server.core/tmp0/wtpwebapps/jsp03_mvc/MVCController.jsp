<%@page import="com.mvc.dto.MVCDto"%>
<%@page import="java.util.List"%>
<%@page import="com.mvc.biz.MVCBizImpl"%>
<%@page import="com.mvc.biz.MVCBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		MVCBiz mvcbiz = new MVCBizImpl();

		int SEQ = 0;
		String WRITER = "";
		String TITLE = "";
		String CONTENT = "";
		int res = 0;

		String command = request.getParameter("command");
		System.out.println("<" + command + ">");

		switch (command) {

			case "list" :
				List<MVCDto> list = mvcbiz.selectList();
				request.setAttribute("list", list);
				pageContext.forward("boardlist.jsp");
				break;
			case "detail" :
				MVCDto detailDto = mvcbiz.selectOne(Integer.parseInt(request.getParameter("SEQ")));
				request.setAttribute("dto", detailDto);
				pageContext.forward("detail.jsp");
				break;
			case "writeform" :
				response.sendRedirect("boardwrite.jsp"); //단순화면전환에 많이 쓴다.
				break;
			case "writeres" :
				WRITER = request.getParameter("WRITER");
				TITLE = request.getParameter("TITLE");
				CONTENT = request.getParameter("CONTENT");

				MVCDto insertDto = new MVCDto();
				insertDto.setWRITER(WRITER);
				insertDto.setTITLE(TITLE);
				insertDto.setCONTENT(CONTENT);

				res = mvcbiz.insert(insertDto);

				if (res > 0) {
	%>
	<script type="text/javascript">
		alert("새로운 글 등록 완료하였습니다.");
		location.href = "MVCController.jsp?command=list";
	</script>
	<%
		} else {
	%>
	<script type="text/javascript">
		alert("새로운 글 등록에 실패하였습니다.");
		location.href = "MVCController.jsp?command=writeform";
	</script>
	<%
		}
				break;
			case "updateform" :
				SEQ = Integer.parseInt(request.getParameter("SEQ"));
				MVCDto updateDto = mvcbiz.selectOne(SEQ);

				request.setAttribute("dto", updateDto);
				pageContext.forward("update.jsp");
				break;
			case "updateres" :
				SEQ = Integer.parseInt(request.getParameter("SEQ"));
				WRITER = request.getParameter("WRITER");
				TITLE = request.getParameter("TITLE");
				CONTENT = request.getParameter("CONTENT");

				MVCDto updateDto2 = new MVCDto();
				updateDto2.setSEQ(SEQ);
				updateDto2.setWRITER(WRITER);
				updateDto2.setTITLE(TITLE);
				updateDto2.setCONTENT(CONTENT);

				res = mvcbiz.update(updateDto2);
				if (res > 0) {
	%>
	<script type="text/javascript">
		alert("글 수정 성공!");
		location.href="MVCController.jsp?command=detail&SEQ=<%=SEQ%>";
	</script>
	<%
		} else {
	%>
	<script type="text/javascript">
		alert("글 수정 실패");
		location.href="MVCController.jsp?command=updateform&SEQ=<%=SEQ%>";
	</script>
	<%
		}
				break;
			case "delete" :
				SEQ = Integer.parseInt(request.getParameter("SEQ"));
				res = mvcbiz.delete(SEQ);
				if (res > 0) {
	%>
	<script type="text/javascript">
		alert("글 삭제 성공!");
		location.href="MVCController.jsp?command=list";
	</script>
	<%
		} else {
	%>
	<script type="text/javascript">
		alert("글 삭제 실패");
		location.href="MVCController.jsp?command=detail&SEQ=<%=SEQ%>";
	</script>
	<%
		}
				break;
			case "muldel" :
				String[] seqList = request.getParameterValues("chk");
				
				if (seqList == null || seqList.length == 0) {
	%>
	<script type="text/javascript">
		alert("삭제할 글을 1개 이상 선택해 주세요!");
		location.href = "MVCController.jsp?command=list";
	</script>
	<%
				} else {
					boolean mulbool = mvcbiz.multiDelete(seqList);

					if (mulbool) {
	%>
	<script type="text/javascript">
		alert("muldel 성공!");
		location.href = "MVCController.jsp?command=list";
	</script>
	<%
					} else {
	%>
	<script type="text/javascript">
		alert("muldel 실패!");
		location.href = "MVCController.jsp?command=list";
	</script>
	<%
					}
				}

			break;
		}
	%>

	<h1>잘못왔다,,,</h1>
</body>
</html>