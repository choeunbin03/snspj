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
		
	</style>
	
	<link rel="stylesheet" href="${path}/resources/css/moduleStyle.css">
		
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="${path}/resources/js/search.js" type="text/javascript" defer="defer"></script>
	
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
				<div>${srchMbrInfo.mbrId}</div>
				<div>게시물 ${srchMbrInfo.mbrBbsCnt}	팔로워 ${srchMbrInfo.mbrFlwrCnt}	팔로우 ${srchMbrInfo.mbrFlwngCnt}</div>
				<div>${srchMbrInfo.mbrIntrcn}</div>
			</div><!-- mbrContent -->
			<br><br><hr><br><br>
			
			<div id="bbsContent">		
			<table>
				<tbody>
					<c:forEach items="${bbsList}" var="bbsList">
						<tr>
							<td><c:out value="${bbsList.rgtrId}" /></td>
							<td><fmt:formatDate pattern="yyyy/MM/dd" value="${bbsList.rgtrDt}" /></td>
							<!-- 첨부파일 자리 -->
							<!-- 좋아요 자리 -->
							<!-- 북마크 자리 -->
							<td><a href="#" onclick="fn_goPlcView(${bbsList.bbsPlc})">${bbsList.bbsPlc}</a></td>
							<td><a href="/board/bbsView?bbsId=${bbsList.bbsId}">${bbsList.bbsCn}</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div><!-- bbsContent -->
		</div>	<!-- srchResult -->
			
	</div><!-- totalContainer -->
	


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