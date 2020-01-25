<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@page import="com.login.dto.MYMEMBER"%>
<%@page import="com.login.biz.MyMemberBizImpl"%>
<%@page import="com.login.biz.MyMemberBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>

	<%
		MyMemberBiz biz = new MyMemberBizImpl();

		String command = request.getParameter("command");
		System.out.println("<" + command + ">");

		if (command.equals("login")) {

			String MYID = request.getParameter("MYID");
			String MYPW = request.getParameter("MYPW");

			MYMEMBER mymember = biz.login(MYID, MYPW);

			if (mymember != null) {
				// session : 만료되지 전까지 어플레케이션 전체에서 사용 가능!	
				session.setAttribute("mymember", mymember);
				session.setMaxInactiveInterval(10 * 60);
				// setMaxInactiveInterval(second) : 해당 초 만큼 활동이 없으면 session invalidate 한다.
				// (defalut : 30분 / 음수 : 무제한)

				if (mymember.getMYROLE().equals("ADMIN")) {
					response.sendRedirect("adminmain.jsp");
				} else if (mymember.getMYROLE().equals("USER")){
					response.sendRedirect("usermain.jsp");
				}
			} else {
	%>
			<script type="text/javascript">
				alert("id와 pw를 다시한번 확인해 주세요!");
				location.href="index.jsp";
			</script>
	<%
			}

		} else if (command.equals("logout")) {

			session.invalidate();
			response.sendRedirect("index.jsp");

		} else if (command.equals("selectAll")) {

			List<MYMEMBER> list = biz.selectList();
			request.setAttribute("list", list);
			pageContext.forward("userselectlist.jsp");

		} else if (command.equals("selectEnabled")) {

			List<MYMEMBER> list = biz.selectEnabled();
			request.setAttribute("list", list);
			pageContext.forward("userselectenabled.jsp");

		} else if (command.equals("updateroleform")) {

			int MYNO = Integer.parseInt(request.getParameter("MYNO"));

			MYMEMBER mymember = biz.selectUser(MYNO);
			request.setAttribute("select", mymember);

			pageContext.forward("updaterole.jsp");

		} else if (command.equals("updateroleres")) {

			int MYNO = Integer.parseInt(request.getParameter("MYNO"));
			String MYROLE = request.getParameter("MYROLE");

			int res = biz.updateRole(MYNO, MYROLE);

			if (res > 0) {
	%>
	<script type="text/javascript">
					alert("회원 등급 변경 성공!");
					location.href="logincontroller.jsp?command=selectEnabled";
				</script>
	<%
			} else {
	%>
	<script type="text/javascript">
					alert("회원 등급 변경 실패");
					location.href="logincontroller.jsp?command=updateroleform&MYNO=<%=MYNO%>";
	</script>
	<%
		}

		} else if (command.equals("registform")) {

			response.sendRedirect("registform.jsp");

		} else if (command.equals("registres")) {

			MYMEMBER mymember = new MYMEMBER();
			mymember.setMYID(request.getParameter("MYID"));
			mymember.setMYPW(request.getParameter("MYPW"));
			mymember.setMYNAME(request.getParameter("MYNAME"));
			mymember.setMYADDR(request.getParameter("MYADDR"));
			mymember.setMYPHONE(request.getParameter("MYPHONE"));
			mymember.setMYEMAIL(request.getParameter("MYEMAIL"));
			
			int res = biz.insertUser(mymember);
			
			if(res > 0){
				%>
				<script type="text/javascript">
					alert("회원 가입 성공!");
					location.href="index.jsp";
				</script>
				<%
			}else{
				%>
				<script type="text/javascript">
					alert("회원 가입 실패!");
					location.href="index.jsp";
				</script>
				<%
			}
		} else if (command.equals("idchk")) {

			String id = request.getParameter("id");
			MYMEMBER mymember = biz.idChk(id);

			boolean idnotused = true;
			if (mymember != null) {
				idnotused = false;
			}
			
			response.sendRedirect("idChk.jsp?idnotused=" + idnotused);
			
		} else if (command.equals("ajaxIdChk")){
			
			
			
			
			JSONObject json = new JSONObject();
			String id = request.getParameter("MYID");
			
			MYMEMBER mymember = biz.idChk(id);
			boolean idnotused = true;
			if (mymember != null) {
				idnotused = false;
			}						
			
			json.put("idnotused", idnotused);
			
			PrintWriter pout = response.getWriter();
			pout.print(json.toString());
			
			
			
			
						
		} else if(command.equals("usersData")){
			
			int MYNO = Integer.parseInt(request.getParameter("MYNO"));
			MYMEMBER mymember = biz.selectUser(MYNO);

			request.setAttribute("mymember", mymember);
			pageContext.forward("usersData.jsp");
			
		} else if(command.equals("updateUsersData")){
			
			int MYNO = Integer.parseInt(request.getParameter("MYNO"));
			MYMEMBER mymember = biz.selectUser(MYNO);
			
			request.setAttribute("mymember", mymember);
			pageContext.forward("updateUsersData.jsp");
			
		} else if(command.equals("updateUsersRes")){
			
			MYMEMBER mymember = new MYMEMBER();

			mymember.setMYNO(Integer.parseInt(request.getParameter("MYNO")));
			mymember.setMYID(request.getParameter("MYID"));
			mymember.setMYPW(request.getParameter("MYPW"));
			mymember.setMYNAME(request.getParameter("MYNAME"));
			mymember.setMYADDR(request.getParameter("MYADDR"));
			mymember.setMYPHONE(request.getParameter("MYPHONE"));
			mymember.setMYEMAIL(request.getParameter("MYEMAIL"));
			
			int res = biz.updateUser(mymember);
			
			if(res > 0){
				%>
				<script type="text/javascript">
					alert("수정 성공!!");
					location.href="logincontroller.jsp?command=usersData&MYNO=<%=mymember.getMYNO()%>";
				</script>
				<%
			}else{
				%>				
				<script type="text/javascript">
					alert("수정 실패 ㅜㅜㅜ!!");
					location.href="logincontroller.jsp?command=usersData&MYNO=<%=mymember.getMYNO()%>";
				</script>
				<%
			}
			
		} else if (command.equals("delete")){
			
			int MYNO = Integer.parseInt(request.getParameter("MYNO"));
			
			int res = biz.deleteUser(MYNO);
			
			if(res > 0){
				%>
				<script type="text/javascript">
					alert("탈퇴 성공!!");
					location.href="index.jsp";
				</script>
				<%
			}else{
				%>				
				<script type="text/javascript">
					alert("탈퇴 실패 ㅜㅜㅜ!!");
					location.href="logincontroller.jsp?command=usersData&MYNO=<%=MYNO%>";
				</script>
				<%
			}
		}
	%>
