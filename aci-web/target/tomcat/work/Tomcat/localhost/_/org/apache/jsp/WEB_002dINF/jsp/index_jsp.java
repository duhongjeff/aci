/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-12-29 12:29:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"js/jquery-easyui-1.4.1/themes/default/easyui.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"js/jquery-easyui-1.4.1/themes/icon.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/taotao.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-easyui-1.4.1/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-easyui-1.4.1/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/common.js\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\t.content {\r\n");
      out.write("\t\tpadding: 10px 10px 10px 10px;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"easyui-layout\">\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(document).ready(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t$(\".easyui-linkbutton\").click(function(e) {\r\n");
      out.write("\t\t\t\tif (e.currentTarget.id === \"leftmenuuspf\") {\r\n");
      out.write("\t\t\t\t\t$(\"#test\").load('nav/leftmenuuspf');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif (e.currentTarget.id === \"leftmenufunctions\") {\r\n");
      out.write("\t\t\t\t\t$(\"#test\").load('nav/leftmenufunctions');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif (e.currentTarget.id === \"leftmenupanel\") {\r\n");
      out.write("\t\t\t\t\t$(\"#test\").load('nav/leftmenupanel');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif (e.currentTarget.id === \"leftmenusetting\") {\r\n");
      out.write("\t\t\t\t\t$(\"#test\").load('nav/leftmenusetting');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"test\" data-options=\"region:'west',title:'菜单',split:true\"\r\n");
      out.write("\t\tstyle=\"width: 180px;\"></div>\r\n");
      out.write(" \r\n");
      out.write("\t<div data-options=\"region:'center',title:''\">\r\n");
      out.write("\t\t<a id=\"leftmenuuspf\" class=\"easyui-linkbutton\">用户资料</a>\r\n");
      out.write("\t\t<a id=\"leftmenufunctions\" class=\"easyui-linkbutton\">功能组</a>\r\n");
      out.write("\t\t<a id=\"leftmenupanel\" class=\"easyui-linkbutton\">主页面仪表盘</a>\r\n");
      out.write("\t\t<a id=\"leftmenusetting\" class=\"easyui-linkbutton\">主页面setting</a>\r\n");
      out.write("\t\t<div id=\"tabs\" class=\"easyui-tabs\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div title=\"首页\" style=\"padding: 20px;\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
