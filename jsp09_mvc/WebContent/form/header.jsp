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

<style type="text/css">
header {
	background-color: skyblue;
	hieght: 50px;
}

footer {
	background-color: skyblue;
	height: 30px;
	text-align: center;
	line-height: 30px;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<header><a href="mvc.do?command=list">HOME</a></header>
</body>
</html>