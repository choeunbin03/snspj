function fn_login(){
	var mbrId = $("#mbrId").val();
	var mbrPwd = $("#mbrPwd").val();
	
	$.ajax({
		type : "POST",
		url : "/member/login",
		data : {mbrId: mbrId, mbrPwd: mbrPwd},
		success : function(data){
			if(data == "Y"){
				location.href = "/board/bbsList";
			}else{
				alert("아이디 또는 비밀번호가 일치하지 않습니다.");
			}
		},
		error : function(data){
			alert("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
	});
}

function fn_join(){
	var params = $("#joinFrm").serializeArray();
	
	var createForm = document.getElementById("joinFrm");
	var formData = new FormData(createForm );
	
	for(var i=0, filesTempArrLen = filesTempArr.length; i<filesTempArrLen; i++) {
   		formData.append("files", filesTempArr[i]);
	}

	
	if( $("#mbrId").attr("readonly") != 'readonly' ){ // 중복검사를 하지 않은 경우
		alert("아이디 중복검사는 필수 입니다.");
		$("mbrId").focus();
		return;
	}else if( $("#mbrPwd").val() == '' || $("#chkMbrPwd").val() == '' || ( $("#mbrPwd").val() != $("#chkMbrPwd").val() )){
		alert("비밀번호를 확인해주세요.");
	}else if ( $("#mbrNm").val() == ''){
		alert("이름은 필수 입니다");
		$("#mbrNm").focus();
		return;
	}	
	
	$.ajax({
		type : "POST",
		url : "/member/join",
		data : formData,
		processData : false,
		contentType: false,
		success : function(data){
			if(data == "Y"){
				alert("회원가입이 완료되었습니다.");
				location.href = "/";
			}else{
				alert("회원가입이 실패되었습니다.");
			}
		},
		error: function(data){
			alert("문제가 발생하였습니다.");
			console.log(data);
		}
	});
	
}

/*
function fn_join(){
	var params = $("#joinFrm").serializeArray();
	
	if( $("#mbrId").attr("readonly") != 'readonly' ){ // 중복검사를 하지 않은 경우
		alert("아이디 중복검사는 필수 입니다.");
		$("mbrId").focus();
		return;
	}else if( $("#mbrPwd").val() == '' || $("#chkMbrPwd").val() == '' || ( $("#mbrPwd").val() != $("#chkMbrPwd").val() )){
		alert("비밀번호를 확인해주세요.");
	}else if ( $("#mbrNm").val() == ''){
		alert("이름은 필수 입니다");
		$("#mbrNm").focus();
		return;
	}	
	
	$.ajax({
		type : "POST",
		url : "/member/join",
		data : params,
		success : function(data){
			if(data == "Y"){
				alert("회원가입이 완료되었습니다.");
				location.href = "/";
			}else{
				alert("회원가입이 실패되었습니다.");
			}
		},
		error: function(data){
			alert("문제가 발생하였습니다.");
			console.log(data);
		}
	});
	
}
*/

function idDpcnChk(){
	var mbrId = $("#mbrId").val();

	if( mbrId == '' || mbrId.length < 4 ) {
		$("#mbrId").focus(); // 포커싱함수
		alert("아이디 형식을 확인하세요");
		return; // 함수 종료
    };

	$.ajax({
		type : "post",
		url : "/member/join/idDpcnChk",
		data :{mbrId : mbrId},
		success : function(data) {
	
			if(data == "ok"){ // 사용가능
				$("#mbrId").attr("readonly", true); // 리드온리 속성지정
				$("#msgId").html("사용가능한 아이디 입니다");
			} else { // 중복
				$("#msgId").html("중복된 아이디입니다");
			}
	
		},
		error : function(status, error) {
			alert("서버문제가 발생했습니다. 관리자에게 문의하세요.");
		}
	});

}
	