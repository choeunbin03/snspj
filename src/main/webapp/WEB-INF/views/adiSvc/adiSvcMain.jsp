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
		#bmkTopContainer {overflow: hidden;}
		#bmkTopList {float: left; border: 1px solid #E2E2E2; padding: 0px; width: 250px; height: 150px; line-height: 13px; margin: 20px; min-width: 200px;}
	</style>
	
	<link rel="stylesheet" href="${path}/resources/css/moduleStyle.css">
	<link rel="stylesheet" href="${path}/resources/css/common.css">
	<link rel="stylesheet" href="${path}/resources/css/adiSvcStyle.css">
		
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="${path}/resources/js/board.js" type="text/javascript" defer="defer"></script>
	
</head>
<body>
	<div id="totalContent">
		<%@ include file="../module/side.jsp" %>
		<div class="main-content">
			<h2>저장 TOP</h2>		
			<br>	
			<div id="bmkTopContainer">
				<c:forEach items="${bmkTopList}" var="bmkTopList" varStatus="status">
					<div id="bmkTopList">
						<h3>${status.index+1}</h3><br>
						<h4>${bmkTopList.place_name}</h4><br>
						<p>${bmkTopList.road_address_name}</p><br>
						<p>${bmkTopList.address_name}</p><br>
						<p>${bmkTopList.phone}</p>
					</div>			
				</c:forEach>
			</div>	
			<button type="button" onclick="location.href='/adiSvc/bmkTop'">더보기</button>		
		</div>
			
	</div><!-- //totalContent -->

</body>
</html>