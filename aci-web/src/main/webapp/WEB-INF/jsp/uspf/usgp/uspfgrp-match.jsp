<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Creating a School Timetable - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
	<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
	<script>
		
	</script>
</head>
<body>
	<h2>Creating a School Timetable</h2>
	<div class="demo-info" style="margin-bottom:10px">
		<div class="demo-tip icon-tip">&nbsp;</div>
		<div>Click and drag a class to timetable.</div>
	</div>

	<div style="width:700px;">
		<div class="left">
			<table id="subjects">
			</table>
			<p><input id="btn1" type="button" class="easyui-linkbutton" value="保存"/><input id="btn2" class="easyui-linkbutton" type="button" value="修改"/></p>
		</div>
		<div class="right">
			<table id="tab">
				<tr>
					<th class="title">User Group</th>
				</tr>
			</table>
		</div>
	</div>
<script>
    $(document).ready(function () {
    	/*Dummy data*/
        var maindata;
  
  		$.ajax({
  	        type: "GET", 
  	        async: false, 
  	        url: "/uspf/display/usertable",
  	        success: function(data) {
  	        	maindata=JSON.parse(data);
  	        }
  	    });
        var tab1 = $("#tab");//H获取表格盒子的内容
        var dataUser;
  		$.ajax({
  	        type: "GET", 
  	        async: false, 
  	        url: "/uspf/display/userlist",
  	        success: function(data) {
  	        	dataUser=data;
  	        }
  	    });
        
        var tab2 = $("#subjects");
        $.each(dataUser, function (index, item) {
            var row = $("<tr></tr>");
            var td = $("<td></td>");
            var div=$("<div class=item></div>").html(item);
            td.append(div);
            row.append(td);
            tab2.append(row);
        });//为表单填充对应JSon值
        var tab1 = $("#tab");//H获取表格盒子的内容 
        $.each(maindata, function (index, item) {
            var row = $("<tr></tr>");
            $.each(item, function (name, value) {
            	var td = $("<td></td>").html(value);
            	if(name=="nub")
            	{
            		row.prepend(td);
            	}
            	else
            	{
            		row.append(td);
            	}
                
                
            });
            tab1.append(row);
        });//为表单填充对应JSon值
        $("#tab").find("tr:not(:first)").each(function () {
            $(this).children().eq("0").addClass("nub");
            $(this).children().eq("1").addClass("1 drop droppable");
            $(this).children().eq("2").addClass("2 drop droppable");
            $(this).children().eq("3").addClass("3 drop droppable");
            $(this).children().eq("4").addClass("4 drop droppable");
            $(this).children().eq("5").addClass("5 drop droppable");
        });//为每个对应的列添加class名
        function load_js(){
			$('.left .item').draggable({
				revert:true,
				proxy:'clone'
			});
			$('.right td.drop').droppable({
				accept: '.item',
				onDragEnter:function(){
					$(this).addClass('over');
				},
				onDragLeave:function(){
					$(this).removeClass('over');
				},
				onDrop:function(e,source){
					$(this).removeClass('over');
					if ($(source).hasClass('assigned')){
						$(this).append(source);
					} else {
						var c = $(source).clone().addClass('assigned');
						$(this).empty().append(c);
						c.draggable({
							revert:true
						});
					}
				}
			});
			$('.left').droppable({
				accept:'.assigned',
				onDragEnter:function(e,source){
					$(source).addClass('trash');
				},
				onDragLeave:function(e,source){
					$(source).removeClass('trash');
				},
				onDrop:function(e,source){
					$(source).remove();
				}
			});
		};
		
        load_js();
        $('#btn2').on('click', function () {//修改-使所有框变成可编辑状态
            for (var i = $("#tab").find("td").length - 1; i >= 0; i--) {//
                console.log($("#tab").find("td")[i])
                var item = $($("#tab").find("td")[i])
                var inputSize = item.find("input").size();
                if (inputSize > 0) return;
                var tdText = item.text();
                var inputObj = $('<input type="text" />');
                item.empty().append(inputObj);
                inputObj.val(tdText); //当单击修改时，变量inputText保存当前值，
            }
        });
        $("#btn1").click(function () {
            var inputObj = $("#tab").find("input[type='text']");
            if (inputObj.size() > 0) {
                inputObj.each(function () {
                    var val = $(this).val();
                    $(this).parent().empty().html(val);
                });
            };//单击保存按钮，使其清空所有input
            var JsonText = "";
            $("#tab").find("tr:not(:first)").each(function () {
                JsonText += "{";
                $(this).find("td").each(function () {
                    JsonText += '"' + $(this).attr("class").split(' ')[0] + '":"' + $(this).text() + '",';
                });
                JsonText = JsonText.substr(0, JsonText.length - 1);
                JsonText += "},";
            });
            JsonText = JsonText.substr(0, JsonText.length - 1);
            JsonText="[" + JsonText + "]";
            console.log(JsonText);
            saveMatch(JsonText);
        });    //取出数据拼接成JSon格式
    });
</script>
<script type="text/javascript">
	function saveMatch(data){ 
		
		$.ajax({
		    type: 'POST',
		    url: '/uspfgrp/match' ,		   
		    dataType: 'json',
		    contentType:'application/json;charset=UTF-8',
		    data:data,  //提交json字符串数组，如果提交json字符串去掉[] 
			success:function(data){
				alert("success");
				$("#uspfgrpMatchWindow").window('close');
			},
			error:function(textStatus, errorThrown){
				console.log(textStatus);
				alert("fail");
			}
		});
	};
</script>
	<style type="text/css">
		.left{
			width:120px;
			float:left;
		}
		.left table{
			background:#E0ECFF;
		}
		.left td{
			background:#eee;
		}
		.right{
			float:right;
			width:570px;
		}
		.right table{
			background:#E0ECFF;
			width:100%;
		}
		.right td{
			background:#fafafa;
			color:#444;
			text-align:center;
			padding:2px;
		}
		.right td{
			background:#E0ECFF;
		}
		.right td.drop{
			background:#fafafa;
			width:100px;
		}
		.right td.over{
			background:#FBEC88;
		}
		.item{
			text-align:center;
			border:1px solid #499B33;
			background:#fafafa;
			color:#444;
			width:100px;
		}
		.assigned{
			border:1px solid #BC2A4D;
		}
		.trash{
			background-color:red;
		}
		
	</style>
	
</body>
</html>