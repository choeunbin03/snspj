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
	
</head>
<body>

	<%@ include file="../module/side.jsp" %>
	<div id="bbsContent">
		<a href="#" onclick="location.href='/member/logout'" id="logout">로그아웃</a>
		<a href="#" onclick="location.href='/setting/bookmark/bookView'">저장됨</a>

	</div><!-- bbsContent -->

</body>
</html>