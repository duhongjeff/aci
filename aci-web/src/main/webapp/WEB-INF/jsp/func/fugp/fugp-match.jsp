<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="fugpMatchList">
</table>
<div style="padding: 10px 10px 10px 10px">
	<form id="itemMatchForm" class="itemForm" method="post">
		<table cellpadding="5">
			<tr>
				<td>功能组名</td>
				<td><input  class="easyui-textbox" type="text" name="fuctiongpid" id="fuctiongpid" name="functiongpname" data-options="required:true" /></td>
			</tr>
			<tr>
				<td>未被匹配的功能名</td>
				<td><input class="easyui-textbox" type="text" name="functionid" id="functionid" data-options="required:true" /></td>
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
<div id="itemEditWindow" class="easyui-window" title="编辑用户" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/func/fugp/fugp-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<div id="itemAddWindow" class="easyui-window" title="新建用户" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/func/fugp/fugp-add'" style="width:80%;height:80%;padding:10px;">
</div>
<div id="itemSearchWindow" class="easyui-window" title="搜索" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/func/fugp/fugp-search'" style="width:80%;height:80%;padding:10px;">
</div>
<script>
$('#fuctiongpid').combobox({
	method : 'GET',
	url : '/func/list/title',
	valueField : 'fuctiongpid',
	textField : 'functiongpname'
});

$('#functionid').combobox({
	method : 'GET',
	url : '/func/list/unmatchedfunc',
	valueField : 'functionid',
	textField : 'functionname'
});

//提交表单
function submitForm() {
	if(!$('#itemMatchForm').form('validate')){
		$.messager.alert('提示','表单还未填写完成!');
		return ;
	}
	
	$.post("/func/update", $("#itemMatchForm").serialize(), function(data) {
		if (data.status == 200) {
			$.messager.alert('提示', '匹配信息成功!', 'info', function() {
				$("#itemSearchWindow").window('close');
				$("#fugpMatchList").datagrid("reload");
			});
		}
	});
};

function clearForm() {
	$('#itemMatchForm').form('reset');
	itemAddEditor.html('');
};

$(document).ready(function(){
    var toolbar = [{
        text:'搜索',
        iconCls:'icon-search',
        handler:function(){
        	$("#itemSearchWindow").window({}).window("open");
        }
    },{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	$("#itemAddWindow").window({}).window("open");
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','${jspproperties.MISS_SELECTION}');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','${jspproperties.ALLOW_ONLY_ONE}');
        		return ;
        	}
        	
        	$("#itemEditWindow").window({
				width:'400',
			    height:"400",
        		onLoad :function(){
        			//回显数据
        			var data = $("#uspfList").datagrid("getSelections")[0];
        			data.expirydate=TAOTAO.formatDateTime(data.expirydate);
        			data.dob=TAOTAO.formatDateTime(data.dob);
        			$("#itemeEditForm").form("load",data);
        		}
        	}).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的用户吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/uspf/delete/"+ids, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除成功!',undefined,function(){
            					$("#uspfList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
    
	 $.ajax({
		    url:'/func/list/titleanddata',
	        type:"get",
	        dataType:"json",
	        async:false, 
	        success:function(data){
	            $("#fugpMatchList").datagrid({
	                columns:[data.title]    //动态取标题
	            });
	            $("#fugpMatchList").datagrid("loadData",data.rows);  //动态取数据
	        }
	    });
	
	});
    
    
    function deal_dept(value,row,rowIndex) {
        if(row.fugp!=undefined){
            return row.fugp.fugptiongpname;
        }
    };
</script>