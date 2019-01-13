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
				<td>密码</td>
				<td><input class="easyui-textbox" type="text" name="password"
					data-options="required:true" /></td>
			</tr>	
		</table>
	    <input type="hidden" name="itemParams"/>
	</form>
	<div style="padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="submitForm()">提交</a>
			 <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
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

		$.post("/uscr/update", $("#itemeEditForm").serialize(), function(
				data) {
			if (data.status == 200) {
				$.messager.alert('提示', '修改用户信息成功!', 'info', function() {
					$("#itemEditWindow").window('close');
					$("#uscrList").datagrid("reload");
				});
			}
		});
	};
	
	function clearForm(){
		$('#itemeEditForm').form('reset');
		itemAddEditor.html('');
	}
</script>
