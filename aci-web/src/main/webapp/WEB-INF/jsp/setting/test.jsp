<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<body>
	<p>
		<input id="btn2" class="easyui-linkbutton" type="button"
			value="uspf-solr" />
		<input id="btn1" class="easyui-linkbutton"
			type="button" value="func-solr" />
	</p>
	<br />
	
	<form id="indicatorAddExcelForm" method="post" enctype="multipart/form-data">
			<table class="grid">
			  <tr>
                <td>请选择Excel文件</td>            
                <td><input type="file" class="easyui-validatebox" id="upfile" name="upfile"></td> 
                         
              </tr>          
              <tr>
              <td><button type="submit" form="indicatorAddExcelForm" value="Submit">Submit</button></td> 
                </tr> 
        	</table>  
		</form>
	<script type="text/javascript">
	$(function() 
	{
		$('#indicatorAddExcelForm').form(
		{
			url : '/setting/addExcel',
			onSubmit : function() 
			{			  
				var isValid = $(this).form('validate');
				if (!isValid) 
				{
					alert("not valid");
				}
				return isValid;
			},
			success : function(result) 
			{			    
				result = $.parseJSON(result);			
				if (result.status == 200) 
				{		
				    parent.$.messager.alert('成功', "上传成功", 'info');	  
				} else 
				{
					parent.$.messager.alert('错误','错误代码： '+result.status+'  '+result.msg , 'error');
				}
				 $("#upfile").val("");
				 parent.$.modalDialog.handler.dialog('close');
				 
			}
		});
	});
</script>
	
	
	<script>
		$(document).ready(function() {
			/*Dummy data*/
			$('#btn2').on('click', function() {
				$.ajax({
					type : "POST",
					async : false,
					url : "/setting/uspfsolr",
					success : function(data) {
						alert("成功同步");
					}
				});
			});
		});

		$('#btn1').on('click', function() {
			$.ajax({
				type : "POST",
				async : false,
				url : "/setting/funcsolr",
				success : function(data) {
					alert("成功同步");
				}
			});
		});
	</script>
</body>