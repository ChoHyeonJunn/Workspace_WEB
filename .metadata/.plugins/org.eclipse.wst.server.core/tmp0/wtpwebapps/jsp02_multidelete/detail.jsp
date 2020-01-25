<%@page import="com.md.vo.MDBOARD"%>
<%@page import="com.md.dao.MDBoardDAO"%>
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
		int SEQ = Integer.parseInt(request.getParameter("SEQ"));

		MDBoardDAO mdBoardDao = new MDBoardDAO();
		MDBOARD mdboard = mdBoardDao.selectOne(SEQ);
	%>

	<%@ include file="./form/header.jsp"%>
		<form action="update.jsp" action="POST">
		<table border="1">
			<tr>
				<th>이름</th>
				<td><%=mdboard.getWRITER() %></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><%=mdboard.getTITLE() %></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" readonly = "readonly"><%=mdboard.getCONTENT() %></textarea></td>
			</tr>
			<tr>
				<td colspan = "2">
					<input type="hidden" value="<%=SEQ%>" name='SEQ'">
					<input type="submit" value="수정"> 
					<input type="button" value="삭제" onclick="location.href='delete.jsp?SEQ=<%=SEQ%>'">
					<input type="button" value="목록" onclick="location.href='list.jsp'">
				</td>
			</tr>
		</table>
	</form>
	
	<%@ include file="./form/footer.jsp"%>	
</body>
</html>