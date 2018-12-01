<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="uspfList" title="基本用户列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/uspfhist/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true">勾选</th>
        	<th data-options="field:'userid',width:60">用户ID</th>
            <th data-options="field:'realname',width:100">姓名</th>
            <th data-options="field:'reporterid',width:100">汇报者</th>
            <th data-options="field:'gender',width:100">性别</th>
            <th data-options="field:'email',width:100">邮箱</th>
            <th data-options="field:'telno',width:100">联系方式</th>
            <th data-options="field:'addr',width:200">联系方式</th>
            <th data-options="field:'dob',width:100">生日</th>  
            <th data-options="field:'expirydate',width:100">有效期</th>
            <th data-options="field:'designation',width:100">职位</th>
            <th data-options="field:'status',width:100">状态</th>
			<th data-options="field:'remark',width:100">评论</th>
            <th data-options="field:'credate',width:130,align:'center'">创建日期</th>
            <th data-options="field:'lupdate',width:130,align:'center'">更新日期</th>
        </tr>
    </thead>
</table>
<div id="itemEditWindow" class="easyui-window" title="编辑用户" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/uspflist-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<div id="itemAddWindow" class="easyui-window" title="新建用户" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/uspflist-add'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

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
    
    var toolbar = [{
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
        			//data.priceView = TAOTAO.formatPrice(data.price);
        			data.expirydate=TAOTAO.formatDateTime(data.expirydate);
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
            				$.messager.alert('提示','删除商品成功!',undefined,function(){
            					$("#uspfList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    },'-',{
        text:'下架',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定下架ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/rest/item/instock",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','下架商品成功!',undefined,function(){
            					$("#uspfList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    },{
        text:'上架',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定上架ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/rest/item/reshelf",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','上架商品成功!',undefined,function(){
            					$("#uspfList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>