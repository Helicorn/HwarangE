<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:include page="/WEB-INF/views/includes/header.jsp" /> 

<div>
	1번 채팅방
	<form method="post" action="/chat">
		<input type="hidden" name="roomId" value="1">
		<input type="submit" value="채팅방">
	</form>
</div>
<div>
	2번 채팅방
	<form method="post" action="/chat">
		<input type="hidden" name="roomId" value="2">
		<input type="submit" value="채팅방">
	</form>
</div>
<div>
	3번 채팅방
	<form method="post" action="/chat">
		<input type="hidden" name="roomId" value="3">
		<input type="submit" value="채팅방">
	</form>
</div>
<div>
	4번 채팅방
	<form method="post" action="/chat">
		<input type="hidden" name="roomId" value="4">
		<input type="submit" value="채팅방">
	</form>
</div>
</body>
</html>