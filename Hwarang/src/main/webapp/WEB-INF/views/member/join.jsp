<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/join.css" />
<hr>
<script src="/js/jquery.js"></script>
<script>
function join_check(){
	if($.trim($('#join_username').val()) == ''){
		alert('아이디는 필수입력 사항입니다.');
		$('#join_username').val('').focus();
		return false;
	}
	if($.trim($('#join_password').val()) == ''){
		alert('비밀번호는 필수입력 사항입니다.');
		$('#join_password').val('').focus();
		return false;
	}
	if($.trim($('#join_password_ok').val()) == ''){
		alert('비밀번호 확인은 필수입력 사항입니다.');
		$('#join_password_ok').val('').focus();
		return false;
	}
	if($.trim($('#join_password').val()) != $.trim($('#join_password_ok').val())){
		alert('비밀번호가 서로 다릅니다.');
		$('#join_password').val('').focus();
		return false;
	}
	if($.trim($('#join_realname').val()) == ''){
		alert('이름은 필수입력 사항입니다.');
		$('#join_realname').val('').focus();
		return false;
	}
	if($.trim($('#join_nickname').val()) == ''){
		alert('닉네임은 필수입력 사항입니다.');
		$('#join_nickname').val('').focus();
		return false;
	}
	if($.trim($('#join_phone1').val()) == ''){
		alert('전화번호는 필수입력 사항입니다.');
		$('#join_phone1').val('').focus();
		return false;
	}
	if($.trim($('#join_phone2').val()) == ''){
		alert('전화번호는 필수입력 사항입니다.');
		$('#join_phone2').val('').focus();
		return false;
	}
	if($.trim($('#join_phone3').val()) == ''){
		alert('전화번호는 필수입력 사항입니다.');
		$('#join_phone3').val('').focus();
		return false;
	}
}
</script>
<article id = "join_article">
<div class="joinbox">
	<form method="post" action="joinok" onsubmit="return join_check();">
		<div class="join_inputbox">
			<input type="text" name="username" id="join_username" class="join_insertvalue" placeholder="아이디">
		</div>
		<div class="join_inputbox">
			<input type="password" name="password" id="join_password" class="join_insertvalue" placeholder="비밀번호">
		</div>
		<div class="join_inputbox">
			<input type="password" name="password_ok" id="join_password_ok" class="join_insertvalue" placeholder="비밀번호 확인">
		</div>
		<div class="join_inputbox">
			<input type="text" name="realname" id="join_realname" class="join_insertvalue" placeholder="이름">
		</div>
		<div class="join_inputbox">
			<input type="text" name="nickname" id="join_nickname" class="join_insertvalue" placeholder="닉네임">
		</div>
		<div class="join_inputbox">
			<input type="text" name="phone1" id="join_phone1" class="join_insertvalue" placeholder="010">-
			<input type="text" name="phone2" id="join_phone2" class="join_insertvalue" pattern="^\d{4}$" placeholder="0000">-
			<input type="text" name="phone3" id="join_phone3" class="join_insertvalue" pattern="^\d{4}$" placeholder="0000">
		</div>
		<div class="join_inputbox">
			<input type="text" name="email1" id="join_email1" class="join_insertvalue" placeholder="email">@
			<input type="text" name="email2" id="join_email2" class="join_insertvalue">
			<select name="email_select" id="join_email3" class="join_insertvalue" onchange="email_select()">
				<option value="self">직접입력</option>
				<option value="google.com">google.com</option>
				<option value="naver.com">naver.com</option>
				<option value="daum.net">daum.net</option>				
			</select>
		</div>
		<div class="join_inputbox">
			<input type="radio" name="gender" id="join_male" class="join_insertradio" value="male"><label id="join_male">남자</label>
			<input type="radio" name="gender" id="join_female" class="join_insertradio" value="female"><label id="join_female">여자</label>
			
		</div>
		<div class="join_inputbox">
			<input type="text" name="addressdo" id="join_addressdo" class="join_insertvalue">
			<input type="text" name="addresssi" id="join_addresssi" class="join_insertvalue">
		</div>
		<div class="join_inputbox">
			<input type="submit" value="회원가입">
		</div>
		
	</form>
</div>
</article>

<script>
	
	$('#join_email3').change(function(){
		$('#join_email3 option:selected').each(function(){
			if($('#join_email3').val() == 'self'){
				$('#join_email2').attr('disabled',false);
				$('#join_email2').val() == '';				
			}else{
				$('#join_email2').attr('disabled',true);
				document.getElementById('join_email2').value=document.getElementById('join_email3').value;
			}
		})		
	})
	
</script>
</body>
</html>