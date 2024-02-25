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
</head>
<body>
	<form id="joinFrm">
		
		<div class="joinInput">
			<label class="control-label" for="mbrNm">이름 입력: </label>
			<input class="form-control" type="text" placeholder="이름을 입력해주세요." id="mbrNm" name="mbrNm">			
		</div>
		<div class="joinInput">
			<label class="control-label" for="mbrId">아이디 입력: </label>
			<input class="form-control" type="text" placeholder="아이디를 입력해주세요." id="mbrId" name="mbrId">
			<input type="button" class="idDpcnChk" onclick="idDpcnChk()" value="아이디 중복 확인"/>
			<p id="msgId" name="msgId">아이디 중복 확인을 해주세요.</p>
		</div>
		<div class="joinInput">
			<label class="control-label" for="mbrPwd">비밀번호 입력: </label>
			<input class="form-control" type="password" maxlength='13' placeholder="비밀번호를 입력해주세요." id="mbrPwd" name="mbrPwd">
		</div>
		<div class="joinInput">
			<label class="control-label" for="chkMbrPwd">비밀번호 확인: </label>
			<input class="form-control" type="password" maxlength='13' placeholder="비밀번호를 한 번 더 입력해주세요." id="chkMbrPwd" name="chkMbrPwd">
		</div>		
		<div class="joinInput">
			<label class="control-label" for="mbrRoadAddr">주소 입력: </label>
			<input class="form-control" type="text" placeholder="주소를 입력해주세요." id="btnSrchAddr" name="btnSrchAddr" readonly>
			<input type="button" class="btnSrchAddr" onclick="srchAddrPopup()" value="주소 검색"/>
			<div id="callBackDiv">
				<table>					
					<tr><td>도로명주소           </td><td><input type="text"  style="width:500px;" id="mbrRoadAddr"  name="mbrRoadAddr" readonly /></td></tr>
					<tr><td>고객입력 상세주소    </td><td><input type="text"  style="width:500px;" id="mbrAddrDetail"  name="mbrAddrDetail" readonly/></td></tr>
					<tr><td>우편번호             </td><td><input type="text"  style="width:500px;" id="mbrZipNo"  name="mbrZipNo" readonly/></td></tr>
					
				</table>
			</div>
		</div>		
		<div class="joinInput">
			<label class="control-label" for ="fileupload">프로필 사진</label>
			<input class="form-control" type="file" id="fileupload" name="fileupload" accept="image/*"/>
			<div id="profile"></div>
		</div>
		
		<div class="joinInput">
			<button class="btn btn-success" type="button" id="joinSubmit" onclick="fn_join();">회원가입</button>
			<button class="cencle btn btn-danger" type="button">취소</button>
		</div>
		
	</form>
	
	
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


</script>
</body>
</html>