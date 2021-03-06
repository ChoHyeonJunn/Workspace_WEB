<%@page import="com.mvc.dto.MVCDto"%>
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
		MVCDto dto = (MVCDto) request.getAttribute("dto");
	%>

	<%@ include file="./form/header.jsp"%>
	<form action="MVCController.jsp" action="POST">
	
		<input type="hidden" name="command" value="updateform">		
		<input type="hidden" value="<%=dto.getSEQ()%>" name='SEQ'">
		
		<table border="1">
			<tr>
				<th>이름</th>
				<td><%=dto.getWRITER() %></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><%=dto.getTITLE() %></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" readonly = "readonly"><%=dto.getCONTENT() %></textarea></td>
			</tr>
			<tr>
				<td colspan = "2">
					<input type="submit" value="수정"> 
					<input type="button" value="삭제" onclick="location.href='MVCController.jsp?command=delete&SEQ=<%=dto.getSEQ()%>'">
					<input type="button" value="목록" onclick="location.href='MVCController.jsp?command=list'">
				</td>
			</tr>
		</table>
		
	</form>
	
	<%@ include file="./form/footer.jsp"%>	
</body>
</html>