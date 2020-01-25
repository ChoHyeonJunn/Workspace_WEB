<%@page import="java.util.ArrayList"%>
<%@page import="com.mvc.dto.MVCDto"%>
<%@page import="java.util.List"%>
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

<script type="text/javascript">

	function writeForm(){
		location.href="mvc.do?command=writeform"
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
	<%
		List<MVCDto> list = (List<MVCDto>) request.getAttribute("list");
	%>

	<%@ include file="./form/header.jsp"%>

	<h1>게시판 리스트</h1>

	<form action="mvc.do" method="post">
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
				<td><input type="checkbox" name="chk" value="<%=list.get(i).getSEQ()%>"></td>
				<td><%=list.get(i).getSEQ()%></td>
				<td><%=list.get(i).getWRITER()%></td>
				<td><a href="mvc.do?command=detail&SEQ=<%=list.get(i).getSEQ()%>"><%=list.get(i).getTITLE()%></a></td>
				<td><%=list.get(i).getREGDATE()%></td>
			</tr>
			<%
					}
				}
			%>
			
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