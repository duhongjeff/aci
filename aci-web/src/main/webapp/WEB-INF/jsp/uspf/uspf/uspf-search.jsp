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
		<table cellpadding="5" id="uspfList">
			<tr>
				<td>用户ID</td>
				<td><input class="easyui-textbox" type="text" name="userid" id="useridid"
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

		$('#uspfList').datagrid({
		    url:'/uspf/search',
		    method:'get',
			queryParams: {
				userid: $('#useridid').val(),
			},
		    columns:[[
		        {field:'ck',checkbox:true,title:'勾选',width:100},
		        {field:'userid',title:'用户ID',width:100},
		        {field:'realname',title:'姓名',width:100},
		        {field:'usgpDesc',title:'所在用户组',width:100},
		        {field:'reporterid',title:'汇报者',width:100},
		        {field:'gender',title:'性别',width:100},
		        {field:'email',title:'邮箱',width:100},
		        {field:'telno',title:'联系方式',width:100},
		        {field:'addr',title:'联系地址',width:100},
		        {field:'dob',formatter:TAOTAO.formatDateTimeToLong,title:'生日',width:100},
		        {field:'expirydate',formatter:TAOTAO.formatDateTimeToLong,title:'expirydate',width:100},
		        {field:'designation',title:'职位',width:100},
		        {field:'status',title:'状态',width:100},
		        {field:'remark',title:'评论',width:100},
		        {field:'credate',formatter:TAOTAO.formatDateTimeToLong,title:'创建日期',width:100},
		        {field:'lupdate',formatter:TAOTAO.formatDateTimeToLong,title:'更新日期',width:100}
		    ]]
		});
		
		$("#itemSearchWindow").window('close');
	}
</script>
