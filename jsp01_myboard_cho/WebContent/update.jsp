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
		int MYNO = Integer.parseInt(request.getParameter("MYNO"));
		System.out.println(MYNO);
		DAO dao = new DAO();
		MYBOARD myboard = dao.selectOne(MYNO);
	
		
	%>
	<form action="updateres.jsp" action="POST">
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input type="text" value="<%=myboard.getMYNAME()%>" name="MYNAME"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" value="<%=myboard.getMYTITLE()%>" name="MYTITLE"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="MYCONTENT"><%=myboard.getMYCONTENT()%></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="hidden" value="<%=myboard.getMYNO()%>" name='MYNO'"> 
				<input type="submit" value="수정">
				<input type="button" value="취소" onclick="location.href='detail.jsp'"></td>
			</tr>
		</table>
	</form>
</body>
</html>