<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8"
	src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding: 10px 10px 10px 10px">
	<form id="itemAddForm" class="itemForm" method="post">
		<table cellpadding="5">
			<tr>
				<td>功能组ID</td>
				<td><input class="easyui-numberbox" type="text" name="fuctiongpid"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<td>功能组名</td>
				<td><input class="easyui-textbox" type="text"
					name="functiongpname" data-options="required:true" /></td>
			</tr>
			<tr>
				<td>状态</td>
				<td><input class="easyui-textbox" type="text" name="status" id="statusid"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<td>简介描述</td>
				<td><input class="easyui-textbox" type="text" name="remark"
					data-options="required:true" /></td>
			</tr>

		</table>
		<input type="hidden" name="itemParams" />
	</form>
	<div style="padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="submitForm()">提交</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
$('#statusid').combobox({
	method : 'GET',
	url : '/json/status.json',
	valueField : 'text',
	textField : 'description'
});
	var itemAddEditor;
	//页面初始化完毕后执行此方法
	$(function() {
		//创建富文本编辑器
		//itemAddEditor = TAOTAO.createEditor("#itemAddForm [name=desc]");
		//初始化类目选择和图片上传器
		TAOTAO.init({
			fun : function(node) {
				//根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。
				//TAOTAO.changeItemParam(node, "itemAddForm");
			}
		});
	});
	//提交表单
	function submitForm() {
		$.post("/fugp/create", $("#itemAddForm").serialize(), function(data) {
			if (data.status == 200) {
				$.messager.alert('提示', '修改用户信息成功!', 'info', function() {
					$("#itemAddWindow").window('close');
					$("#fugpList").datagrid("reload");
				});
			}
		});
	};

	function clearForm() {
		$('#itemAddForm').form('reset');
		itemAddEditor.html('');
	};
</script>
