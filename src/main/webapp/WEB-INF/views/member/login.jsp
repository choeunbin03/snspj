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

<!-- <link rel="stylesheet" href="${path}/resources/css/common.css">	-->
<link rel="stylesheet" href="${path}/resources/css/loginStyle.css">
</head>
<body class="flex-center">	
	
	<div class="login-container">
		<div class="mainImg">
			<img src="/resources/images/logoImg.png">
		</div>
		<div class="flex-center login-content">
			<form id="loginFrm">
			<div class="flex-center logo-wrapper">
				<span class="logo-text">shareTable</span>
			</div>
			<div class="input-wrapper">
				<div class="login-wrapper flex-center">
					<input class="login-input" type="text" placeholder="아이디를 입력해주세요." id="mbrId" name="mbrId">
				</div>
				<div class="login-wrapper flex-center">
					<input class="login-input" type="password" maxlength="13" placeholder="비밀번호를 입력해주세요." id="mbrPwd" name="mbrPwd">
				</div>
				<div class="flex-center button-wrapper">
					<button class="login-button" id="btnLogin" type="button" onclick="fn_login();">로그인</button>
				</div>			
			</div><!-- "input-wrapper" -->
			<div class="flex-center joinBox">
				<div class="flex-center info-wrapper">회원이 아니신가요?</div>
				<div class="flex-center button-wrapper">
					<button class="join-button" id="btnMvJoin" type="button" onclick='location.href="/member/join"'>회원가입</button>
				</div>
			</div>
		</form>
		</div>
		
	</div><!-- login-container -->	

</body>
</html>