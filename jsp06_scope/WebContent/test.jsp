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

<%
	pageContext.setAttribute("pageId", "myPageValue");
	request.setAttribute("requestId", "myRquestValue");
	session.setAttribute("sessionId", "mySessionValue");
	application.setAttribute("applicationId", "myApplicationValue");
%>
<body>




	<h1>INDEX</h1>

	<pre>
		page : <%=pageContext.getAttribute("pageId")%>
		request : <%=request.getAttribute("requestId")%>
		session : <%=session.getAttribute("sessionId")%>
		application : <%=application.getAttribute("applicationId")%>
	</pre>
	
	<a href="result.jsp">result</a>
	<a href="scope.do?req=test">servlet</a>
	
	<% //pageContext.forward("scope.do"); %>
</body>
</html>
