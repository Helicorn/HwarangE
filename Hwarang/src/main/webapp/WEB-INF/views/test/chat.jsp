<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="/css/chat.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.2/jquery.js"></script>
<script>
var Chat_roomId = ${param.roomId};
</script>
<meta charset="UTF-8">
<title>chat room</title>
<script>
	function Chat_addMessage(writer,body){ //폼이 발송되기 전에 한번씩 실행. 즉, 엔터한번 칠때마다 실행
		$.post(
				'test/doAddMessage',
				{
					roomId : Chat_roomId,
					writer : writer,
					body : body
				},
				function(data){
					var chatMessage = {
							writer : writer,
							body : body
					};
					//Chat_drawMessage(chatMessage);
				},
				'json'
		);
	}
	
	function Chat_drawMessage(chatMessage){
		var html = chatMessage.writer + ' : ' + chatMessage.body;
		
		$('.chat-messages').prepend('<div>'+html+'<div>');
	}
	
	var Chat_lastLoadedMessageId = 0;
	
	function Chat_loadNewMessages(){
		$.get(
				'test/getMessagesFrom',
				{
					roomId : Chat_roomId,
					from : Chat_lastLoadedMessageId + 1
				},
				function(data){
					for(var i=0 ; i<data.messages.length ; i++){
						Chat_drawMessage(data.messages[i]);
						
						Chat_lastLoadedMessageId = data.messages[i].id;
					}
				},
				'json'
			)
		
	}
	
	setInterval(Chat_loadNewMessages,1000);

	function submitChatMessageForm(form){
		form.writer.value = form.writer.value.trim();
		
		if(form.writer.value.length == 0){
			alert('작성자 입력');
			form.writer.focus();
			
			return false;
		}
		if(form.body.value.length == 0){
			alert('내용 입력');
			form.body.focus();
			
			return false;
		}
		
		var writer = form.writer.value;
		var body = form.body.value;
		
		form.body.value = '';
		form.body.focus();
		
		Chat_addMessage(writer,body);
	}
</script>
</head>
<body>
	<h1>${param.roomId}번채팅</h1>
	<form onsubmit="submitChatMessageForm(this); return false;">
	<div>
		<input type="text" name="writer" placeholder="작성자" autocomplete="off" size="10">
	
		<input type="text" name="body" placeholder="내용" autocomplete="off" size="30">
	
		<input type="submit" value="작성">
	</div>
	<br>
	<div class="chat-messages">
		
	</div>
	</form>
</body>
</html>