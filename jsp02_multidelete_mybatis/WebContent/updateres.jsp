<%@page import="com.md.vo.MDBOARD"%>
<%@page import="com.md.dao.MDBoardDAO"%>
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
		int SEQ = Integer.parseInt(request.getParameter("SEQ"));
		String WRITER = request.getParameter("WRITER");
		String TITLE = request.getParameter("TITLE");
		String CONTENT = request.getParameter("CONTENT");

		MDBoardDAO mdBoardDao = new MDBoardDAO();
		MDBOARD mdboard = new MDBOARD();

		mdboard.setSEQ(SEQ);
		mdboard.setWRITER(WRITER);
		mdboard.setTITLE(TITLE);
		mdboard.setCONTENT(CONTENT);

		int res = mdBoardDao.update(mdboard);

		if (res > 0) {
	%>
	<script type="text/javascript">
		alert("글수정 정상 등록!");
		location.href = "list.jsp";
	</script>
	<%
		} else {
	%>
	<script type="text/javascript">
		alert("글수정 실패!!");
		location.href = "update.jsp?SEQ=<%=SEQ%>
		";
	</script>
	<%
		}
	%>
</body>
</html>