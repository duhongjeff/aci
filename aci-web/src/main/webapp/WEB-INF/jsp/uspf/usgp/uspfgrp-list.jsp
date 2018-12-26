<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="usgpList" title="基本用户列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/uspfgrp/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true">勾选</th>
        	<th data-options="field:'usgpid',width:60">用户组ID</th>
            <th data-options="field:'usgpname',width:100">用户组名</th>
            <th data-options="field:'leaderid',width:100">汇报者</th>
            <th data-options="field:'remark',width:100">评论</th>
            <th data-options="field:'status',width:100">状态</th>
            <th data-options="field:'credate',width:100">创建日期</th>
            <th data-options="field:'lupdate',width:200">更新日期</th>
            <th data-options="field:'creby',width:100">创建者</th>  
            <th data-options="field:'lupby',width:100">更新者</th>
        </tr>
    </thead>
</table>
<div id="uspfgrpEditWindow" class="easyui-window" title="编辑用户" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/uspf/usgp/uspfgrp-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<div id="uspfgrpAddWindow" class="easyui-window" title="新建用户" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/uspf/usgp/uspfgrp-add'" style="width:80%;height:80%;padding:10px;">
</div>
<div id="uspfgrpSearchWindow" class="easyui-window" title="搜索" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/uspf/usgp/uspfgrp-search'" style="width:80%;height:80%;padding:10px;">
</div>
<div id="uspfgrpMatchWindow" class="easyui-window" title="匹配" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/uspf/usgp/uspfgrp-match'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

function getSelectionsIds(){
	var uspfList = $("#usgpList");
	var sels = uspfList.datagrid("getSelections");
	var ids = [];
	for(var i in sels){
		ids.push(sels[i].usgpid);
	}
	ids = ids.join(",");
	return ids;
}
    
    var toolbar = [{
        text:'搜索',
        iconCls:'icon-search',
        handler:function(){
        	$("#uspfgrpSearchWindow").window({}).window("open");
        }
    },{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	$("#uspfgrpAddWindow").window({}).window("open");
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
        	
        	$("#uspfgrpEditWindow").window({
				width:'400',
			    height:"400",
        		onLoad :function(){
        			//回显数据
        			var data = $("#usgpList").datagrid("getSelections")[0];
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
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的用户组吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/uspfgrp/delete/"+ids, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除商品成功!',undefined,function(){
            					$("#usgpList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    },{
        text:'匹配',
        iconCls:'icon-search',
        handler:function(){
        	$("#uspfgrpMatchWindow").window({}).window("open");
        }
    }];
</script>