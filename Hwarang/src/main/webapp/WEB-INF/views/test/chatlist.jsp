<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:include page="/WEB-INF/views/includes/header.jsp" /> 

<script>
	function check(){
		
	}
</script>

<div>
	1번 채팅방
	<form method="post" action="/chat">
		<input type="hidden" name="roomId" value="1">
		<input type="text" name="nickname" placeholder="해당닉네임으로 들어가기">
		<input type="submit" value="채팅방">
	</form>
</div>
<div>
	2번 채팅방
	<form method="post" action="/chat">
		<input type="hidden" name="roomId" value="2">
		<input type="text" name="nickname" placeholder="해당닉네임으로 들어가기">
		<input type="submit" value="채팅방">
	</form>
</div>
<div>
	3번 채팅방
	<form method="post" action="/chat">
		<input type="hidden" name="roomId" value="3">
		<input type="text" name="nickname" placeholder="해당닉네임으로 들어가기">
		<input type="submit" value="채팅방">
	</form>
</div>
<div>
	4번 채팅방
	<form method="post" action="/chat">
		<input type="hidden" name="roomId" value="4">
		<input type="text" name="nickname" placeholder="해당닉네임으로 들어가기">
		<input type="submit" value="채팅방">
	</form>
</div>
</body>
</html>