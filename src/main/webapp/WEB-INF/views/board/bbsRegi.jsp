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
		.btn {border: 0; background-color: transparent;}
	</style>
	
	<link rel="stylesheet" href="${path}/resources/css/moduleStyle.css">
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
	<link rel="stylesheet" href="${path}/resources/css/common.css">
		<link rel="stylesheet" href="${path}/resources/css/bbsStyle.css">
		
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="${path}/resources/js/board.js" type="text/javascript" defer="defer"></script>
	
	
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
			<form id="bbsRegifrm" enctype="multipart/form-data">
				<input type="text" placeholder="작성자" id="rgtrId" name="rgtrId" value="${sessionScope.sessionId}" readonly="readonly">
				<input type="text" placeholder="내용을 입력하세요..." id="bbsCn" name="bbsCn">
				<!-- 장소 태그 -->
				<div class="atch-file-wrapper">
					<label class="control-label" for ="fileupload">첨부 파일</label>
					<input class="form-control funct-button" type="file" id="fileupload" name="fileupload" multiple="multiple" accept="image/*"/>
				</div>
				
				<button type="button" onclick="fn_regiBbs();">작성</button>
				<button type="button" onclick='fn_goBackPg()'>취소</button>
			</form>			
		
		</div><!-- //bbs_content -->	
	</div><!-- main-content -->
	
	

</body>
</html>