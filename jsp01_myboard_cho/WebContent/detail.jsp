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
	
		DAO dao = new DAO();
		MYBOARD myboard = dao.selectOne(MYNO);
	%>
	
		<form action="update.jsp" action="POST">
		<table border="1">
			<tr>
				<th>이름</th>
				<td><%=myboard.getMYNAME() %></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><%=myboard.getMYTITLE() %></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" readonly = "readonly"><%=myboard.getMYCONTENT() %></textarea></td>
			</tr>
			<tr>
				<td colspan = "2">
					<input type="hidden" value="<%=MYNO%>" name='MYNO'">
					<input type="submit" value="수정"> 
					<input type="button" value="삭제" onclick="location.href='delete.jsp?MYNO=<%=MYNO%>'">
					<input type="button" value="목록" onclick="location.href='list.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>