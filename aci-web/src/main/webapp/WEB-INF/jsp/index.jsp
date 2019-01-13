<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="css/taotao.css" />
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<style type="text/css">
	.content {
		padding: 10px 10px 10px 10px;
	}
</style>
</head>
<body class="easyui-layout">
	<script type="text/javascript">
		$(document).ready(function() {

			$(".easyui-linkbutton").click(function(e) {
				if (e.currentTarget.id === "leftmenuuspf") {
					$("#test").load('nav/leftmenuuspf');
				}
				if (e.currentTarget.id === "leftmenufunctions") {
					$("#test").load('nav/leftmenufunctions');
				}
				if (e.currentTarget.id === "leftmenupanel") {
					$("#test").load('nav/leftmenupanel');
				}
				if (e.currentTarget.id === "leftmenusetting") {
					$("#test").load('nav/leftmenusetting');
				}
				if (e.currentTarget.id === "logout") {
					$("#test").load('user/logout');
				}

			});
		});
	</script>


	<div id="test" data-options="region:'west',title:'菜单',split:true"
		style="width: 180px;"></div>
 
	<div data-options="region:'center',title:''">
		<a id="leftmenuuspf" class="easyui-linkbutton">用户资料</a>
		<a id="leftmenufunctions" class="easyui-linkbutton">功能组</a>
		<a id="leftmenupanel" class="easyui-linkbutton">主页面仪表盘</a>
		<a id="leftmenusetting" class="easyui-linkbutton">主页面setting</a>
		<a id="logout" class="easyui-linkbutton">退出登录</a>
		<div id="tabs" class="easyui-tabs">

			<div title="首页" style="padding: 20px;"></div>
		</div>
	</div>

</body>
</html>