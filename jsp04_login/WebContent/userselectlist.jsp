<%@page import="com.login.dto.MYMEMBER"%>
<%@page import="java.util.List"%>
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
	List<MYMEMBER> list = (List<MYMEMBER>) request.getAttribute("list");	
%>

	<h1>회원정보 조회(ALL)</h1>
	<div>
		<div>
			<a href="logincontroller.jsp?command=selectAll">회원정보 조회(ALL)</a>
			<a href="logincontroller.jsp?command=selectEnabled">회원정보 조회(ENABLED)</a>
		</div>
	</div>
		
	<table border="1">
		<tr>
			<th>MYNO(멤버번호)</th>
			<th>MYID(아이디)</th>
			<th>MYPW(패스워드)</th>
			<th>MYNAME(이름)</th>
			<th>MYADDR(주소)</th>
			<th>MYPHONE(전화번호)</th>
			<th>MYEMAIL(이메일)</th>
			<th>MYENABLED(가입여부)</th>
			<th>MYROLE(등급)</th>
		</tr>
		<%
			if (list.size() == 0) {
		%>
		<tr>
			<td colspan="5">------------ 작성된 글이 존재하지 않습니다. ------------</td>
		</tr>
		<%
			} else {
				for (int i = 0; i < list.size(); i++) {
		%>
		<tr>
			<td><%=list.get(i).getMYNO()%></td>
			<td><%=list.get(i).getMYID()%></td>
			<td><%=list.get(i).getMYPW()%></td>
			<td><%=list.get(i).getMYNAME()%></td>
			<td><%=list.get(i).getMYADDR()%></td>
			<td><%=list.get(i).getMYPHONE()%></td>
			<td><%=list.get(i).getMYEMAIL()%></td>
			<td><%=list.get(i).getMYENABLED().equals("Y")?"가입":"탈퇴"%></td>
			<td><%=list.get(i).getMYROLE()%></td>
		</tr>
		<%
			}
			}
		%>

		<tr>
			<td colspan="9">
				<button onclick="location.href='adminmain.jsp'">메인으로</button>
			</td>
		</tr>
	</table>
</body>
</html>