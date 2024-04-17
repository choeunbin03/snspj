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
		#totalContainer {display:flex; height:100%;}
		#srchContent {width:250px; display:block; border-right:1px solid #E2E2E2; height:100%; overflow:auto;}
		#srchResult {width:65%; height:100%;}
		#srchResultProfile {width:200px; height:200px;} 
	</style>
	
	<link rel="stylesheet" href="${path}/resources/css/moduleStyle.css">
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
		
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="${path}/resources/js/search.js" type="text/javascript" defer="defer"></script>
	<script src="${path}/resources/js/bookmark.js" type="text/javascript" defer="defer"></script>
	<script src="${path}/resources/js/spt.js" type="text/javascript" defer="defer"></script>
	
</head>
<body>
	<div id="totalContainer">
		<%@ include file="../module/side.jsp" %>
		
		<div id="srchContent">
			<form id="srchFrm">
			<div id="srchFrm">
				<br><br>
				<h3><strong>검색</strong></h3>		
				<input type="text" size="20" id="keyWd" name="keyWd" value="${keyWd}"/>&nbsp;
				<button type="button" onclick="fn_srch()">검색</button>	
			</div>
			</form>
				
			<br><br>
			
			<div id="searchList">
			<p>최근 검색 항목</p>
			
			</div>
		</div><!-- //srchContent -->
		<button type="button" id="srchSlideBtn">&lt;</button>
		
		<div id="srchResult">
			<div id="mbrContent">
				<img id="srchResultProfile" src="/search/display?path=${srchMbrInfo.mbrProflPath}">
				<div>${srchMbrInfo.mbrId}</div>
				<div>게시물 ${srchMbrInfo.mbrBbsCnt}	팔로워 ${srchMbrInfo.mbrFlwrCnt}	팔로우 ${srchMbrInfo.mbrFlwngCnt}</div>
				<div class="button-wrapper">
					<c:choose>
						<c:when test='${fllwYn eq "Y"}'>
							<button type="button" class="follow-btn btn" onclick="fn_follow(${srchMbrInfo.mbrId})">팔로잉</button>
						</c:when>
						<c:otherwise>
							<button type="button" class="follow-btn btn" onclick="fn_follow(${srchMbrInfo.mbrId})">팔로우</button>
						</c:otherwise>
					</c:choose>
				</div>
				
				<div>${srchMbrInfo.mbrIntrcn}</div>
			</div><!-- mbrContent -->
			<br><br><hr><br><br>
			
			<div id="bbsContent">		
			<table>
				<tbody>
					<c:forEach items="${bbsList}" var="bbsList" varStatus="status">
						<tr>
							<td><c:out value="${bbsList.rgtrId}" /></td>
							<td><fmt:formatDate pattern="yyyy/MM/dd" value="${bbsList.rgtrDt}" /></td>
							<!-- 첨부파일 자리 -->
							<!-- 좋아요 -->
							<td class="feed-heart-wrapper${status.index}">
								<c:choose>								
									<c:when test='${sptYn[status.index] eq "Y"}'> <!-- 하트 눌린 상태 -->
										<button type="button" class="feed-heart-btn${status.index} btn" onclick="fn_updateBbsSpt(${bbsList.bbsId}, '${sptYn[status.index]}', ${status.index})">
											<i class="xi-heart xi-2x"></i>
										</button>
									</c:when>
									<c:otherwise>  <!-- 하트 안 눌린 상태 -->
										<button type="button" class="feed-heart-btn${status.index} btn" onclick="fn_updateBbsSpt(${bbsList.bbsId}, '${sptYn[status.index]}', ${status.index})">
											<i class=" xi-heart-o xi-2x"></i>
										</button>
									</c:otherwise>
								</c:choose>
							</td>
							<!-- 북마크 -->
							<td class="feed-bmk-wrapper${status.index}">
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
							</td>
							<td><a href="#" onclick="fn_goPlcView(${bbsList.bbsPlc})">${bbsList.bbsPlc}</a></td>
							<td><a href="/board/bbsView?bbsId=${bbsList.bbsId}">${bbsList.bbsCn}</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div><!-- bbsContent -->
		</div>	<!-- srchResult -->
			
	</div><!-- totalContainer -->
	
<%-- 이거 때문에,,,, 굉장히 고생함. 화면을 비워주기 때문에 조심해주기. servlet이 충돌됐다고 오류 떴을 때 넣었지만
	 나중에 코드 수정하고 나서 빈 화면 뜨면 이거 지우기,,,,,,
	<% 
		out.clear();
		out=pageContext.pushBody();
	%> --%>

<script>
	var srchSlideBtn = document.querySelector('#srchSlideBtn');
	
	srchSlideBtn.addEventListener('click', function(){
		var slideDiv = document.querySelector('#srchContent');
		if(slideDiv.style.display == 'none'){
			slideDiv.style.display = 'block';
			srchSlideBtn.innerText = '<';
		}else{
			slideDiv.style.display = 'none'
			srchSlideBtn.innerText = '>';
		}
	})

</script>


</body>
</html>