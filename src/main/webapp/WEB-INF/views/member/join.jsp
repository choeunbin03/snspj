<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${path}/resources/js/member.js" defer="defer"></script>
<script src="${path}/resources/js/popup.js" defer="defer"></script>

<title>Insert title here</title>
	<style>
		.img_wrapper {width:150px; height:150px; overflow:hidden; margin:0 auto;}
		.profileImg {width:100%; height:100%; border:none;}
	</style>
	<link rel="stylesheet" href="${path}/resources/css/common.css">
	<link rel="stylesheet" href="${path}/resources/css/joinStyle.css">

</head>
<body class="flex-center">
	<div class="join-container">
		<form id="joinFrm" enctype="multipart/form-data">
		
		<div class="flex-center logo-wrapper">
			<span class="logo-text">shareTable</span>
		</div>
		
		<div class="input-wrapper">
			<div class="join-wrapper">
				<label class="control-label" for="mbrNm">이름 입력: </label>
				<input class="form-control join-input" type="text" placeholder="이름을 입력해주세요." id="mbrNm" name="mbrNm">			
			</div>
			<div class="join-wrapper id-wrapper">
				<div class="id-input-wrapper">
					<label class="control-label" for="mbrId">아이디 입력: </label>
					<input class="form-control join-input" type="text" placeholder="아이디를 입력해주세요." id="mbrId" name="mbrId">
				</div>
				<input type="button" class="btn funct-button" onclick="idDpcnChk()" value="아이디 중복 확인"/>
				
			</div>
			<div id="msgId" class="info-wrapper">아이디 중복 확인을 해주세요.</div>
			<div class="join-wrapper">
				<label class="control-label" for="mbrPwd">비밀번호 입력: </label>
				<input class="form-control join-input" type="password" maxlength='13' placeholder="비밀번호를 입력해주세요." id="mbrPwd" name="mbrPwd">
			</div>
			<div class="join-wrapper">
				<label class="control-label" for="chkMbrPwd">비밀번호 확인: </label>
				<input class="form-control join-input" type="password" maxlength='13' placeholder="비밀번호를 한 번 더 입력해주세요." id="chkMbrPwd" name="chkMbrPwd">
			</div>		
			<div class="join-wrapper">
				<label class="control-label" for="mbrRoadAddr">주소 입력: </label>
				<input type="button" class="btnSrchAddr funct-button" onclick="srchAddrPopup()" value="주소 검색"/>
				<div id="callBackDiv">
					<table>					
						<tr><td><label class="control-label" for="mbrRoadAddr">도로명주소</label></td>
							<td><input class="join-input" type="text"  style="width:500px;" id="mbrRoadAddr"  name="mbrRoadAddr" readonly /></td>
						</tr>
						<tr><td><label class="control-label" for="mbrAddrDetail">상세주소</label></td>
							<td><input class="join-input" type="text"  style="width:500px;" id="mbrAddrDetail"  name="mbrAddrDetail" readonly/></td>
						</tr>
						<tr><td><label class="control-label" for="mbrZipNo">우편번호</label></td>
							<td><input class="join-input" type="text"  style="width:500px;" id="mbrZipNo"  name="mbrZipNo" readonly/></td>
						</tr>
						
					</table>
				</div>
			</div>		
			<div class="join-wrapper">
				<label class="control-label" for ="fileupload">프로필 사진</label>
				<input class="form-control funct-button" type="file" id="fileupload" name="fileupload" accept="image/*"/>
			</div>
			
			<div class="img_wrapper">
				<img class="profileImg" />
			</div>
		
		</div>
		
		<div class="flex-center button-wrapper">
			<button class="btn join-button" type="button" id="joinSubmit" onclick="fn_join();">회원가입</button>
			<button class="cancel btn danger-button" type="button" onclick='location.href="/"'>취소</button>
		</div>
		
		
	</form>
	</div>
	
	
<script>
    //이미지 미리보기
//    var sel_file;
 
    $(document).ready(function() {
        $("#fileupload").on("change", handleImgFileSelect);
    });
    
    var filesTempArr = [];
 
    function handleImgFileSelect(e) {
        var files = e.target.files;
        var filesArr = Array.prototype.slice.call(files);
        var filesArrLen = filesArr.length;
		var filesTempArrLen = filesTempArr.length;
		
		for( var i=0; i<filesArrLen; i++ ) {
	        filesTempArr.push(filesArr[i]);
	        $(".img_wrapper").append("<div width="150px" height="150px">" + filesArr[i].name + "</div>");
	    }
	    $(this).val('');

//        filesArr.forEach(function(f) { 
//           sel_file = f;
 
//            var reader = new FileReader();
//            reader.onload = function(e) {
//                $("#img").attr("src", e.target.result);
//            }
//            reader.readAsDataURL(f);
//        });
    }
</script>


<!-- 	
<script>
	$(document).ready(function() {
	    $("#fileupload").on("change", addFiles);
	});
	 
	var filesTempArr = [];

	function addFiles(e){
		var files = e.target.files;
		var filesArr = Array.prototype.slice.call(files);
		var filesArrLen = filesArr.length;
		var filesTempArrLen = filesTempArr.length;
		
		for( var i=0; i<filesArrLen; i++ ) {
	        filesTempArr.push(filesArr[i]);
	        $("#profile").append("<div>" + filesArr[i].name + "<img src=\"/images/deleteImage.png\" onclick=\"deleteFile(event, " + (filesTempArrLen+i)+ ");\"></div>");
	    }
	    $(this).val('');
	}
	
	function deleteFile (eventParam, orderParam) {
		    filesTempArr.splice(orderParam, 1);
		    var innerHtmlTemp = "";
		    var filesTempArrLen = filesTempArr.length;
		    for(var i=0; i<filesTempArrLen; i++) {
		        innerHtmlTemp += "<div>" + filesTempArr[i].name + "<img src=\"/images/deleteImage.png\" onclick=\"deleteFile(event, " + i + ");\"></div>"
		    }
		    $("#profile").html(innerHtmlTemp);
		}


</script> -->
</body>
</html>