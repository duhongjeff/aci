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
				<td>姓名</td>
				<td><input class="easyui-textbox" type="text" name="realname"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<td>汇报者</td>
				<td><input id="leaderid" class="easyui-textbox" type="text" name="reporterid"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input id="genderid" class="easyui-textbox" type="text" name="gender"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input class="easyui-textbox" type="text" name="email"
					data-options="required:true,validType:'email'" /></td>
			</tr>
			<tr>
				<td>联系方式</td>
				<td><input class="easyui-textbox" type="text" name="telno"
					data-options="required:true" /></td>
			</tr>
		  <tr>
				<td>联系地址</td>
				<td><input class="easyui-textbox" type="text" name="addr"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<td>生日</td>
				<td><input class="easyui-datebox" type="text" name="dob"
					 /></td>
			</tr>
			<tr>
				<td>有效期</td>
				<td><input class="easyui-datebox" type="text" name="expirydate"
					 /></td>
			</tr>
			<tr>
				<td>职位</td>
				<td><input id="designationid" class="easyui-textbox" type="text" name="designation"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<td>状态</td>
				<td><input id="statusid" class="easyui-textbox" type="text" name="status"
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
	
	$('#statusid').combobox({
		method : 'GET',
		url : '/json/status.json',
		valueField : 'text',
		textField : 'description'
	});
	
	$('#designationid').combobox({
		method : 'GET',
		url : '/json/designation.json',
		valueField : 'text',
		textField : 'description'
	});
	
	$('#leaderid').combobox({
		method : 'GET',
		url : '/dropdownlist/usgp/listleader',
		valueField : 'userid',
		textField : 'userid'
	});
	
	$('#genderid').combobox({
		method : 'GET',
		url : '/json/gender.json',
		valueField : 'id',
		textField : 'description'
	});

	var itemAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		itemAddEditor = TAOTAO.createEditor("#itemAddForm [name=desc]");
		//初始化类目选择和图片上传器
		TAOTAO.init({fun:function(node){
			//根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。
			//TAOTAO.changeItemParam(node, "itemAddForm");
		}});
	});
	//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#itemAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		/*
		取商品价格，单位为“分”
		$("#itemAddForm [name=price]").val(eval($("#itemAddForm [name=priceView]").val()) * 100);
		//同步文本框中的商品描述
		itemAddEditor.sync();
		//取商品的规格
		/*
		var paramJson = [];
		$("#itemAddForm .params li").each(function(i,e){
			var trs = $(e).find("tr");
			var group = trs.eq(0).text();
			var ps = [];
			for(var i = 1;i<trs.length;i++){
				var tr = trs.eq(i);
				ps.push({
					"k" : $.trim(tr.find("td").eq(0).find("span").text()),
					"v" : $.trim(tr.find("input").val())
				});
			}
			paramJson.push({
				"group" : group,
				"params": ps
			});
		});
		//把json对象转换成字符串
		paramJson = JSON.stringify(paramJson);
		$("#itemAddForm [name=itemParams]").val(paramJson);
		*/
		//ajax的post方式提交表单
		//$("#itemAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("/uspf/create",$("#itemAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示', '修改用户信息成功!', 'info', function() {
					$("#itemAddWindow").window('close');
					$("#uspfList").datagrid("reload");
				});
			}
		});
	}
	
	function clearForm(){
		$('#itemAddForm').form('reset');
		itemAddEditor.html('');
	}
</script>
