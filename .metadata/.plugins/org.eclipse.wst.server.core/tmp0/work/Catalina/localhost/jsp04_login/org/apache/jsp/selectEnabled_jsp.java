/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.49
 * Generated at: 2020-01-09 10:20:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.login.dto.MYMEMBER;
import java.util.List;

public final class selectEnabled_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.login.dto.MYMEMBER");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
 request.setCharacterEncoding("UTF-8"); 
      out.write('\r');
      out.write('\n');
 response.setContentType("text/html; charset=UTF-8");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

	List<MYMEMBER> list = (List<MYMEMBER>) request.getAttribute("list");	

      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<h1>회원정보 조회(ENABLED)</h1>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<a href=\"logincontroller.jsp?command=selectAll\">회원정보 조회(ALL)</a>\r\n");
      out.write("\t\t\t<a href=\"logincontroller.jsp?command=selectEnabled\">회원정보 조회(ENABLED)</a>\r\n");
      out.write("\t\t\t<a href=\"adminmain.jsp\">관리자 메인화면</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<form action=\"logincontroller.jsp\" method=\"post\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"command\" value=\"muldel\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table border=\"1\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th><input type=\"checkbox\" name=\"all\" onclick=\"allChk(this.checked);\"></th>\r\n");
      out.write("\t\t\t\t<th>MYNO(멤버번호)</th>\r\n");
      out.write("\t\t\t\t<th>MYID(아이디)</th>\r\n");
      out.write("\t\t\t\t<th>MYPW(패스워드)</th>\r\n");
      out.write("\t\t\t\t<th>MYNAME(이름)</th>\r\n");
      out.write("\t\t\t\t<th>MYADDR(주소)</th>\r\n");
      out.write("\t\t\t\t<th>MYPHONE(전화번호)</th>\r\n");
      out.write("\t\t\t\t<th>MYEMAIL(이메일)</th>\r\n");
      out.write("\t\t\t\t<th>MYENABLED(가입여부)</th>\r\n");
      out.write("\t\t\t\t<th>MYROLE(등급)</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t");

				if (list.size() == 0) {
			
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"5\">------------ 작성된 글이 존재하지 않습니다. ------------</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");

				} else {
					for (int i = 0; i < list.size(); i++) {
			
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><input type=\"checkbox\" name=\"chk\" value=\"");
      out.print(list.get(i).getMYNO());
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(list.get(i).getMYNO());
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(list.get(i).getMYID());
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(list.get(i).getMYPW());
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(list.get(i).getMYNAME());
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(list.get(i).getMYADDR());
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(list.get(i).getMYPHONE());
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(list.get(i).getMYEMAIL());
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(list.get(i).getMYENABLED());
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(list.get(i).getMYROLE());
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");

				}
				}
			
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"9\">\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"선택삭제\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
