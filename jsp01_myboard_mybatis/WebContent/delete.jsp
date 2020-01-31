<%@page import="com.dao.DAO"%>
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
		int MYNO = Integer.parseInt(request.getParameter("MYNO"));

		DAO dao = new DAO();
		int res = dao.delete(MYNO);

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
		location.href="detail.jsp?MYNO=<%=MYNO%>";
	</script>
	<%
		}
	%>
</body>
</html>