<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="funcList" title="基本用户列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/func/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true">勾选</th>
        	<th data-options="field:'functionid',width:60">功能ID</th>
            <th data-options="field:'functionname',width:100">功能名</th>
            <th data-options="field:'fugp',width:100" formatter="deal_dept">功能组</th>
            <th data-options="field:'remark',width:100">功能描述</th>
            <th data-options="field:'status',width:100">状态</th>
            <th data-options="field:'credate',width:130,align:'center',formatter:TAOTAO.formatDateTimeToLong">创建日期</th>
            <th data-options="field:'lupdate',width:130,align:'center',formatter:TAOTAO.formatDateTimeToLong">更新日期</th>
        </tr>
    </thead>
</table>
<div id="itemEditWindow" class="easyui-window" title="编辑用户" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/func/func/func-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<div id="itemAddWindow" class="easyui-window" title="新建用户" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/func/func/func-add'" style="width:80%;height:80%;padding:10px;">
</div>
<div id="itemSearchWindow" class="easyui-window" title="搜索" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/func/func/func-search'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

    function getSelectionsIds(){
    	var funcList = $("#funcList");
    	var sels = funcList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].functionid);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
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
        			var data = $("#funcList").datagrid("getSelections")[0];
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
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的行吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/func/delete/"+ids, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除成功!',undefined,function(){
            					$("#funcList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
    
    function deal_dept(value,row,rowIndex) {
        if(row.fugp!=undefined){
            return row.fugp.functiongpname;
        }
    };
</script>