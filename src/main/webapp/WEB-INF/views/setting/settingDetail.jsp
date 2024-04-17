<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style type="text/css">
		
	</style>
	
	<link rel="stylesheet" href="${path}/resources/css/moduleStyle.css">
	<link rel="stylesheet" href="${path}/resources/css/settingStyle.css">
	<link rel="stylesheet" href="${path}/resources/css/common.css">
	
</head>
<body>

	<%@ include file="../module/side.jsp" %>
	
	<div class="main-content">
		<div class="flex-center logo-wrapper">
			<span class="logo-text">shareTable</span>
		</div>
		<div id="bbsContent">
			<a href="#" onclick="location.href='/member/logout'" id="logout">로그아웃</a>
			<a href="#" onclick="location.href='/setting/bookmark/bookView'">저장됨</a>	
		</div><!-- bbsContent -->	
		
	</div><!-- main-content -->
	
</body>
</html>