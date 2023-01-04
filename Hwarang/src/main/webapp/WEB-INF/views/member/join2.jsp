<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/join.css" />
<hr>
<script src="/js/jquery.js"></script>
<script>
</script>
<article id = "join_article">
<div class="joinbox">
	<form method="post" action="joinok" enctype="application/json">
		<div class="join_inputbox">
			<input type="text" name="username" id="join_username" class="join_insertvalue" placeholder="아이디">
		</div>
		<div class="join_inputbox">
			<input type="password" name="password" id="join_password" class="join_insertvalue" placeholder="비밀번호">
		</div>
		<div class="join_inputbox">
			<input type="submit" value="회원가입">
		</div>
		
	</form>
</div>
</article>

</body>
</html>