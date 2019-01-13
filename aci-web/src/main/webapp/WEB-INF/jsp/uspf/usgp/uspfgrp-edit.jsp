<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8"
	src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding: 10px 10px 10px 10px">
	<form id="itemeEditForm" class="itemForm" method="post" >
		<table cellpadding="5">
			<tr>
				<td>用户组ID</td>
				<td><input class="easyui-textbox" type="text" name="usgpid"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<td>用户组名</td>
				<td><input class="easyui-textbox" type="text" name="usgpname"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<td>汇报者</td>
				<td><input id="leaderid" class="easyui-textbox" type="text" name="leaderid"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<td>评论</td>
				<td><input class="easyui-textbox" type="text" name="remark"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<td>状态</td>
				<td><input id="statusid" class="easyui-textbox" type="text" name="status"
				 /></td>
			</tr>
		</table>
		
	</form>
	<div style="padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="submitForm()">提交</a><a href="javascript:void(0)"
			onclick="resetForm()" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
$('#statusid').combobox({
	method : 'GET',
	url : '/json/status.json',
	valueField : 'text',
	textField : 'text'
});

$('#leaderid').combobox({
	method : 'GET',
	url : '/dropdownlist/usgp/listleader',
	valueField : 'userid',
	textField : 'userid'
});

	var itemEditEditor;
	$(function() {
		//实例化编辑器
		itemEditEditor = TAOTAO.createEditor("#itemeEditForm [name=desc]");
	});

	function submitForm() {
		if (!$('#itemeEditForm').form('validate')) {
			$.messager.alert('提示', '表单还未填写完成!');
			return;
		}

		$.post("/uspfgrp/update", $("#itemeEditForm").serialize(), function(
				data) {
			if (data.status == 200) {
				$.messager.alert('提示', '修改用户信息成功!', 'info', function() {
					$("#uspfgrpEditWindow").window('close');
					$("#usgpList").datagrid("reload");
				});
			}
		});
	}
	
	function resetForm() {
		$('#itemAddForm').form('reset');
		itemAddEditor.html('');
	}
</script>
