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
	MYMEMBER mymember = (MYMEMBER) request.getAttribute("mymember");
%>


<body>
		<h1>내 정보 수정</h1>
	<button onclick="location.href='usermain.jsp'">메인으로</button>

	<form action="logincontroller.jsp" method="post">
		<input type="hidden" name="command" value="updateUsersRes">
		<input type="hidden" name="MYNO" value="<%=mymember.getMYNO()%>">

		<table border="1">
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="MYID" value="<%=mymember.getMYID() %>">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="text" name="MYPW" value="<%=mymember.getMYPW() %>">
				</td>
			</tr>
			<tr>
				<th>이름 :</th>
				<td>
					<input type="text" name="MYNAME" value="<%=mymember.getMYNAME() %>">
				</td>
			</tr>
			<tr>
				<th>주소 :</th>
				<td>
					<input type="text" name="MYADDR" value="<%=mymember.getMYADDR() %>">
				</td>
			</tr>
			<tr>
				<th>전화번호 :</th>
				<td>
					<input type="text" name="MYPHONE" value="<%=mymember.getMYPHONE() %>">
				</td>
			</tr>
			<tr>
				<th>이메일 :</th>
				<td>
					<input type="text" name="MYEMAIL" value="<%=mymember.getMYEMAIL() %>">
				</td>
			</tr>
			<tr>
				<th>등급 :</th>
				<td>
					<input type="text" name="MYEROLE" value="<%=mymember.getMYROLE() %>" readonly="readonly">
				</td>
			</tr>		
			<tr>
				<td colspan="2" style="text-align: right;">
					<input type="submit" value="수정">
				</td>
			</tr>	
		</table>
	</form>
</body>
</html>