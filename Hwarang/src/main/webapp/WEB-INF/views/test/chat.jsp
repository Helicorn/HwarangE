<jsp:include page="/WEB-INF/views/includes/header.jsp" /> 
<script>
	var Chat_roomId = ${param.roomId};

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
		//var html = chatMessage.writer + ' : ' + chatMessage.body;
		var htmlone = chatMessage.writer;
		var htmltwo = chatMessage.body;
				
		$('.chat-messages').append('<div class="circle"><div>');
		$('.chat-messages').append('<div class="message-cloud-one">'+htmlone+'<div>');
		$('.chat-messages').append('<div class="message-cloud-two">'+htmltwo+'<div>');
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
		
		$('.chat-messages').scrollTop($('.chat-messages')[0].scrollHeight);
	}
</script>
	<h1>${param.roomId}번채팅</h1>
	<form onsubmit="submitChatMessageForm(this); return false;">	
	<br>
	<div class="chat-messages">
		
	</div>
	<div>
		<input type="text" name="writer" value="${nickname }" autocomplete="off" size="10" disabled>
	
		<input type="text" name="body" placeholder="내용" autocomplete="off" size="30">
	
		<input type="submit" value="작성">
	</div>
	</form>
</body>
</html>