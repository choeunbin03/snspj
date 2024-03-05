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
	<script src="${path}/resources/js/bookmark.js" type="text/javascript" defer="defer"></script>
	
	
</head>
<body>
	<%@ include file="../module/side.jsp" %>
	<div id="bbsContent">
		<br>		
		<br>		
		<table>
			<tbody>
				<c:forEach items="${bbsList}" var="bbsList">
					<tr>
						<td><c:out value="${bbsList.rgtrId}" /></td>
						<td><fmt:formatDate pattern="yyyy/MM/dd" value="${bbsList.rgtrDt}" /></td>
						<!-- 첨부파일 자리 -->
						<td><button type="button" onclick="fn_updateBbsSpt(${bbsList.bbsId})">좋아요</button></td>
						<td><button type="button" onclick="fn_bmkBbs(${bbsList.bbsId})">북마크</button></td>
						<td><a href="#" onclick="fn_goPlcView(${bbsList.bbsPlc})">${bbsList.bbsPlc}</a></td>
						<td><a href="/board/bbsView?bbsId=${bbsList.bbsId}">${bbsList.bbsCn}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			
		<div class="loading" id="loading">
			
		</div>
		
	
	</div><!-- //bbs_content -->

</body>
</html>