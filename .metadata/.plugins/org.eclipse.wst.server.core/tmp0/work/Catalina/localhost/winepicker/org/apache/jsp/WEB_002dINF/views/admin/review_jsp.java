/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.89
 * Generated at: 2024-07-10 10:56:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class review_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1719385840165L));
    _jspx_dependants.put("jar:file:/C:/SemiProjectWorkspace/winepicker/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin;

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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>리뷰 관리</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/admin.css\">\r\n");
      out.write("<style>\r\n");
      out.write("    body {\r\n");
      out.write("        font-family: Arial, sans-serif;\r\n");
      out.write("    }\r\n");
      out.write("    .content {\r\n");
      out.write("        margin: 20px;\r\n");
      out.write("    }\r\n");
      out.write("    .innerOuter {\r\n");
      out.write("        margin: auto;\r\n");
      out.write("        width: 80%;\r\n");
      out.write("    }\r\n");
      out.write("    h2 {\r\n");
      out.write("        color: #333;\r\n");
      out.write("    }\r\n");
      out.write("    .form-group {\r\n");
      out.write("        margin-bottom: 20px;\r\n");
      out.write("        display: flex;\r\n");
      out.write("        justify-content: space-between;\r\n");
      out.write("        align-items: flex-start;\r\n");
      out.write("    }\r\n");
      out.write("    .search-bar {\r\n");
      out.write("        position: relative;\r\n");
      out.write("        width: 300px;\r\n");
      out.write("    }\r\n");
      out.write("    .input-field {\r\n");
      out.write("        padding: 8px 12px;\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        border: 1px solid #ccc;\r\n");
      out.write("        border-radius: 20px;\r\n");
      out.write("    }\r\n");
      out.write("    .search-bar button {\r\n");
      out.write("        position: absolute;\r\n");
      out.write("        right: 5px;\r\n");
      out.write("        top: 50%;\r\n");
      out.write("        transform: translateY(-50%);\r\n");
      out.write("        border: none;\r\n");
      out.write("        background: none;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("    }\r\n");
      out.write("    .search-bar button img {\r\n");
      out.write("        width: 20px;\r\n");
      out.write("        height: 20px;\r\n");
      out.write("    }\r\n");
      out.write("    .btn-group {\r\n");
      out.write("        margin-top: 10px;\r\n");
      out.write("        text-align: right;\r\n");
      out.write("    }\r\n");
      out.write("    .btn-group button {\r\n");
      out.write("        padding: 8px 16px;\r\n");
      out.write("        margin-left: 10px;\r\n");
      out.write("    }\r\n");
      out.write("    table {\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        border-collapse: collapse;\r\n");
      out.write("    }\r\n");
      out.write("    th, td {\r\n");
      out.write("        border: 1px solid #ddd;\r\n");
      out.write("        padding: 8px;\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        white-space: nowrap;\r\n");
      out.write("    }\r\n");
      out.write("    th {\r\n");
      out.write("        background-color: #f2f2f2;\r\n");
      out.write("    }\r\n");
      out.write("    tr:nth-child(even) {\r\n");
      out.write("        background-color: #f9f9f9;\r\n");
      out.write("    }\r\n");
      out.write("    tr:hover {\r\n");
      out.write("        background-color: #f1f1f1;\r\n");
      out.write("    }\r\n");
      out.write("    .user-list {\r\n");
      out.write("        margin-top: 20px;\r\n");
      out.write("    }\r\n");
      out.write("    .checkbox-column {\r\n");
      out.write("        width: 40px;\r\n");
      out.write("    }\r\n");
      out.write("    .number-column {\r\n");
      out.write("        width: 60px;\r\n");
      out.write("    }\r\n");
      out.write("    .action-link {\r\n");
      out.write("        color: #007bff;\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("    }\r\n");
      out.write("    .action-link:hover {\r\n");
      out.write("        text-decoration: underline;\r\n");
      out.write("    }\r\n");
      out.write("    .modal {\r\n");
      out.write("        display: none;\r\n");
      out.write("        position: fixed;\r\n");
      out.write("        z-index: 1;\r\n");
      out.write("        left: 0;\r\n");
      out.write("        top: 0;\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        height: 100%;\r\n");
      out.write("        overflow: auto;\r\n");
      out.write("        background-color: rgb(0,0,0);\r\n");
      out.write("        background-color: rgba(0,0,0,0.4);\r\n");
      out.write("        padding-top: 60px;\r\n");
      out.write("    }\r\n");
      out.write("    .modal-content {\r\n");
      out.write("        background-color: #fefefe;\r\n");
      out.write("        margin: 5% auto;\r\n");
      out.write("        padding: 20px;\r\n");
      out.write("        border: 1px solid #888;\r\n");
      out.write("        width: 80%;\r\n");
      out.write("    }\r\n");
      out.write("    .close {\r\n");
      out.write("        color: #aaa;\r\n");
      out.write("        float: right;\r\n");
      out.write("        font-size: 28px;\r\n");
      out.write("        font-weight: bold;\r\n");
      out.write("    }\r\n");
      out.write("    .close:hover,\r\n");
      out.write("    .close:focus {\r\n");
      out.write("        color: black;\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/header.jsp", out, false);
      out.write("\r\n");
      out.write("<div class=\"content\">\r\n");
      out.write("    <div class=\"innerOuter\">\r\n");
      out.write("        <h2>리뷰 관리</h2>\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <div class=\"search-bar\">\r\n");
      out.write("                <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/admin/review\" method=\"get\">\r\n");
      out.write("                    <input type=\"text\" name=\"keyword\" placeholder=\"검색어를 입력하세요\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.keyword}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" class=\"input-field\">\r\n");
      out.write("                    <button type=\"submit\">\r\n");
      out.write("                        <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/search-icon.png\" alt=\"Search\">\r\n");
      out.write("                    </button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"btn-group\">\r\n");
      out.write("                <button type=\"button\" onclick=\"replyReview()\" id=\"replyBtn\">선택 답변</button>\r\n");
      out.write("                <button type=\"button\" onclick=\"deleteReview()\" id=\"deleteBtn\" class=\"btn-danger\">선택 삭제</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"user-list\">\r\n");
      out.write("            <table class=\"table\">\r\n");
      out.write("                <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th class=\"checkbox-column\"><input type=\"checkbox\" onclick=\"toggle(this);\"></th>\r\n");
      out.write("                        <th class=\"number-column\">번호</th>\r\n");
      out.write("                        <th>작성시간</th>\r\n");
      out.write("                        <th>주문번호</th>\r\n");
      out.write("                        <th>내용</th>\r\n");
      out.write("                        <th>점수</th>\r\n");
      out.write("                        <th>상태</th>\r\n");
      out.write("                        <th>수정시간</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                    ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"replyModal\" class=\"modal\">\r\n");
      out.write("  <div class=\"modal-content\">\r\n");
      out.write("    <span class=\"close\" onclick=\"closeModal()\">&times;</span>\r\n");
      out.write("    <h2>답변 작성</h2>\r\n");
      out.write("    <form id=\"replyForm\" method=\"post\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/admin/replyReviews\">\r\n");
      out.write("        <input type=\"hidden\" name=\"selectedReviews\">\r\n");
      out.write("        <textarea name=\"replyContent\" rows=\"10\" style=\"width: 100%;\" placeholder=\"답변 내용을 입력하세요\"></textarea>\r\n");
      out.write("        <button type=\"submit\">저장</button>\r\n");
      out.write("    </form>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("function toggle(source) {\r\n");
      out.write("    checkboxes = document.getElementsByName('selectedReviews');\r\n");
      out.write("    let anyChecked = false;\r\n");
      out.write("    for (var i = 0, n = checkboxes.length; i < n; i++) {\r\n");
      out.write("        checkboxes[i].checked = source.checked;\r\n");
      out.write("        if (checkboxes[i].checked) {\r\n");
      out.write("            anyChecked = true;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    document.getElementById('replyBtn').disabled = !anyChecked;\r\n");
      out.write("    document.getElementById('deleteBtn').disabled = !anyChecked;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function deleteReview() {\r\n");
      out.write("    var selected = [];\r\n");
      out.write("    checkboxes = document.getElementsByName('selectedReviews');\r\n");
      out.write("    for (var i = 0, n = checkboxes.length; i < n; i++) {\r\n");
      out.write("        if (checkboxes[i].checked) {\r\n");
      out.write("            selected.push(checkboxes[i].value);\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    if (selected.length > 0 && confirm('정말 삭제하시겠습니까?')) {\r\n");
      out.write("        var form = document.createElement('form');\r\n");
      out.write("        form.method = 'post';\r\n");
      out.write("        form.action = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/admin/deleteSelectedReviews';\r\n");
      out.write("        selected.forEach(function(value) {\r\n");
      out.write("            var input = document.createElement('input');\r\n");
      out.write("            input.type = 'hidden';\r\n");
      out.write("            input.name = 'selectedReviews';\r\n");
      out.write("            input.value = value;\r\n");
      out.write("            form.appendChild(input);\r\n");
      out.write("        });\r\n");
      out.write("        document.body.appendChild(form);\r\n");
      out.write("        form.submit();\r\n");
      out.write("        alert('선택된 리뷰가 삭제되었습니다.');\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function replyReview() {\r\n");
      out.write("    var selected = [];\r\n");
      out.write("    checkboxes = document.getElementsByName('selectedReviews');\r\n");
      out.write("    for (var i = 0, n = checkboxes.length; i < n; i++) {\r\n");
      out.write("        if (checkboxes[i].checked) {\r\n");
      out.write("            selected.push(checkboxes[i].value);\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    if (selected.length > 0) {\r\n");
      out.write("        document.querySelector('#replyForm input[name=\"selectedReviews\"]').value = selected.join(',');\r\n");
      out.write("        document.getElementById('replyModal').style.display = 'block';\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function closeModal() {\r\n");
      out.write("    document.getElementById('replyModal').style.display = 'none';\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/views/admin/review.jsp(164,20) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/admin/review.jsp(164,20) '${reviewList}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${reviewList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/views/admin/review.jsp(164,20) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("review");
      // /WEB-INF/views/admin/review.jsp(164,20) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVarStatus("status");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                        <tr>\r\n");
            out.write("                            <td class=\"checkbox-column\"><input type=\"checkbox\" name=\"selectedReviews\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${review.reviewNo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"></td>\r\n");
            out.write("                            <td class=\"number-column\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${review.reviewNo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                            <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${review.createDate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                            <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${review.orderNo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                            <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${review.content}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                            <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${review.point}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                            <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${review.status}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                            <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${review.modifyDate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                        </tr>\r\n");
            out.write("                    ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/views/admin/review.jsp(176,20) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty reviewList}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                        ");
          if (_jspx_meth_c_005fforEach_005f1(_jspx_th_c_005fif_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f1_reused = false;
    try {
      _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
      // /WEB-INF/views/admin/review.jsp(177,24) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setVar("i");
      // /WEB-INF/views/admin/review.jsp(177,24) name = begin type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setBegin(1);
      // /WEB-INF/views/admin/review.jsp(177,24) name = end type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setEnd(20);
      int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
        if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                            <tr>\r\n");
            out.write("                                <td class=\"checkbox-column\"><input type=\"checkbox\" disabled></td>\r\n");
            out.write("                                <td class=\"number-column\"></td>\r\n");
            out.write("                                <td></td>\r\n");
            out.write("                                <td></td>\r\n");
            out.write("                                <td></td>\r\n");
            out.write("                                <td></td>\r\n");
            out.write("                                <td></td>\r\n");
            out.write("                                <td></td>\r\n");
            out.write("                            </tr>\r\n");
            out.write("                        ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f1.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin.reuse(_jspx_th_c_005fforEach_005f1);
      _jspx_th_c_005fforEach_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f1_reused);
    }
    return false;
  }
}
