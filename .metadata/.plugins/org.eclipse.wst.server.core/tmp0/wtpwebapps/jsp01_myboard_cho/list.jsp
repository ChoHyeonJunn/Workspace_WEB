<%@page import="com.vo.MYBOARD"%>
<%@page import="java.util.List"%>
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
		DAO dao = new DAO();
		List<MYBOARD> list = dao.selectList();
	%>


	<h1>게시판 리스트</h1>

	<table border="1">
		<tr>
			<th>MYNO(게시물코드)</th>
			<th>MYNAME(작성자)</th>
			<th>MYTITLE(제목)</th>
			<th>MYDATE(작성일)</th>
		</tr>

		<%
			for (int i = 0; i < list.size(); i++) {
		%>

		<tr>
			<td><%=list.get(i).getMYNO()%></td>
			<td><%=list.get(i).getMYNAME()%></td>
			<td><a href="detail.jsp?MYNO=<%=list.get(i).getMYNO()%>"><%=list.get(i).getMYTITLE()%></a></td>
			<td><%=list.get(i).getMYDATE()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<button onclick="location.href='insert.jsp'">글쓰기</button>

</body>
</html>3