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
	
	<jsp:useBean id="lee" class="com.test.dto.Score" scope="session"></jsp:useBean>
	<!-- Score lee = new Score();  랑 같은 의미!! Bean은 객체라고 생각하면 된다!! -->
	
	<jsp:setProperty property="name" name="lee" value="이순신"/>
	<!-- lee.setName("이순신"); -->
	
	<jsp:getProperty property="name" name="lee"/>
	<!-- lee.getName(); -->
	
	<a href="res.jsp">result</a>
	
</body>
</html>