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
				<td>用户ID</td>
				<td><input class="easyui-textbox" type="text" name="userid"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input class="easyui-textbox" type="text" name="realname"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<td>汇报者</td>
				<td><input class="easyui-textbox" type="text" name="reporterid"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input class="easyui-textbox" type="text" name="gender"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input class="easyui-textbox" type="text" name="email"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<td>联系方式</td>
				<td><input class="easyui-textbox" type="text" name="telno"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<td>生日</td>
				<td><input class="easyui-datebox" type="text" name="dob"
					data-options="formatter:TAOTAO.formatDateTimeToLong" /></td>
			</tr>
			<tr>
				<td>有效期</td>
				<td><input class="easyui-datebox" type="text" name="expirydate"
					data-options="formatter:TAOTAO.formatDateTimeToLong" /></td>
			</tr>
			<tr>
				<td>职位</td>
				<td><input class="easyui-textbox" type="text" name="telno"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<td>状态</td>
				<td><input class="easyui-textbox" type="text" name="telno"
					data-options="required:true" /></td>
			</tr>
		</table>
		
	</form>
	<div style="padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="submitForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
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

		$.post("/uspf/update", $("#itemeEditForm").serialize(), function(
				data) {
			if (data.status == 200) {
				$.messager.alert('提示', '修改用户信息成功!', 'info', function() {
					$("#itemEditWindow").window('close');
					$("#uspfList").datagrid("reload");
				});
			}
		});
	}
</script>
