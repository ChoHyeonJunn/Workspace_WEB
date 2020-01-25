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


<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">

	$(function(){
		document.getElementById("SUBMIT").disabled = "disabled";

		$("input[name='MYID']").blur(function(){
			
			var id = $("input[name='MYID']");
						
			if(id.val() == null || id.val() == ""){
				alert("아이디를 입력해 주세요!");
			}else{
				$.ajax({
					type : "POST",
					url : "logincontroller.jsp?command=ajaxIdChk",
					data : { MYID : $("input[name='MYID']").val() },
					datatype : "JSON",
					
					success:function(args){
						var res = JSON.parse(args).idnotused;
						//alert(res);
 						if(res){						
							document.getElementsByName("MYID")[0].title='y';							
							//document.getElementsByName("MYPW")[0].focus();
							
							document.getElementById("idtext").innerHTML = "아이디(사용가능)";
							document.getElementById("idtext").style.color="blue";
							document.getElementById("SUBMIT").disabled = "";
						}else{
							document.getElementsByName("MYID")[0].title='n';							
							document.getElementsByName("MYID")[0].focus();
							
							document.getElementById("idtext").innerHTML = "아이디(사용불가)";
							document.getElementById("idtext").style.color="red";
						} 
					},
					
					error:function(request, status, error){	
						// 통신 실패하면 실행
						alert("실패!")
						alert("code : " + request.status + "\n" + 
								"message : " + request.responseText + "\n" + 
								"error : " + error);
					}					
				})
			}
		})
		
	})
		
	function idChkConfirm(){
		var chk = document.getElementsByName("MYID")[0].title;
		
		if(chk == "n"){
			document.getElementById("idtext").innerHTML = "아이디(필수정보입니다.)";
			document.getElementById("idtext").style.color="red";

			//document.getElementsByName("MYID")[0].focus();
		}
	}
</script>

</head>
<body>
	<h1>회원가입</h1>

	<form action="logincontroller.jsp" method="post">
		<input type="hidden" name="command" value="registres">

		<table border="1">
			<tr>
				<th id="idtext">아이디</th>
				<td>
					<input type="text" name="MYID" title="n" required="required">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="MYPW" required="required" onclick="idChkConfirm();">
				</td>
			</tr>
			<tr>
				<th>이름 :</th>
				<td>
					<input type="text" name="MYNAME" required="required" onclick="idChkConfirm();">
				</td>
			</tr>
			<tr>
				<th>주소 :</th>
				<td>
					<input type="text" name="MYADDR" required="required" onclick="idChkConfirm();">
				</td>
			</tr>
			<tr>
				<th>전화번호 :</th>
				<td>
					<input type="text" name="MYPHONE" required="required" onclick="idChkConfirm();">
				</td>
			</tr>
			<tr>
				<th>이메일 :</th>
				<td>
					<input type="text" name="MYEMAIL" required="required" onclick="idChkConfirm();">
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right;">
					<input type="submit" value="회원가입" id="SUBMIT">
				</td>
			</tr>
			
			<!-- <tr>
				<th>등급 :</th>
				<td>
					<select name="MYROLE">
						<option value="USER">일반회원</option>
						<option value="MANAGER">우수회원</option>
						<option value="ADMIN">관리자</option>
					</select>
				</td>
			</tr> -->
			
		</table>
	</form>
</body>
</html>