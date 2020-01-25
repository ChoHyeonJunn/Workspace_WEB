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
	
	<%@ include file="./form/header.jsp"%>
	<form action="myupdateform" action="POST">
		<input type="hidden" value="${dto.SEQ }" name='SEQ'">
		
		<table border="1">
			<tr>
				<th>이름</th>
				<td>${dto.WRITER }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${dto.TITLE }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" readonly = "readonly">${dto.CONTENT }</textarea></td>
			</tr>
			<tr>
				<td colspan = "2">
					<input type="submit" value="수정"> 
					<input type="button" value="삭제" onclick="location.href='mydelete?SEQ=${dto.SEQ }'">
					<input type="button" value="목록" onclick="location.href='mylist'">
				</td>
			</tr>
		</table>
		
	</form>
	
	<%@ include file="./form/footer.jsp"%>	
</body>
</html>