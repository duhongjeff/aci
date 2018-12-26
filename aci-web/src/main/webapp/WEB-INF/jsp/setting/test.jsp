<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<body>
	<p>
		<input id="btn2" class="easyui-linkbutton" type="button"
			value="uspf-solr" />
		<input id="btn1" class="easyui-linkbutton"
			type="button" value="func-solr" />
	</p>
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