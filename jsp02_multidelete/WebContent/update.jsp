<%@page import="com.md.vo.MDBOARD"%>
<%@page import="com.md.dao.MDBoardDAO"%>
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
		int SEQ = Integer.parseInt(request.getParameter("SEQ"));
		MDBoardDAO dao = new MDBoardDAO();
		MDBOARD mdboard = dao.selectOne(SEQ);
	%>
	<%@ include file="./form/header.jsp"%>

	<form action="updateres.jsp" action="POST">
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input type="text" value="<%=mdboard.getWRITER()%>"
					name="WRITER"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" value="<%=mdboard.getTITLE()%>"
					name="TITLE"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="CONTENT"><%=mdboard.getCONTENT()%></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden"
					value="<%=mdboard.getSEQ()%>" name='SEQ'"> <input
					type="submit" value="수정"> <input type="button" value="취소"
					onclick="location.href='detail.jsp'"></td>
			</tr>
		</table>
	</form>

	<%@ include file="./form/footer.jsp"%>

</body>
</html>