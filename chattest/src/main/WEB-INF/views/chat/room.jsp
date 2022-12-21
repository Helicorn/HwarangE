<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<script src="/js/jquery.js"></script>
<meta charset="UTF-8">
<title>chat room</title>
<script>
	function subm,itChatMessageForm(form){
		form.writer.value = form.writer.value.trim();
		
		if(form.writer.value.length == 0){
			alert('작성자 입력');
			form.writer.focus();
			
			return false;
		}
		if(form.body.value.length == 0){
			alert('내용 입력');
			form.writer.focus();
			
			return false;
		}
		
		var writer = form.writer.value;
		var body = form.body.value;
		
		$.post(
				'./addMessage',
				{
					roomId : 1,
					writer : writer,
					body : body
				},
				function(data){
					console.log(data.msg);
				},
				'json'
		);
	}
</script>
</head>
<body>
	<h1>1번 방</h1>
	<form onsubmit="submitChatMessageForm(this); return false;">
	<div>
		<input type="text" name="writer" placeholder="작성자" autocomplete="off">
	</div>
	<div>
		<input type="text" name="body" placeholder="내용" autocomplete="off">
	</div>
	<div>
		<input type="submit" value="작성">
	</div>
	</form>
</body>
</html>