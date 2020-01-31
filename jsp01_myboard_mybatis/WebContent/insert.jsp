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
	<h1>글쓰기</h1>

	<form action="insertres.jsp" action="POST">
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input type="text" name="MYNAME"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="MYTITLE"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="MYCONTENT"></textarea></td>
			</tr>
			<tr>
				<td colspan = "2">
					<input type="submit" value="등록"> 
					<input type="button" value="취소" onclick="location.href='list.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>