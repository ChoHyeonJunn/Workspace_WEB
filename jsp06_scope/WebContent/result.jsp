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
	<h1>RESULT</h1>
	
	<pre>
		page : <%=pageContext.getAttribute("pageId") %>
		request : <%=(String) request.getAttribute("requestId") %>
		session : <%=session.getAttribute("sessionId") %>
		application : <%=application.getAttribute("applicationId") %>
	</pre>
	
	
</body>
</html>