/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.89
 * Generated at: 2024-07-10 09:10:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1720506532494L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<ul>\r\n");
      out.write("		<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/info/main\">정보글</a></li>\r\n");
      out.write("		<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/admin/adminPage\">관리자페이지</a></li>\r\n");
      out.write("	</ul>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Document</title>\r\n");
      out.write("<style>\r\n");
      out.write("#footer {\r\n");
      out.write("    position: relative;\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    height: 185px;\r\n");
      out.write("    opacity: 1;\r\n");
      out.write("    background: #282934;\r\n");
      out.write("    bottom: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#logo {\r\n");
      out.write("    position: absolute;\r\n");
      out.write("    left: 10%;\r\n");
      out.write("    top: 23%;\r\n");
      out.write("    width: 274px;\r\n");
      out.write("    height: 39px;\r\n");
      out.write("    opacity: 1;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".wine-explore-title {\r\n");
      out.write("    position: absolute;\r\n");
      out.write("    left: 43%;\r\n");
      out.write("    top: 27%;\r\n");
      out.write("    width: 117px;\r\n");
      out.write("    height: 23px;\r\n");
      out.write("    opacity: 1;\r\n");
      out.write("    font-size: 18px;\r\n");
      out.write("    font-weight: normal;\r\n");
      out.write("    line-height: normal;\r\n");
      out.write("    color: #FFFFFF;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".wine-explore-list {\r\n");
      out.write("    position: absolute;\r\n");
      out.write("    left: 43%;\r\n");
      out.write("    top: 42%;\r\n");
      out.write("    width: 82px;\r\n");
      out.write("    height: 57px;\r\n");
      out.write("    opacity: 1;\r\n");
      out.write("    font-size: 14px;\r\n");
      out.write("    font-weight: normal;\r\n");
      out.write("    line-height: normal;\r\n");
      out.write("    color: #FFFFFF;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".wine-explore-list {\r\n");
      out.write("    list-style: none;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".wine-explore-list li {\r\n");
      out.write("    display: block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".wine-explore-list li a {\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    color: #FFFFFF;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".wine-explore-list li a:hover {\r\n");
      out.write("    color: #FF6347;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".customer-service-title {\r\n");
      out.write("    position: absolute;\r\n");
      out.write("    left: 53%;\r\n");
      out.write("    top: 27%;\r\n");
      out.write("    width: 117px;\r\n");
      out.write("    height: 23px;\r\n");
      out.write("    opacity: 1;\r\n");
      out.write("    font-size: 18px;\r\n");
      out.write("    font-weight: normal;\r\n");
      out.write("    line-height: normal;\r\n");
      out.write("    color: #FFFFFF;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".customer-service-list {\r\n");
      out.write("    position: absolute;\r\n");
      out.write("    left: 53%;\r\n");
      out.write("    top: 42%;\r\n");
      out.write("    width: 82px;\r\n");
      out.write("    height: 57px;\r\n");
      out.write("    opacity: 1;\r\n");
      out.write("    font-size: 14px;\r\n");
      out.write("    font-weight: normal;\r\n");
      out.write("    line-height: normal;\r\n");
      out.write("    color: #FFFFFF;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".customer-service-list {\r\n");
      out.write("    list-style: none;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".customer-service-list {\r\n");
      out.write("    display: block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".customer-service-list li a {\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    color: #FFFFFF;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".customer-service-list li a:hover {\r\n");
      out.write("    color: #FF6347;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#p1 {\r\n");
      out.write("    position: absolute;\r\n");
      out.write("    left: 10%;\r\n");
      out.write("    top: 45%;\r\n");
      out.write("    width: 284px;\r\n");
      out.write("    height: 100px;\r\n");
      out.write("    opacity: 1;\r\n");
      out.write("    font-size: 14px;\r\n");
      out.write("    font-weight: normal;\r\n");
      out.write("    line-height: normal;\r\n");
      out.write("    color: #FFFFFF;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#p2 {\r\n");
      out.write("    position: absolute;\r\n");
      out.write("    top: 79%;\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    height: 24px;\r\n");
      out.write("    opacity: 1;\r\n");
      out.write("    font-size: 16px;\r\n");
      out.write("    font-weight: normal;\r\n");
      out.write("    line-height: normal;\r\n");
      out.write("    color: #FFFFFF;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".contact-us-title {\r\n");
      out.write("    position: absolute;\r\n");
      out.write("    left: 85%;\r\n");
      out.write("    top: 20%;\r\n");
      out.write("    width: 203px;\r\n");
      out.write("    height: 56px;\r\n");
      out.write("    opacity: 1;\r\n");
      out.write("    font-size: 18px;\r\n");
      out.write("    font-weight: normal;\r\n");
      out.write("    line-height: normal;\r\n");
      out.write("    color: #FFFFFF;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".contact-us-details {\r\n");
      out.write("    position: absolute;\r\n");
      out.write("    left: 85%;\r\n");
      out.write("    top: 45%;\r\n");
      out.write("    width: 203px;\r\n");
      out.write("    height: 17px;\r\n");
      out.write("    font-family: Inter;\r\n");
      out.write("    font-size: 14px;\r\n");
      out.write("    font-weight: normal;\r\n");
      out.write("    line-height: normal;\r\n");
      out.write("    color: #FFFFFF;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".policy-links {\r\n");
      out.write("    position: absolute;\r\n");
      out.write("    left: 85%;\r\n");
      out.write("    top: 66%;\r\n");
      out.write("    width: 173px;\r\n");
      out.write("    height: 20px;\r\n");
      out.write("    font-size: 12px;\r\n");
      out.write("    color: #FFFFFF;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".policy-links>a {\r\n");
      out.write("    font-family: Inter;\r\n");
      out.write("    font-size: 12px;\r\n");
      out.write("    font-weight: normal;\r\n");
      out.write("    line-height: normal;\r\n");
      out.write("    color: #FFFFFF;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	<div id=\"footer\">\r\n");
      out.write("		<p id=\"logo\">\r\n");
      out.write("			<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/common/slogo.png\" alt=\"Company Logo\">\r\n");
      out.write("		</p>\r\n");
      out.write("\r\n");
      out.write("		<p id=\"p1\">\r\n");
      out.write("			상호 : 와인 피커 | 대표 : 홍길동<br>등록번호 : 123-12-123456<br>주소 : 서울특별시\r\n");
      out.write("			강남구 테헤란로 123-1\r\n");
      out.write("		</p>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("		<p class=\"wine-explore-title\">와인 둘러보기</p>\r\n");
      out.write("		<ul class=\"wine-explore-list\">\r\n");
      out.write("			<li><a href=\"link_to_red_wine\">Red</a></li>\r\n");
      out.write("			<li><a href=\"link_to_white_wine\">White</a></li>\r\n");
      out.write("			<li><a href=\"link_to_Sparkling_wine\">Sparkling</a></li>\r\n");
      out.write("		</ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("		<p class=\"customer-service-title\">고객센터</p>\r\n");
      out.write("		<ul class=\"customer-service-list\">\r\n");
      out.write("			<li><a href=\"link_to_FAQ\">FAQ</a></li>\r\n");
      out.write("			<li><a href=\"link_to_notice\">공지사항</a></li>\r\n");
      out.write("			<li><a href=\"link_to_QNA\">1:1 문의</a></li>\r\n");
      out.write("		</ul>\r\n");
      out.write("\r\n");
      out.write("		<p class=\"contact-us-title\">Contact us</p>\r\n");
      out.write("		<p class=\"contact-us-details\">\r\n");
      out.write("			Email : <a href=\"mailto:admin@winepicker.com\">admin@winepicker.com</a>\r\n");
      out.write("		</p>\r\n");
      out.write("\r\n");
      out.write("		<p class=\"policy-links\">\r\n");
      out.write("			<a href=\"link_to_terms\">이용약관</a> | <a href=\"link_to_privacy\">개인정보취급방침</a>\r\n");
      out.write("		</p>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("		<P id=\"p2\">Copyright ⓒ WinePicker. All right reserved.</P>\r\n");
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
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
