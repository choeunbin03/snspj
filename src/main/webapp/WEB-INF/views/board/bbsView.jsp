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
<link rel="stylesheet" href="${path}/resources/css/bbsStyle.css">

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${path}/resources/js/board.js" type="text/javascript" defer="defer"></script>
<%-- <script src="${path}/resources/js/cmnt.js" type="text/javascript" defer="defer"></script> --%>

	
</head>
<body>


	<%@ include file="../module/side.jsp" %>
	
	<div class="main-content">
		<div class="flex-center logo-wrapper">
			<span class="logo-text">shareTable</span>
		</div>
	
		<div id="bbsContent">
	
		<form id="bbsViewfrm">
			<input type="hidden" value="${bbsView.bbsId}" name="bbsId" id="bbsId">
			
			<button type="button" onclick='fn_bmkBbs()'>북마크</button>	
			<div>작성자 : ${bbsView.rgtrId}</div>
			<div>등록일 : ${bbsView.rgtrDt}</div>
			<!-- <div>첨부파일</div>	-->
			<div>장소 : ${bbsView.bbsPlc}</div>
			<div>내용 : ${bbsView.bbsCn}</div>
			<!-- 댓글~~ -->
		</form>
			<!-- 좋아요 -->
				<div class="feed-heart-wrapper">
					<c:choose>								
						<c:when test='${sptYn[status.index] eq "Y"}'> <!-- 하트 눌린 상태 -->
							<button type="button" class="feed-heart-btn btn" onclick="fn_updateBbsSpt(${bbsView.bbsId}, '${sptYn}',0)">
								<i class="xi-heart xi-2x"></i>
							</button>
						</c:when>
						<c:otherwise>  <!-- 하트 안 눌린 상태 -->
							<button type="button" class="feed-heart-btn btn" onclick="fn_updateBbsSpt(${bbsView.bbsId}, '${sptYn}', 0)">
								<i class=" xi-heart-o xi-2x"></i>
							</button>
						</c:otherwise>
					</c:choose>
					<c:out value="${bbsView.bbsSptCnt}" />
				</div>
				
				
				<!-- 북마크 -->
				<div class="feed-bmk-wrapper">
					<c:choose>								
						<c:when test='${bmkYn eq "Y"}'> <!-- 북마크 눌린 상태 -->
							<button type="button" class="feed-bmk-btn btn " onclick="fn_bmkBbs(${bbsView.bbsId}, '${sptYn}',0)">
								<i class="xi-bookmark xi-2x"></i>
							</button>
						</c:when>
						<c:otherwise>  <!-- 북마크 안 눌린 상태 -->
							<button type="button" class="feed-bmk-btn btn " onclick="fn_bmkBbs(${bbsView.bbsId}, '${sptYn}',0)">
								<i class=" xi-bookmark-o xi-2x"></i>
							</button>
						</c:otherwise>
					</c:choose>
				</div>
			
			<button type="button" onclick='fn_goBackPg()'>X</button><!-- 일단 기능 구현하고 위치 수정. -->
			
		<%-- 	<%@ include file="../comment/cmntList.jsp" %>
			<%@ include file="../comment/regiCmnt.jsp" %> --%>
	
		
		</div><!-- bbsContent -->
	</div><!-- main-content -->
	
	
	
</body>
</html>