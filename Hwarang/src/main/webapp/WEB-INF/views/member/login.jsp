<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/includes/header.jsp" /> 
<hr>
<article id="login_article">
<script>
	function login_check(){
		if($.trim($('#login_id').val() == '')){
			alert('아이디는 필수 입력사항입니다.');
			$('#login_id').val('').focus();
			return false;
		}
		if($.trim($('#login_password').val() == '')){
			alert('비밀번호는 필수 입력사항입니다.');
			$('#login_password').val('').focus();
			return false;
		}
	}
</script>
<div class="loginbox">
	<c:if test="${empty username }">
	<form method="post" action="/login_ok" onsubmit="return login_check();" enctype="application/x-www-form-urlencoded">
		<input type="text" name="username" id="login_id" class="login_insertvalue" placeholder="ID">
		<input type="password" name="password" id="login_password" class="login_insertvalue" placeholder="PW">
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