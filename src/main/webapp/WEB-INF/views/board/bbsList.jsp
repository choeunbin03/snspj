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
	
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css"/>
	<link rel="stylesheet" href="${path}/resources/css/moduleStyle.css">	
	<link rel="stylesheet" href="${path}/resources/css/common.css">
	<link rel="stylesheet" href="${path}/resources/css/bbsStyle.css">
		
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="${path}/resources/js/board.js" type="text/javascript" defer="defer"></script>
	<script src="${path}/resources/js/bookmark.js" type="text/javascript" defer="defer"></script>
	<script src="${path}/resources/js/spt.js" type="text/javascript" defer="defer"></script>
<!--<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>-->
	<script src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
	
	
</head>
<body>
	<%@ include file="../module/side.jsp" %>
	
	<div class="main-content">
		<div class="flex-center logo-wrapper">
			<span class="logo-text">shareTable</span>
		</div>
		
		<div id="bbsContent">
			<br>		
			<br>	
			<table>
				<c:forEach items="${bbsList}" var="bbsList" varStatus="status">	
				
					<tr>
						<td>
							<div class="content-wrapper">
							<!-- 작성자 -->
							<div class="bbs-rgtrId bbs-element">
								<c:out value="${bbsList.rgtrId}" />
							</div>
							<!-- 작성일자 -->
							<div class="bbs-rgtrDt bbs-element">					
								<fmt:formatDate pattern="yyyy/MM/dd" value="${bbsList.rgtrDt}" />
							</div>
							<!-- 첨부파일 -->
					 		<div class="bbs-img-files bbs-element">
								<div class="img-wrapper">
									<c:choose>
										<c:when test='${bbsList.atchFileNo ne 0}'>
											<c:forEach items="${fileList[status.index]}" var="fileList">
												<div class="bbs-img-files">
													<img id="img-file" src="${fileList.atchFilePath}">
												</div>
											</c:forEach>
										</c:when>
										<c:otherwise></c:otherwise>
									</c:choose>		
								</div>	
							<!--<p class="vis-dots">
									<span class="now">01</span>
							        /
							        <span class="tot">03</span>
								</p>	-->							
							</div>
							<div class="user-service-wrapper">
								<!-- 좋아요 -->
							<div class="bbs-heart bbs-element">
								<div class="feed-heart-wrapper${status.index}">
									<c:choose>								
										<c:when test='${sptYn[status.index] eq "Y"}'> <!-- 하트 눌린 상태 -->
											<button type="button" class="feed-heart-btn${status.index} btn heart-icon${status.index}" onclick="fn_updateBbsSpt(${bbsList.bbsId}, '${sptYn[status.index]}', ${status.index})">
												<i class="xi-heart xi-2x"></i>
											</button>
										</c:when>
										<c:otherwise>  <!-- 하트 안 눌린 상태 -->
											<button type="button" class="feed-heart-btn${status.index} btn heart-icon${status.index}" onclick="fn_updateBbsSpt(${bbsList.bbsId}, '${sptYn[status.index]}', ${status.index})">
												<i class=" xi-heart-o xi-2x"></i>
											</button>
										</c:otherwise>
									</c:choose>
									<c:out value="${bbsList.bbsSptCnt}" />
								</div>
							</div>
							
							<!-- 북마크 -->
							<div class="bbs-bmk bbs-element">
								<div class="feed-bmk-wrapper${status.index}">
									<c:choose>								
										<c:when test='${bmkYn[status.index] eq "Y"}'> <!-- 북마크 눌린 상태 -->
											<button type="button" class="feed-bmk-btn${status.index} btn bmk-icon${status.index}" onclick="fn_bmkBbs(${bbsList.bbsId}, '${bmkYn[status.index]}', ${status.index})">
												<i class="xi-bookmark xi-2x"></i>
											</button>
										</c:when>
										<c:otherwise>  <!-- 북마크 안 눌린 상태 -->
											<button type="button" class="feed-bmk-btn${status.index} btn bmk-icon${status.index}" onclick="fn_bmkBbs(${bbsList.bbsId},'${bmkYn[status.index]}', ${status.index})">
												<i class=" xi-bookmark-o xi-2x"></i>
											</button>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
							
							<!-- 장소 태그 -->
							<div class="bbs-place bbs-element">
								<a href="#" onclick="fn_goPlcView(${bbsList.bbsPlc})">${bbsList.bbsPlc}</a>
							</div>
							</div>
							
							
							<!-- 게시글 내용 -->
							<div class="bbs-bbsCn bbs-element">
								<a href="/board/bbsView?bbsId=${bbsList.bbsId}">${bbsList.bbsCn}</a>
							</div>
							
						</div> <!-- content-wrapper -->
						</td>
					</tr>
					
				
				
				</c:forEach>
			</table>
			
	
		
			<div class="loading" id="loading">
				
			</div>
			
		
		</div><!-- //bbs_content -->
	</div>
	


<script>
	$(document).ready(function(){
		$('.img-wrapper').slick();
	});
</script>

</body>
</html>