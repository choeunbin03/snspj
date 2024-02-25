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

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${path}/resources/js/board.js" type="text/javascript" defer="defer"></script>
<%-- <script src="${path}/resources/js/cmnt.js" type="text/javascript" defer="defer"></script> --%>

	
</head>
<body>


	<%@ include file="../module/side.jsp" %>
	<div id="bbsContent">

	<form id="bbsViewfrm">
		<input type="hidden" value="${bbsView.bbsId}" name="bbsId" id="bbsId">
		
		<button type="button" onclick='fn_addBookmark()'>북마크</button>	
		<div>작성자 : ${bbsView.rgtrId}</div>
		<div>등록일 : ${bbsView.rgtrDt}</div>
		<!-- <div>첨부파일</div>	-->
		<div>장소 : ${bbsView.bbsPlc}</div>
		<div>내용 : ${bbsView.bbsCn}</div>
		<!-- 댓글~~ -->
	</form>
		<button type="button" value="좋아요" onclick='fn_updateBbsSpt(${bbsView.bbsId})'></button>
		<button type="button" onclick='fn_goBackPg()'>X</button><!-- 일단 기능 구현하고 위치 수정. -->
		
	<%-- 	<%@ include file="../comment/cmntList.jsp" %>
		<%@ include file="../comment/regiCmnt.jsp" %> --%>

	
	</div><!-- bbsContent -->
	
</body>
</html>