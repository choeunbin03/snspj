<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<link rel="stylesheet" href="${path}/resources/css/common.css">
	<link rel="stylesheet" href="${path}/resources/css/srchStyle.css">
		
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="${path}/resources/js/search.js" type="text/javascript" defer="defer"></script>
	
</head>
<body>
	<%@ include file="../module/side.jsp" %>
	
	<div class="main-content">
		<div class="flex-center logo-wrapper">
			<span class="logo-text">shareTable</span>
		</div>
		
		<div id="srchContent">
			<form id="srchFrm" name="srchFrm">
				<br>		
				<br>
				<h3><strong>검색</strong></h3>		
				<input type="text" size="20" id="keyWd" name="keyWd" value="${keyWd}"/>&nbsp;
				<button type="button" onclick="fn_srch()">검색</button>	
			</form>	
			<br><br>
			
			<div id="searchList">
			<p>최근 검색 항목</p>
			
			</div>		
		</div><!-- //srchContent -->
		
	</div>
	
	

</body>
</html>