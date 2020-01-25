<%
	// 브라우저가 캐시에 화면(응답된 도큐먼트) 저장하지 않도록 설정!
	response.setHeader("Pragma", "no-chche");			// http 1.0
	response.setHeader("Cache-control", "no-store");	// http 1.1
	response.setHeader("Expires", "0");						// proxy server
%>

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
	MYMEMBER mymember = (MYMEMBER)session.getAttribute("mymember");

	if(mymember == null){
		pageContext.forward("index.jsp");
	}
%>
<body>


	<h1><%=mymember.getMYNAME() %>님, 환영합니다. <a href="logincontroller.jsp?command=logout">logout</a></h1>
	<h3>등급 : <%=mymember.getMYROLE() %></h3>
		
	<div>
		<div>
			<a href="logincontroller.jsp?command=selectAll">회원정보 조회(ALL)</a>
			<a href="logincontroller.jsp?command=selectEnabled">회원정보 조회(ENABLED)</a>
		</div>
	</div>
</body>
</html>