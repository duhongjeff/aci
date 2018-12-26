<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8"
	src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding: 10px 10px 10px 10px">
	<form id="itemSearchForm" class="itemForm" method="post" >
		<table cellpadding="5" id="funcList">
			<tr>
				<td>功能名</td>
				<td><input class="easyui-textbox" type="text" name="functionname"
					data-options="required:true" /></td>
			</tr>
		</table>
		
	</form>
	<div style="padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="submitForm()">搜索</a>
	</div>
</div>
<script type="text/javascript">
	var itemEditEditor;
	$(function() {
		//实例化编辑器
		itemEditEditor = TAOTAO.createEditor("#itemeEditForm [name=desc]");
	});

	function submitForm() {
		if (!$('#itemSearchForm').form('validate')) {
			$.messager.alert('提示', '表单还未填写完成!');
			return;
		}

		$.post("/func/search", $("#itemSearchForm").serialize(), function(
				data) {
			if (data!=null) {
				$.messager.alert('notice', 'search success!', 'info', function() {
					//window.parent.$("#funcList").val(data)
					$("#itemSearchWindow").window('close');
					$("#funcList").datagrid("reload");
				});
			}
		});
	}
</script>
