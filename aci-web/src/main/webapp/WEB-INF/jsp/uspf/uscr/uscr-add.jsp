<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="itemAddForm" class="itemForm" method="post">
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
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">

	var itemAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		itemAddEditor = TAOTAO.createEditor("#itemAddForm [name=desc]");
		//初始化类目选择和图片上传器
	});
	//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#itemAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.post("/uscr/create",$("#itemAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示', '添加密码成功!', 'info', function() {
					$("#itemAddWindow").window('close');
					$("#uscrList").datagrid("reload");
				});
			}
			else{
				$.messager.alert('提示', '添加密码失败!', 'info', function() {
					alert(data.msg);
					$("#itemAddWindow").window('close');
					$("#uscrList").datagrid("reload");
				});
			}
		});
	}
	
	function clearForm(){
		$('#itemAddForm').form('reset');
		itemAddEditor.html('');
	}
</script>
