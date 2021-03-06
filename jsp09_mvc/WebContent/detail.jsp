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

	<jsp:useBean id="dto" class="com.mvc.dto.MVCDto" scope="request"></jsp:useBean>
	
	<%@ include file="./form/header.jsp"%>
	<form action="con.do" action="POST">
		<input type="hidden" name="command" value="updateform">		
		<input type="hidden" value="<jsp:getProperty property="SEQ" name="dto"/>" name='SEQ'">
		
		<table border="1">
			<tr>
				<th>이름</th>
				<td><jsp:getProperty property="WRITER" name="dto"/></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><jsp:getProperty property="TITLE" name="dto"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" readonly = "readonly"><jsp:getProperty property="CONTENT" name="dto"/></textarea></td>
			</tr>
			<tr>
				<td colspan = "2">
					<input type="submit" value="수정"> 
					<input type="button" value="삭제" onclick="location.href='con.do?command=delete&SEQ=<jsp:getProperty property="SEQ" name="dto"/>'">
					<input type="button" value="목록" onclick="location.href='con.do?command=list'">
				</td>
			</tr>
		</table>
		
	</form>
	
	<%@ include file="./form/footer.jsp"%>	
</body>
</html>