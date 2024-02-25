<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${path}/resources/js/member.js" defer="defer"></script>


<title>로그인</title>
</head>
<body>	
	
	<div class="loginPage">
	<form id="loginFrm">
		<div id="loginBox">
			<div>ID<br> <input type="text" placeholder="아이디를 입력해주세요." id="mbrId" name="mbrId"></div>
			<div>Password<br> <input type="password" maxlength="13" placeholder="비밀번호를 입력해주세요." id="mbrPwd" name="mbrPwd"></div>
			<button id="btnLogin" type="button" onclick="fn_login();">로그인</button>
		</div>
		<div id="joinBox">
			<p>회원이 아니라면 회원가입 후 로그인을 시도해주세요.</p>
			<button id="btnMvJoin" type="button" onclick='location.href="/member/join"'>회원가입</button>
		</div>
	</form>
	</div>	

</body>
</html>