/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-01-13 09:55:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.func.fugp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fugp_002dadd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<form id=\"itemAddForm\" class=\"itemForm\" method=\"post\">\r\n");
      out.write("\t\t<table cellpadding=\"5\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>功能组ID</td>\r\n");
      out.write("\t\t\t\t<td><input class=\"easyui-numberbox\" type=\"text\" name=\"fuctiongpid\"\r\n");
      out.write("\t\t\t\t\tdata-options=\"required:true\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>功能组名</td>\r\n");
      out.write("\t\t\t\t<td><input class=\"easyui-textbox\" type=\"text\"\r\n");
      out.write("\t\t\t\t\tname=\"functiongpname\" data-options=\"required:true\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>状态</td>\r\n");
      out.write("\t\t\t\t<td><input class=\"easyui-textbox\" type=\"text\" name=\"status\" id=\"statusid\"\r\n");
      out.write("\t\t\t\t\tdata-options=\"required:true\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>只读</td>\r\n");
      out.write("\t\t\t\t<td><input class=\"easyui-textbox\" type=\"text\" name=\"readonly\"\r\n");
      out.write("\t\t\t\t\tdata-options=\"required:true\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>简介描述</td>\r\n");
      out.write("\t\t\t\t<td><input class=\"easyui-textbox\" type=\"text\" name=\"remark\"\r\n");
      out.write("\t\t\t\t\tdata-options=\"required:true\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"itemParams\" />\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<div style=\"padding: 5px\">\r\n");
      out.write("\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\tonclick=\"submitForm()\">提交</a> <a href=\"javascript:void(0)\"\r\n");
      out.write("\t\t\tclass=\"easyui-linkbutton\" onclick=\"clearForm()\">重置</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$('#statusid').combobox({\r\n");
      out.write("\tmethod : 'GET',\r\n");
      out.write("\turl : '/json/status.json',\r\n");
      out.write("\tvalueField : 'text',\r\n");
      out.write("\ttextField : 'description'\r\n");
      out.write("});\r\n");
      out.write("\tvar itemAddEditor;\r\n");
      out.write("\t//页面初始化完毕后执行此方法\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t//创建富文本编辑器\r\n");
      out.write("\t\t//itemAddEditor = TAOTAO.createEditor(\"#itemAddForm [name=desc]\");\r\n");
      out.write("\t\t//初始化类目选择和图片上传器\r\n");
      out.write("\t\tTAOTAO.init({\r\n");
      out.write("\t\t\tfun : function(node) {\r\n");
      out.write("\t\t\t\t//根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。\r\n");
      out.write("\t\t\t\t//TAOTAO.changeItemParam(node, \"itemAddForm\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t//提交表单\r\n");
      out.write("\tfunction submitForm() {\r\n");
      out.write("\t\t//有效性验证\r\n");
      out.write("\t\t/*\r\n");
      out.write("\t\t取商品价格，单位为“分”\r\n");
      out.write("\t\t$(\"#itemAddForm [name=price]\").val(eval($(\"#itemAddForm [name=priceView]\").val()) * 100);\r\n");
      out.write("\t\t//同步文本框中的商品描述\r\n");
      out.write("\t\titemAddEditor.sync();\r\n");
      out.write("\t\t//取商品的规格\r\n");
      out.write("\t\t/*\r\n");
      out.write("\t\tvar paramJson = [];\r\n");
      out.write("\t\t$(\"#itemAddForm .params li\").each(function(i,e){\r\n");
      out.write("\t\t\tvar trs = $(e).find(\"tr\");\r\n");
      out.write("\t\t\tvar group = trs.eq(0).text();\r\n");
      out.write("\t\t\tvar ps = [];\r\n");
      out.write("\t\t\tfor(var i = 1;i<trs.length;i++){\r\n");
      out.write("\t\t\t\tvar tr = trs.eq(i);\r\n");
      out.write("\t\t\t\tps.push({\r\n");
      out.write("\t\t\t\t\t\"k\" : $.trim(tr.find(\"td\").eq(0).find(\"span\").text()),\r\n");
      out.write("\t\t\t\t\t\"v\" : $.trim(tr.find(\"input\").val())\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tparamJson.push({\r\n");
      out.write("\t\t\t\t\"group\" : group,\r\n");
      out.write("\t\t\t\t\"params\": ps\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t//把json对象转换成字符串\r\n");
      out.write("\t\tparamJson = JSON.stringify(paramJson);\r\n");
      out.write("\t\t$(\"#itemAddForm [name=itemParams]\").val(paramJson);\r\n");
      out.write("\t\t */\r\n");
      out.write("\t\t//ajax的post方式提交表单\r\n");
      out.write("\t\t//$(\"#itemAddForm\").serialize()将表单序列号为key-value形式的字符串\r\n");
      out.write("\t\t$.post(\"/fugp/create\", $(\"#itemAddForm\").serialize(), function(data) {\r\n");
      out.write("\t\t\tif (data.status == 200) {\r\n");
      out.write("\t\t\t\t$.messager.alert('提示', '修改用户信息成功!', 'info', function() {\r\n");
      out.write("\t\t\t\t\t$(\"#itemAddWindow\").window('close');\r\n");
      out.write("\t\t\t\t\t$(\"#fugpList\").datagrid(\"reload\");\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t};\r\n");
      out.write("\r\n");
      out.write("\tfunction clearForm() {\r\n");
      out.write("\t\t$('#itemAddForm').form('reset');\r\n");
      out.write("\t\titemAddEditor.html('');\r\n");
      out.write("\t};\r\n");
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
