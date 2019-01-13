<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="uspfList">
</table>
<div id="itemEditWindow" class="easyui-window" title="编辑用户" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/uspf/uspf/uspf-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<div id="itemAddWindow" class="easyui-window" title="新建用户" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/uspf/uspf/uspf-add'" style="width:80%;height:80%;padding:10px;">
</div>
<div id="itemSearchWindow" class="easyui-window" title="搜索" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/uspf/uspf/uspf-search'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

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
    
	$('#uspfList').datagrid({
	    url:'/uspf/list',
	    method:'get',
	    title:'基本用户列表',
	    singleSelect:false,collapsible:true,pagination:true,pageSize:30,
	    toolbar:toolbar,
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
	});

    function getSelectionsIds(){
    	var uspfList = $("#uspfList");
    	var sels = uspfList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].userid);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    

</script>