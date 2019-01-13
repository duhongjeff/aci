<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="uspfHistList" title="基本用户列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/uspfhist/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true">勾选</th>
        	<th data-options="field:'userid',width:60">用户ID</th>
        	 <th data-options="field:'usergroupdesc',width:100">所在用户组</th>
            <th data-options="field:'realname',width:100">姓名</th>
            <th data-options="field:'terminationdate',width:100">关闭日期</th>
            <th data-options="field:'status',width:100">状态</th>
			<th data-options="field:'remark',width:100">评论</th>
            <th data-options="field:'credate',formatter:TAOTAO.formatDateTimeToLong,width:130,align:'center'">创建日期</th>
            <th data-options="field:'lupdate',formatter:TAOTAO.formatDateTimeToLong,width:130,align:'center'">更新日期</th>
        </tr>
    </thead>
</table>
<div id="itemSearchWindow" class="easyui-window" title="搜索用户" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/uspfhist-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<div id="itemHistEditWindow" class="easyui-window" title="恢复用户" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/uspf/uspfhist/uspfhist-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

    function getSelectionsIds(){
    	var uspfHistList = $("#uspfHistList");
    	var sels = uspfHistList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].userid);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    var toolbar = [{
        text:'搜索',
        iconCls:'icon-search',
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
        	
        	$("#itemSearchWindow").window({
				width:'400',
			    height:"400",
        		onLoad :function(){
        			//回显数据
        			var data = $("#uspfHistList").datagrid("getSelections")[0];
        			//data.priceView = TAOTAO.formatPrice(data.price);
        			data.expirydate=TAOTAO.formatDateTime(data.expirydate);
        			$("#itemHistEditForm").form("load",data);
        		}
        	}).window("open");
        }
    },
    {
        text:'恢复',
        iconCls:'icon-redo',
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
        	
        	$("#itemHistEditWindow").window({
				width:'400',
			    height:"400",
        		onLoad :function(){
        			//回显数据
        			var data = $("#uspfHistList").datagrid("getSelections")[0];
        			//data.priceView = TAOTAO.formatPrice(data.price);
        			//data.expirydate=TAOTAO.formatDateTime(data.expirydate);
        			$("#itemHistEditForm").form("load",data);
        		}
        	}).window("open");
        }
    }];
</script>