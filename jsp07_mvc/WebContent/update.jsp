<%@page import="com.mvc.dto.MVCDto"%>
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
		MVCDto dto = (MVCDto) request.getAttribute("dto");
	%>
	<%@ include file="./form/header.jsp"%>

	<form action="mvc.do" action="POST">
		<input type="hidden" value="updateres" name="command">
		<input type="hidden" value="<%=dto.getSEQ()%>" name='SEQ'"> 
		
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input type="text" value="<%=dto.getWRITER()%>" name="WRITER"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" value="<%=dto.getTITLE()%>" name="TITLE"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="CONTENT"><%=dto.getCONTENT()%></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정"> <input type="button" value="취소" onclick="location.href='mvc.do?command=detail&SEQ=<%=dto.getSEQ()%>'">
				</td>
			</tr>
		</table>
		
	</form>

	<%@ include file="./form/footer.jsp"%>

</body>
</html>