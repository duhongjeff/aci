<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="css/taotao.css" />
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/common.js"></script>


    <div id="test" data-options="region:'west',title:'菜单',split:true" style="width:180px;">
		    	<ul id="menui" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
         	<li>
         		<span>仪表盘管理</span>
         		<ul>
	         		<li data-options="attributes:{'url':'../content-category'}">仪表盘内容分类管理</li>
	         		<li data-options="attributes:{'url':'../content'}">仪表盘内容管理</li>
	         	</ul>
         	</li>

         </ul>
    </div>

    <script type="text/javascript">
$(function(){
	$('#menui').tree({
		onClick: function(node){
			if($('#menui').tree("isLeaf",node.target)){
				var tabs = $("#tabs");
				var tab = tabs.tabs("getTab",node.text);
				if(tab){
					tabs.tabs("select",node.text);
				}else{
					tabs.tabs('add',{
					    title:node.text,
					    href: node.attributes.url,
					    closable:true,
					    bodyCls:"content"
					});
				}
			}
		}
	});
});
</script>