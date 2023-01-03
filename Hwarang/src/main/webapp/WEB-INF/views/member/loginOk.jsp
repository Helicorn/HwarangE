<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/js/jquery.js"></script>
<hr>
<article id="login_article">
<script>
	function login_check(){
		if($.trim($('#username').val()) == '')){
			alert('아이디는 필수 입력사항입니다.');
			$('#username').val('').focus();
			return false;
		}
		if($.trim($('#password').val()) == '')){
			alert('비밀번호는 필수 입력사항입니다.');
			$('#password').val('').focus();
			return false;
		}
	}
	

</script>
<div class="loginbox">
	<c:if test="${empty username }">
	<form method="post" action="/loginok" onsubmit="return login_check();" enctype="application/json">
		<input type="text" name="username" id="username" class="login_insertvalue" placeholder="ID">
		<input type="password" name="password" id="password" class="login_insertvalue" placeholder="PW">
		<input type="submit" name="login_submit" id="login_submit" value="로그인">
	</form>
	</c:if>
	
	<c:if test="${!empty username }">
	<form method="post" action="/logout">
		<input type="submit" name="logout" value="로그아웃">
	</form>
	</c:if>
</div>
</article>

</body>
</html>