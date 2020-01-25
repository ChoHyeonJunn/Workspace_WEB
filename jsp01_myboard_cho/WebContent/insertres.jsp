<%@page import="com.vo.MYBOARD"%>
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
		String MYNAME = request.getParameter("MYNAME");
		String MYTITLE = request.getParameter("MYTITLE");
		String MYCONTENT = request.getParameter("MYCONTENT");

		DAO dao = new DAO();
		MYBOARD myboard = new MYBOARD();

		myboard.setMYNAME(MYNAME);
		myboard.setMYTITLE(MYTITLE);
		myboard.setMYCONTENT(MYCONTENT);
		
		System.out.println(myboard);
		int res = dao.insert(myboard);

		if (res > 0) {
	%>
	<script type="text/javascript">
		alert("글쓰기 정상 등록!");
		location.href = "list.jsp";
	</script>
	<%
		} else {
	%>
	<script type="text/javascript">
		alert("글쓰기 실패!!");
		location.href = "insert.jsp";
	</script>
	<%
		}
	%>
</body>
</html>