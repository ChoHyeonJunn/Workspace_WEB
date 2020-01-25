<%@page import="com.md.dao.MDBoardDAO"%>
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
<body>
	<%
		// muldel.jsp?chk=1&chk=2&chk=5 같은 방식으로 넘어온다.
		// 같은 이름의 여러 값을 받을 때 사용.
		String[] seqList = request.getParameterValues("chk");

		if (seqList == null || seqList.length == 0) {
	%>
	<script type="text/javascript">
		alert("삭제할 글을 1개 이상 선택해 주세요!");
		location.href = "./list.jsp";
	</script>
	<%
		} else {
			MDBoardDAO mdBoardDao = new MDBoardDAO();
			int res = mdBoardDao.multiDelete(seqList);
			
			if (res > 0) {
	%>
	<script type="text/javascript">
		alert("muldel 성공!");
		location.href = "./list.jsp";
	</script>
	<%
			} else {
	%>
	<script type="text/javascript">
		alert("muldel 실패!");
		location.href = "./list.jsp";
	</script>
	<%
			}
		}
	%>




</body>
</html>