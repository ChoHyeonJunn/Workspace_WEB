<%@page import="java.util.ArrayList"%>
<%@page import="com.mvc.dto.MVCDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<script type="text/javascript">

	function writeForm(){
		location.href="con.do?command=writeform"
	}

	function allChk(check) {
		var chks = document.getElementsByName("chk");
		for (var i = 0; i < chks.length; i++) {
			chks[i].checked = check;
		}
	}
</script>

</head>
<body>
	<%@ include file="./form/header.jsp"%>

	<h1>글 목록</h1>

	<form action="con.do" method="post">
		<input type="hidden" name="command" value="muldel">
		
		<table border="1">
			<col width="30">
			<col width="50">
			<col width="100">
			<col width="300">
			<col width="100">
			<tr>
				<th><input type="checkbox" name="all" onclick="allChk(this.checked);"></th>
				<th>SEQ(게시물코드)</th>
				<th>WRITER(작성자)</th>
				<th>TITLE(제목)</th>
				<th>REGDATE(작성일)</th>
			</tr>
			
			<c:choose>
				
				<c:when test="${empty list }">
					<tr>
						<td colspan="4">----작성된 글이 존재하지 않습니다.----</td>
					</tr>
				</c:when>
				
				<c:otherwise>
					<c:forEach var="dto" items="${list}">
						<tr>
						<td><input type="checkbox" name="chk" value="${dto.SEQ}"></td>
						<td>${dto.SEQ}</td>
						<td>${dto.WRITER}</td>
						<td><a href="con.do?command=detail&SEQ=${dto.SEQ}">${dto.TITLE}</a></td>
						<td>${dto.REGDATE}</td>
					</tr>
					</c:forEach>						
				</c:otherwise>
				
			</c:choose>			
			
			<tr>
				<td colspan="5">
					<input type="submit" value="선택삭제">
					<input type="button" value="글쓰기" onclick="writeForm();"><!-- location.href='insert.jsp' -->
				</td>
			</tr>
		</table>
	</form>
	
	
	<%@ include file="./form/footer.jsp"%>
</body>
</html>