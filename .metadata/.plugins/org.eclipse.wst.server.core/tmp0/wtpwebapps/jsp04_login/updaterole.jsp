<%@page import="com.login.dto.MYMEMBER"%>
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

	<%
		MYMEMBER mymember = (MYMEMBER) request.getAttribute("select");
	%>

<body>	
	<h1>회원 등급 변경</h1>
	
	<form action="logincontroller.jsp" method="post">
		<input type="hidden" name="command" value="updateroleres">
		<input type="hidden" name="MYNO" value="<%=mymember.getMYNO()%>">
		
		<table border = "1">
			<tr>
				<th>이름</th>
				<td><%=mymember.getMYNAME()%></td>
			</tr>
			<tr>
				<th>등급</th>
				<td>
					<select name="MYROLE">
						<option value="USER"<%=mymember.getMYROLE().equals("USER")?"selected":"" %>>일반회원</option>
						<option value="MANAGER"<%=mymember.getMYROLE().equals("USER")?"selected":"" %>>우수회원</option>
						<option value="ADMIN" <%=mymember.getMYROLE().equals("ADMIN")?"selected":"" %>>관리자</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="변경">
					<input type="button" value="취소" onclick="location.href='logincontroller.jsp?command=selectEnabled'">
				</td>
			</tr>
		</table>
		
	</form>
</body>
</html>