/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-01-13 09:50:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.func.func;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class func_002dedit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link href=\"/js/kindeditor-4.1.10/themes/default/default.css\"\r\n");
      out.write("\ttype=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\"\r\n");
      out.write("\tsrc=\"/js/kindeditor-4.1.10/kindeditor-all-min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\"\r\n");
      out.write("\tsrc=\"/js/kindeditor-4.1.10/lang/zh_CN.js\"></script>\r\n");
      out.write("<div style=\"padding: 10px 10px 10px 10px\">\r\n");
      out.write("\t<form id=\"itemeEditForm\" class=\"itemForm\" method=\"post\" >\r\n");
      out.write("\t\t<table cellpadding=\"5\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>功能ID</td>\r\n");
      out.write("\t\t\t\t<td><input class=\"easyui-numberbox\" type=\"text\" name=\"functionid\"\r\n");
      out.write("\t\t\t\t\tdata-options=\"required:true\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>功能名</td>\r\n");
      out.write("\t\t\t\t<td><input class=\"easyui-textbox\" type=\"text\" name=\"functionname\"\r\n");
      out.write("\t\t\t\t\tdata-options=\"required:true\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>简介描述</td>\r\n");
      out.write("\t\t\t\t<td><input class=\"easyui-textbox\" type=\"text\" name=\"remark\"\r\n");
      out.write("\t\t\t\t\tdata-options=\"required:true\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>状态</td>\r\n");
      out.write("\t\t\t\t<td><input class=\"easyui-textbox\" type=\"text\" name=\"status\" id=\"statusid\"\r\n");
      out.write("\t\t\t\t\tdata-options=\"required:true\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<div style=\"padding: 5px\">\r\n");
      out.write("\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\tonclick=\"submitForm()\">提交</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$('#statusid').combobox({\r\n");
      out.write("\tmethod : 'GET',\r\n");
      out.write("\turl : '/json/status.json',\r\n");
      out.write("\tvalueField : 'text',\r\n");
      out.write("\ttextField : 'description'\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\tvar itemEditEditor;\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t//实例化编辑器\r\n");
      out.write("\t\titemEditEditor = TAOTAO.createEditor(\"#itemeEditForm [name=desc]\");\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tfunction submitForm() {\r\n");
      out.write("\t\tif (!$('#itemeEditForm').form('validate')) {\r\n");
      out.write("\t\t\t$.messager.alert('提示', '表单还未填写完成!');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t$.post(\"/func/update\", $(\"#itemeEditForm\").serialize(), function(\r\n");
      out.write("\t\t\t\tdata) {\r\n");
      out.write("\t\t\tif (data.status == 200) {\r\n");
      out.write("\t\t\t\t$.messager.alert('提示', '修改用户信息成功!', 'info', function() {\r\n");
      out.write("\t\t\t\t\t$(\"#itemEditWindow\").window('close');\r\n");
      out.write("\t\t\t\t\t$(\"#funcList\").datagrid(\"reload\");\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
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
