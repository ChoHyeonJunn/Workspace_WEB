<%@page import="com.vo.MYBOARD"%>
<%@page import="com.dao.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
		int MYNO = Integer.parseInt(request.getParameter("MYNO"));
		String MYNAME = request.getParameter("MYNAME");
		String MYTITLE = request.getParameter("MYTITLE");
		String MYCONTENT = request.getParameter("MYCONTENT");

		DAO dao = new DAO();
		MYBOARD myboard = new MYBOARD();

		myboard.setMYNO(MYNO);
		myboard.setMYNAME(MYNAME);
		myboard.setMYTITLE(MYTITLE);
		myboard.setMYCONTENT(MYCONTENT);
		
		int res = dao.update(myboard);

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
		location.href = "update.jsp?MYNO=<%=MYNO%>";
	</script>
	<%
		}
	%>
</body>
</html>