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

		MDBoardDAO mdBoardDao = new MDBoardDAO();
		int res = mdBoardDao.delete(SEQ);

		if (res > 0) {
	%>
	<script type="text/javascript">
		alert("정상적으로 삭제 됨!");
		location.href="list.jsp";
	</script>
	<%
		} else {
	%>
	<script type="text/javascript">
		alert("삭제 실패");
		location.href="detail.jsp?SEQ=<%=SEQ%>";
	</script>
	<%
		}
	%>
</body>
</html>